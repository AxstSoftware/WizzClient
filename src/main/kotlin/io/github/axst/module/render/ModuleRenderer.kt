package io.github.axst.module.render

import io.github.axst.module.Module
import io.github.axst.utils.RenderUtils
import java.awt.Color

abstract class ModuleRenderer(name: String, description: String, x: Int, y: Int)
    : Module(name, description) {

    private var draggableComponent: DraggableComponent

    private var widthIn: Int = 0

    private var heightIn: Int = 0

    init {
        draggableComponent = DraggableComponent(x, y, this.getWidthIn(), this.getHeightIn())
    }

    abstract fun drawOverlayModule()

    open fun drawScreenModule(mouseX: Int, mouseY: Int) {
        val hovered =
            mouseX >= this.getX() && mouseX <= this.getY() + this.getWidthIn() && mouseY >= this.getY() && mouseY <= this.getY() + this.getHeightIn()
        if (hovered) RenderUtils.drawHollowRect(
            this.getX() - 2,
            this.getY() - 2,
            this.getWidthIn() + 3,
            this.getHeightIn() + 2,
            Color(0, 204, 255, 152).rgb
        )

        RenderUtils.drawHollowRect(
            this.getX() - 2,
            this.getY() - 2,
            this.getWidthIn() + 3,
            this.getWidthIn() + 2,
            Color(170, 170, 170, 100).rgb
        )
    }

    open fun getWidthIn(): Int {
        return widthIn
    }

    open fun getHeightIn(): Int {
        return heightIn
    }

    protected fun getX(): Int {
        return draggableComponent.x
    }

    protected fun getY(): Int {
        return draggableComponent.y
    }
}