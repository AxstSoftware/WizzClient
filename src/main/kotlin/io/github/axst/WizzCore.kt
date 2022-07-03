package io.github.axst

import io.github.axst.module.ModuleManager
import io.github.axst.utils.DiscordWebhook
import io.github.axst.utils.Keybinding

class WizzCore {

    companion object {
        @JvmStatic
        val instance: WizzCore = WizzCore()
    }

    lateinit var moduleManager: ModuleManager

    fun initializeClient() {
        moduleManager = ModuleManager()
        Keybinding()
        DiscordWebhook.sendMessage("HELLO")
    }
}