package io.github.axst.module.misc

import io.github.axst.module.render.ModuleRenderer

class RenderModule : ModuleRenderer("test", "test", 10, 20) {

    override fun drawOverlayModule() {
        minecraft.fontRendererObj.drawString(name, getX(), getY(), -1)
    }

    override fun drawScreenModule(mouseX: Int, mouseY: Int) {
        super.drawScreenModule(mouseX, mouseY)
        minecraft.fontRendererObj.drawString(name, getX(), getY(), -1)
    }

    override fun getWidthIn(): Int {
        return minecraft.fontRendererObj.getStringWidth(name)
    }

    override fun getHeightIn(): Int {
        return minecraft.fontRendererObj.FONT_HEIGHT
    }
}