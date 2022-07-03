package io.github.axst.utils

import net.minecraft.client.gui.Gui
import net.minecraft.client.renderer.GlStateManager
import org.lwjgl.opengl.GL11
import kotlin.math.cos
import kotlin.math.sin

@Suppress("NAME_SHADOWING")
class RenderUtils {
    companion object {
        @JvmStatic
        fun drawHollowRect(renderUtils: RenderUtils, x: Int, y: Int, w: Int, h: Int, color: Int) {
            renderUtils.drawHorizontalLine(x, x + w, y, color)
            renderUtils.drawHorizontalLine(x, x + w, y + h, color)
            renderUtils.drawVerticalLine(x, y + h, y, color)
            renderUtils.drawVerticalLine(x + w, y + h, y, color)
        }

        @JvmStatic
        fun drawSmoothRoundedRect(renderUtils: RenderUtils, x: Int, y: Int, x1: Int, y1: Int, radius: Int, color: Int) {
            var x = x
            var y = y
            var x1 = x1
            var y1 = y1
            GL11.glPushAttrib(0)
            GL11.glScaled(0.5, 0.5, 0.5)
            x *= 2
            y *= 2
            x1 *= 2
            y1 *= 2
            GL11.glEnable(GL11.GL_BLEND)
            GL11.glDisable(GL11.GL_TEXTURE_2D)
            GL11.glEnable(GL11.GL_LINE_SMOOTH)
            renderUtils.setColor(color)
            GL11.glEnable(GL11.GL_LINE_SMOOTH)
            GL11.glBegin(GL11.GL_POLYGON)
            var i = 0
            while (i <= 90) {
                GL11.glVertex2d(
                    x + radius + sin(i * Math.PI / 180.0) * radius * -1.0,
                    y + radius + cos(i * Math.PI / 180.0) * radius * -1.0
                )
                i += 3
            }
            i = 90
            while (i <= 180) {
                GL11.glVertex2d(
                    x + radius + sin(i * Math.PI / 180.0) * radius * -1.0,
                    y1 - radius + cos(i * Math.PI / 180.0) * radius * -1.0
                )
                i += 3
            }
            i = 0
            while (i <= 90) {
                GL11.glVertex2d(
                    x1 - radius + sin(i * Math.PI / 180.0) * radius,
                    y1 - radius + cos(i * Math.PI / 180.0) * radius
                )
                i += 3
            }
            i = 90
            while (i <= 180) {
                GL11.glVertex2d(
                    x1 - radius + sin(i * Math.PI / 180.0) * radius,
                    y + radius + cos(i * Math.PI / 180.0) * radius
                )
                i += 3
            }
            GL11.glEnd()
            GL11.glBegin(GL11.GL_LINE_LOOP)
            i = 0
            while (i <= 90) {
                GL11.glVertex2d(
                    x + radius + sin(i * Math.PI / 180.0) * radius * -1.0,
                    y + radius + cos(i * Math.PI / 180.0) * radius * -1.0
                )
                i += 3
            }
            i = 90
            while (i <= 180) {
                GL11.glVertex2d(
                    x + radius + sin(i * Math.PI / 180.0) * radius * -1.0,
                    y1 - radius + cos(i * Math.PI / 180.0) * radius * -1.0
                )
                i += 3
            }
            i = 0
            while (i <= 90) {
                GL11.glVertex2d(
                    x1 - radius + sin(i * Math.PI / 180.0) * radius,
                    y1 - radius + cos(i * Math.PI / 180.0) * radius
                )
                i += 3
            }
            i = 90
            while (i <= 180) {
                GL11.glVertex2d(
                    x1 - radius + sin(i * Math.PI / 180.0) * radius,
                    y + radius + cos(i * Math.PI / 180.0) * radius
                )
                i += 3
            }
            GL11.glEnd()
            GL11.glEnable(GL11.GL_TEXTURE_2D)
            GL11.glDisable(GL11.GL_BLEND)
            GL11.glDisable(GL11.GL_LINE_SMOOTH)
            GL11.glDisable(GL11.GL_LINE_SMOOTH)
            GL11.glEnable(GL11.GL_TEXTURE_2D)
            GL11.glScaled(2.0, 2.0, 2.0)
            GL11.glPopAttrib()
            GL11.glLineWidth(1f)
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f)
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

    fun setColor(color: Int) {
        val a = (color shr 24 and 0xFF) / 255.0f
        val r = (color shr 16 and 0xFF) / 255.0f
        val g = (color shr 8 and 0xFF) / 255.0f
        val b = (color and 0xFF) / 255.0f
        GL11.glColor4f(r, g, b, a)
    }
}