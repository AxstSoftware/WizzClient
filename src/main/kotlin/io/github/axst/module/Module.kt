package io.github.axst.module

import io.github.axst.utils.IHelper

open class Module(name: String, description: String) : IHelper{

    var name: String?

    private var description: String?

    var enabled: Boolean?

    init {
        this.name = name
        this.description = description
        this.enabled = true
    }

    open fun toggleModule() {
        setEnabled(!isEnabled())
    }

    open fun isEnabled(): Boolean {
        return enabled!!
    }

    open fun setEnabled(enabled: Boolean) {
        this.enabled = enabled
    }
}