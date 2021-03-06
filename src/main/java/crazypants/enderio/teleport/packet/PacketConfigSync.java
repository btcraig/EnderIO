package crazypants.enderio.teleport.packet;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import crazypants.enderio.config.Config;

public class PacketConfigSync implements IMessage, IMessageHandler<PacketConfigSync, IMessage> {

  @Override
  public void toBytes(ByteBuf buf) {
    buf.writeBoolean(Config.travelAnchorEnabled);
    buf.writeInt(Config.travelAnchorMaxDistance);
    buf.writeBoolean(Config.travelStaffEnabled);
    buf.writeBoolean(Config.travelStaffBlinkEnabled);
    buf.writeBoolean(Config.travelStaffBlinkThroughSolidBlocksEnabled);
    buf.writeBoolean(Config.travelStaffBlinkThroughClearBlocksEnabled);
    buf.writeInt(Config.travelStaffBlinkPauseTicks);
    buf.writeInt(Config.travelStaffMaxDistance);
    buf.writeInt(Config.travelStaffMaxBlinkDistance);
    buf.writeFloat(Config.travelStaffPowerPerBlockRF);
  }

  @Override
  public void fromBytes(ByteBuf data) {
    Config.travelAnchorEnabled = data.readBoolean();
    Config.travelAnchorMaxDistance = data.readInt();
    Config.travelStaffEnabled = data.readBoolean();
    Config.travelStaffBlinkEnabled = data.readBoolean();
    Config.travelStaffBlinkThroughSolidBlocksEnabled = data.readBoolean();
    Config.travelStaffBlinkThroughClearBlocksEnabled = data.readBoolean();
    Config.travelStaffBlinkPauseTicks = data.readInt();
    Config.travelStaffMaxDistance = data.readInt();
    Config.travelStaffMaxBlinkDistance = data.readInt();
    Config.travelStaffPowerPerBlockRF = data.readFloat();
  }

  @Override
  public IMessage onMessage(PacketConfigSync message, MessageContext ctx) {
    return null;
  }
}
