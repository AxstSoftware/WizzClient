package io.github.axst.module.misc

import io.github.axst.module.render.ModuleRenderer
import io.github.axst.module.settings.misc.BooleanSettings
import io.github.axst.utils.IWizz.Companion.font

class RenderModule : ModuleRenderer("test", "test", 10, 20) {

    private val test: BooleanSettings = BooleanSettings("Some test", "Test Settings", true)

    init {
        addSettings(test)
    }

    override fun drawOverlayModule() {
        if (test.isEnabled()) {
            font.drawString(name, getX(), getY(), -1)
        }
    }

    override fun drawScreenModule(mouseX: Int, mouseY: Int) {
        super.drawScreenModule(mouseX, mouseY)
        font.drawString(name, getX(), getY(), -1)
    }

    override fun getWidthIn(): Int {
        if (test.isEnabled()) {
            return font.getStringWidth(name+"LOL")
        }
        return font.getStringWidth(name)
    }

    override fun getHeightIn(): Int {
        return font.FONT_HEIGHT
    }
}