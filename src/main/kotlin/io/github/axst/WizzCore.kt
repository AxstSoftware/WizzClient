package io.github.axst

import io.github.axst.utils.DiscordWebhook

class WizzCore {

    companion object {
        @JvmStatic
        val instance: WizzCore = WizzCore()
    }

    fun initializeClient() {
        println("My First Injection!")
        DiscordWebhook.sendMessage("HELLO")
    }
}