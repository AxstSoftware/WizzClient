package io.github.axst.module.render

import org.lwjgl.input.Mouse

class DraggableComponent(var x: Int, var y: Int, private val widthIn: Int, private val heightIn: Int) {

    private var lastX = 0
    private var lastY = 0
    private var draggingModule = false

    fun isDraggingModule(mouseX: Int, mouseY: Int): Boolean {
        if (draggingModule) {
            x = mouseX + lastX
            y = mouseY + lastY
            if (!Mouse.isButtonDown(0)) draggingModule = false
        }
        val mouseOverX = mouseX >= this.x && mouseX <= this.x + this.widthIn
        val mouseOverY = mouseY >= this.y && mouseY <= this.y + this.heightIn
        if (mouseOverX && mouseOverY) {
            if (Mouse.isButtonDown(0)) {
                if (!draggingModule) {
                    lastX = x - mouseX
                    lastY = y - mouseY
                    draggingModule = true
                }
            }
        }
        return draggingModule
    }
}