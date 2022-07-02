package io.github.axst

import io.github.axst.module.ModuleManager
import io.github.axst.utils.DiscordWebhook

class WizzCore {

    companion object {
        @JvmStatic
        val instance: WizzCore = WizzCore()
    }

    var moduleManager: ModuleManager = ModuleManager()

    fun initializeClient() {
        moduleManager
        println("My First Injection!")
        DiscordWebhook.sendMessage("HELLO")
    }
}