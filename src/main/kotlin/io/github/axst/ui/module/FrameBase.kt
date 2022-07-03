package io.github.axst.ui.module

import io.github.axst.WizzCore
import io.github.axst.module.Module
import io.github.axst.utils.IWizz

class FrameBase(val x: Int, val y: Int, val widthIn: Int, val heightIn: Int) {

    private var type: FrameType = FrameType.MODULE

    private var mod: Module? = null

    var modButtons: ArrayList<ModuleButton> = ArrayList()

    var scrollAmount = 0

    fun drawScreen(mouseX: Int, mouseY: Int) {
        if (type == FrameType.MODULE) {
            modButtons.clear()
            IWizz.font.drawString("test", 100, 100, -1)
            var xAdd = 0
            val xFactor = 125
            var yAdd = 0
            var spots = 0
            while (spots * xFactor < 350) {
                spots++
            }
            for (module in WizzCore.instance.moduleManager.module) {
                if (xAdd == spots * xFactor && xAdd != 0) {
                    xAdd = 0
                    yAdd += 123
                }
                modButtons.add(ModuleButton(x + 165 + xAdd, y + 60 + yAdd + scrollAmount, 90, 115, module))
                xAdd += xFactor
            }
            modButtons.forEach { moduleButton -> moduleButton.drawButton() }
        } else if (type == FrameType.TEST) {
            IWizz.font.drawString("test2", 100, 100, -1)
        }
    }

    fun setType(frameType: FrameType, module: Module) {
        if (frameType === FrameType.MODULE) {
            type = FrameType.MODULE
            this.mod = null
        } else if (frameType === FrameType.TEST) {
            type = FrameType.TEST
            this.mod = module
        }
    }

    fun mouseClicked(mouseX: Int, mouseY: Int, mouseButton: Int) {
        modButtons.forEach { moduleButton: ModuleButton -> moduleButton.onClick(mouseX, mouseY, mouseButton) }
    }

}