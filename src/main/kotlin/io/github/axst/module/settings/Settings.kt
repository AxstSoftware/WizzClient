package io.github.axst.module.settings

open class Settings(name: String, description: String) {
    private val names: String
    private val descriptions: String

    init {
        this.names = name
        this.descriptions = description
    }
}