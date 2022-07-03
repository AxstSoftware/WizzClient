package io.github.axst.module

import io.github.axst.module.settings.Settings
import java.util.*

open class Module(name: String, description: String) {

    var name: String

    private var description: String

    private var enabled: Boolean

    private val settings: ArrayList<Settings>

    init {
        this.name = name
        this.description = description
        this.enabled = true
        settings = ArrayList()
    }

    fun addSettings(vararg toAdd: Settings) {
        settings.addAll(listOf(*toAdd))
    }

    fun toggleModule() {
        setEnabled(!isEnabled())
    }

    fun isEnabled(): Boolean {
        return enabled
    }

    private fun setEnabled(enabled: Boolean) {
        this.enabled = enabled
    }
}