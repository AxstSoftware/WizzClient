package io.github.axst

import io.github.axst.module.ModuleManager
import io.github.axst.utils.DiscordWebhook

class WizzCore {

    companion object {
        @JvmStatic
        val instance: WizzCore = WizzCore()
    }

    var moduleManager: ModuleManager? = null

    fun initializeClient() {
        moduleManager = ModuleManager()
        println("My First Injection!")
        DiscordWebhook.sendMessage("HELLO")
    }
}