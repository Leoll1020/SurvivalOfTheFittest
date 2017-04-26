package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class S1EPacketRemoveEntityEffect implements Packet
{
    private int field_149079_a;
    private int field_149078_b;
    private static final String __OBFID = "CL_00001321";

    public S1EPacketRemoveEntityEffect() {}

    public S1EPacketRemoveEntityEffect(int p_i45212_1_, PotionEffect p_i45212_2_)
    {
        this.field_149079_a = p_i45212_1_;
        this.field_149078_b = p_i45212_2_.getPotionID();
    }

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.field_149079_a = buf.readVarIntFromBuffer();
        this.field_149078_b = buf.readUnsignedByte();
    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public void writePacketData(PacketBuffer buf) throws IOException
    {
        buf.writeVarIntToBuffer(this.field_149079_a);
        buf.writeByte(this.field_149078_b);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandlerPlayClient handler)
    {
        handler.handleRemoveEntityEffect(this);
    }

    @SideOnly(Side.CLIENT)
    public int func_149076_c()
    {
        return this.field_149079_a;
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandler handler)
    {
        this.processPacket((INetHandlerPlayClient)handler);
    }

    @SideOnly(Side.CLIENT)
    public int func_149075_d()
    {
        return this.field_149078_b;
    }
}