package net.minecraft.network.handshake.client;

import java.io.IOException;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.handshake.INetHandlerHandshakeServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class C00Handshake implements Packet
{
    private int protocolVersion;
    private String ip;
    private int port;
    private EnumConnectionState requestedState;
    private static final String __OBFID = "CL_00001372";
    private boolean hasFMLMarker = false;

    public C00Handshake() {}

    @SideOnly(Side.CLIENT)
    public C00Handshake(int version, String ip, int port, EnumConnectionState requestedState)
    {
        this.protocolVersion = version;
        this.ip = ip;
        this.port = port;
        this.requestedState = requestedState;
    }

    public C00Handshake(int protocol, String address, int port, EnumConnectionState state, boolean addFMLMarker)
    {
        this(protocol, address, port, state);
        this.hasFMLMarker = addFMLMarker;
    }

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.protocolVersion = buf.readVarIntFromBuffer();
        this.ip = buf.readStringFromBuffer(255);
        this.port = buf.readUnsignedShort();
        this.requestedState = EnumConnectionState.getById(buf.readVarIntFromBuffer());
        this.hasFMLMarker = this.ip.contains("\0FML\0");
        this.ip = this.ip.split("\0")[0];
    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public void writePacketData(PacketBuffer buf) throws IOException
    {
        buf.writeVarIntToBuffer(this.protocolVersion);
        buf.writeString(this.ip + "\0FML\0");
        buf.writeShort(this.port);
        buf.writeVarIntToBuffer(this.requestedState.getId());
    }

    public void handle(INetHandlerHandshakeServer handler)
    {
        handler.processHandshake(this);
    }

    public EnumConnectionState getRequestedState()
    {
        return this.requestedState;
    }

    public int getProtocolVersion()
    {
        return this.protocolVersion;
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandler handler)
    {
        this.handle((INetHandlerHandshakeServer)handler);
    }

    public boolean hasFMLMarker()
    {
        return this.hasFMLMarker;
    }
}