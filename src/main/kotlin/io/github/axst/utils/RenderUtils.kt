package io.github.axst.utils

import net.minecraft.client.gui.Gui

class RenderUtils {
    companion object {
        @JvmStatic
        fun drawHollowRect(renderUtils: RenderUtils, x: Int, y: Int, w: Int, h: Int, color: Int) {
            renderUtils.drawHorizontalLine(x, x + w, y, color)
            renderUtils.drawHorizontalLine(x, x + w, y + h, color)
            renderUtils.drawVerticalLine(x, y + h, y, color)
            renderUtils.drawVerticalLine(x + w, y + h, y, color)
        }
    }

    private fun drawHorizontalLine(startX: Int, endX: Int, y: Int, color: Int) {
        if (endX < startX) {
            val i: Int = startX
            endX.compareTo(i)
        }
        Gui.drawRect(startX, y, endX + 1, y + 1, color)
    }

    private fun drawVerticalLine(x: Int, startY: Int, endY: Int, color: Int) {
        if (endY < startY) {
            val i: Int = startY
            endY.compareTo(i)
        }
        Gui.drawRect(x, startY + 1, x + 1, endY, color)
    }
}