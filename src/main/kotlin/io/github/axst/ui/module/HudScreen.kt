package io.github.axst.ui.module

import io.github.axst.module.render.ModuleRenderer
import net.minecraft.client.gui.GuiScreen

class HudScreen : GuiScreen() {
    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        ModuleRenderer.renderComponent(mouseX, mouseY)
    }

    override fun doesGuiPauseGame(): Boolean {
        return false
    }
}