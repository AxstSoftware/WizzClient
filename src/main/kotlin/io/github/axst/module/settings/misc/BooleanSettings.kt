package io.github.axst.module.settings.misc

import io.github.axst.module.settings.Settings

class BooleanSettings(name: String, description: String, enabled: Boolean) : Settings(name, description) {
    private var enabled: Boolean

    init {
        this.enabled = enabled
    }

    fun isEnabled(): Boolean {
        return enabled
    }
}