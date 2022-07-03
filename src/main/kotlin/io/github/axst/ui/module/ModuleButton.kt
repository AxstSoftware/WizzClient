package io.github.axst.ui.module

import io.github.axst.module.Module
import io.github.axst.utils.IWizz
import io.github.axst.utils.RenderUtils
import java.awt.Color

class ModuleButton(private val x: Int, private val y: Int, private val widthIn: Int, private val heightIn: Int, module: Module) {

    private var mod: Module? = null

    init {
        this.mod = module
    }

    fun drawButton() {
        IWizz.font.drawStringWithShadow(
            if (mod!!.isEnabled()) "E N A B L E D" else "D I S A B L E D",
            (x + widthIn / 3 - IWizz.font.getStringWidth(if (mod!!.isEnabled()) "E N A B L E D" else "D I S A B L E D") / 2).toFloat(),
            (y + heightIn - 18 / 2 - IWizz.font.FONT_HEIGHT / 2).toFloat(),
            -1
        )
        RenderUtils.drawSmoothRoundedRect(RenderUtils(), x + widthIn - 120, y + 98, x + widthIn, y + heightIn, 14, getColor())
    }

    private fun getColor(): Int {
        return if (mod!!.isEnabled()) {
            Color(170, 40, 73).rgb
        } else {
            Color(170, 40, 73).rgb
        }
    }

    fun onClick(mouseX: Int, mouseY: Int, button: Int) {
        if (mouseX >= x + widthIn - 120 && mouseX <= x + widthIn && mouseY >= y + 94 && mouseY <= y + heightIn) {
            if(button == 1) mod!!.toggleModule()
        }
    }
}