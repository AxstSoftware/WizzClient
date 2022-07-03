package io.github.axst.module

import io.github.axst.module.misc.RenderModule
import io.github.axst.module.misc.TestModule
import io.github.axst.module.render.ModuleRenderer

class ModuleManager {

    var module: ArrayList<Module> = ArrayList()

    init {
        module.add(TestModule())
        module.add(RenderModule())
    }

    fun renderHooks() {
        module.forEach { module: Module -> if (module.isEnabled() && module is ModuleRenderer) module.drawOverlayModule() }
    }
}