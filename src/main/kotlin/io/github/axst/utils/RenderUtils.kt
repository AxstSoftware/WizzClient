package io.github.axst.utils

import net.minecraft.client.gui.Gui

class RenderUtils {
    companion object {
        @JvmStatic
        fun drawHollowRect(x: Int, y: Int, w: Int, h: Int, color: Int) {
            drawHorizontalLine(x, x + w, y, color)
            drawHorizontalLine(x, x + w, y + h, color)
            drawVerticalLine(x, y + h, y, color)
            drawVerticalLine(x + w, y + h, y, color)
        }
        private fun drawHorizontalLine(startX: Int, endX: Int, y: Int, color: Int) {
            var startX = startX
            var endX = endX
            if (endX < startX) {
                val i = startX
                startX = endX
                endX = i
            }
            Gui.drawRect(startX, y, endX + 1, y + 1, color)
        }

        private fun drawVerticalLine(x: Int, startY: Int, endY: Int, color: Int) {
            var startY = startY
            var endY = endY
            if (endY < startY) {
                val i = startY
                startY = endY
                endY = i
            }
            Gui.drawRect(x, startY + 1, x + 1, endY, color)
        }
    }
}