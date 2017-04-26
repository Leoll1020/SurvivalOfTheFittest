//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.04 at 01:44:23 PM PDT 
//


package com.microsoft.Malmo.Schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://ProjectMalmo.microsoft.com}AgentStart"/>
 *         &lt;element ref="{http://ProjectMalmo.microsoft.com}AgentHandlers"/>
 *       &lt;/sequence>
 *       &lt;attribute name="mode" type="{http://ProjectMalmo.microsoft.com}GameMode" default="Survival" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "agentStart",
    "agentHandlers"
})
@XmlRootElement(name = "AgentSection")
public class AgentSection {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "AgentStart", required = true)
    protected AgentStart agentStart;
    @XmlElement(name = "AgentHandlers", required = true)
    protected AgentHandlers agentHandlers;
    @XmlAttribute(name = "mode")
    protected GameMode mode;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the agentStart property.
     * 
     * @return
     *     possible object is
     *     {@link AgentStart }
     *     
     */
    public AgentStart getAgentStart() {
        return agentStart;
    }

    /**
     * Sets the value of the agentStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgentStart }
     *     
     */
    public void setAgentStart(AgentStart value) {
        this.agentStart = value;
    }

    /**
     * Gets the value of the agentHandlers property.
     * 
     * @return
     *     possible object is
     *     {@link AgentHandlers }
     *     
     */
    public AgentHandlers getAgentHandlers() {
        return agentHandlers;
    }

    /**
     * Sets the value of the agentHandlers property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgentHandlers }
     *     
     */
    public void setAgentHandlers(AgentHandlers value) {
        this.agentHandlers = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link GameMode }
     *     
     */
    public GameMode getMode() {
        if (mode == null) {
            return GameMode.SURVIVAL;
        } else {
            return mode;
        }
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link GameMode }
     *     
     */
    public void setMode(GameMode value) {
        this.mode = value;
    }

}
