package io.github.axst.utils

import io.github.axst.utils.IWizz.Companion.gameSettings
import net.minecraft.client.settings.KeyBinding
import org.apache.commons.lang3.ArrayUtils
import org.lwjgl.input.Keyboard

class Keybinding {
    companion object : IWizz {
        val OPEN_HUD: KeyBinding = KeyBinding("Open Hud Menu", Keyboard.KEY_RSHIFT, "Wizz Client")
        val OPEN_MANAGER: KeyBinding = KeyBinding("Open Manager Menu", Keyboard.KEY_R, "Wizz Client")

        init {
            register(OPEN_HUD, OPEN_MANAGER)
        }
        private fun register(vararg key: KeyBinding) {
            gameSettings.keyBindings = ArrayUtils.addAll(gameSettings.keyBindings, *key)
        }
    }
}