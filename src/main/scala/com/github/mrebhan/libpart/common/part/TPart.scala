package com.github.mrebhan.libpart.common.part

import com.github.mrebhan.libpart.common.Registry
import com.github.mrebhan.libpart.common.block.TilePart
import mcmultipart.api.slot.IPartSlot
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos

/**
  * Created by marco on 24.02.17.
  */
trait TPart extends IPart with TPartUtils {

  private var container: TilePart = _

  override def setContainer(pt: TilePart): TPart = {
    container = pt
    this
  }

  override def getContainer: TilePart = container

  override def getType: ResourceLocation = Registry.getPartType(getClass)

  override def getSlot: IPartSlot = ???

  def getTileAt(pos: BlockPos): TilePart = super.getTileAt(getWorld, pos, warn = false)

  def getPartAt(pos: BlockPos): IPart = super.getPartAt(getWorld, pos, warn = false, giveMeDefault = false)

  override def defaultPart: IPart = null

}

/**
  * Java compatibility class
  */

abstract class PartImpl extends TPart