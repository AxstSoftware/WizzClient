package io.github.axst

import lombok.Getter

class ClientCore {

    companion object Instances {
        @JvmStatic
        @Getter
        val instance: ClientCore = ClientCore()
    }

    fun initializeClient() {
        println("My First Injection!")
    }
}