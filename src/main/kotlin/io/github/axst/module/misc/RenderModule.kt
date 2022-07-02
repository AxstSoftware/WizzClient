package io.github.axst.module.misc

import io.github.axst.module.render.ModuleRenderer
import net.minecraft.client.Minecraft

class RenderModule : ModuleRenderer("test", "test", 10, 20) {
    override fun drawOverlayModule() {
        minecraft.fontRendererObj.drawString(this.name, this.getX(), this.getY(), -1)
    }

    override fun getWidthIn(): Int {
        return Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.name)
    }

    override fun getHeightIn(): Int {
        return minecraft.fontRendererObj.FONT_HEIGHT
    }
}