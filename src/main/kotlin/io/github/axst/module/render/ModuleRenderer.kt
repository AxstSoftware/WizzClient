package io.github.axst.module.render

import io.github.axst.WizzCore
import io.github.axst.module.Module
import io.github.axst.utils.RenderUtils
import java.awt.Color
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

abstract class ModuleRenderer(name: String, description: String, x: Int, y: Int)
    : Module(name, description) {

    private lateinit var draggableComponent: DraggableComponent

    private var widthIn: Int = 0

    private var heightIn: Int = 0

    init {
        val executor = ScheduledThreadPoolExecutor(1)
        executor.schedule({ draggableComponent = DraggableComponent(x, y, getWidthIn(), getHeightIn()) }, 3, TimeUnit.SECONDS)
    }

    abstract fun drawOverlayModule()

    open fun drawScreenModule(mouseX: Int, mouseY: Int) {
        val hovered = mouseX >= this.getX() && mouseX <= this.getX() + this.getWidthIn() && mouseY >= this.getY() && mouseY <= this.getY() + this.getHeightIn()
        if (hovered) RenderUtils.drawHollowRect(
            RenderUtils(), this.getX() - 2,
            this.getY() - 2,
            this.getWidthIn() + 3,
            this.getHeightIn() + 2,
            Color(0, 204, 255, 152).rgb
        )

        if (hovered) RenderUtils.drawHollowRect(
            RenderUtils(), this.getX() - 2,
            this.getY() + 2,
            this.getWidthIn() - 3,
            this.getHeightIn() + 2,
            Color(0, 204, 255, 152).rgb
        )
    }

    companion object {
        private var lastDraggedMod = 0
        fun renderComponent(mouseX: Int, mouseY: Int) {
            var doDrag = true
            for (module in WizzCore.instance.moduleManager.module) {
                if (module.isEnabled() && module is ModuleRenderer) {
                    module.drawScreenModule(mouseX, mouseY)
                    if (module.hashCode() == lastDraggedMod && module.draggableComponent.isDraggingModule(
                            mouseX,
                            mouseY
                        )
                    ) doDrag = false
                }
            }
            for (module in WizzCore.instance.moduleManager.module) {
                if (doDrag && module.isEnabled() && module is ModuleRenderer && module.draggableComponent.isDraggingModule(
                        mouseX,
                        mouseY
                    )
                ) {
                    doDrag = false
                    lastDraggedMod = module.hashCode()
                }
            }
        }
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