package io.github.axst

import io.github.axst.module.ModuleManager
import io.github.axst.ui.module.FrameGui
import io.github.axst.utils.DiscordWebhook
import io.github.axst.utils.Keybinding
import io.github.axst.utils.logger.AlertType
import io.github.axst.utils.logger.Logger

class WizzCore {

    companion object {
        @JvmStatic
        val instance: WizzCore = WizzCore()
    }

    lateinit var moduleManager: ModuleManager
    lateinit var frameGui: FrameGui

    var log: Logger = Logger()

    fun initializeClient() {
        log.register("WizzClient")
        moduleManager = ModuleManager()
        frameGui = FrameGui()
        log.alert("Module Manager Loaded", AlertType.INFO)
        Keybinding()
        log.alert("Keybindings Loaded", AlertType.INFO)
        DiscordWebhook.sendMessage("HELLO")
    }
}