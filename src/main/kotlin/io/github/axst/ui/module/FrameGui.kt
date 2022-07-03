package io.github.axst.ui.module

import net.minecraft.client.gui.GuiScreen

class FrameGui : GuiScreen() {

    var frameBase: FrameBase? = null

    override fun initGui() {
        frameBase = FrameBase(this.width / 2 - 225, this.height / 2 - 150, this.width / 2 + 225, this.height / 2 + 150)
    }

    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        super.drawScreen(mouseX, mouseY, partialTicks)
        frameBase!!.drawScreen(mouseX, mouseY)
    }

    override fun doesGuiPauseGame(): Boolean {
        return false
    }

    override fun mouseClicked(mouseX: Int, mouseY: Int, mouseButton: Int) {
        super.mouseClicked(mouseX, mouseY, mouseButton)
        frameBase!!.mouseClicked(mouseX, mouseX, mouseButton)
    }
}