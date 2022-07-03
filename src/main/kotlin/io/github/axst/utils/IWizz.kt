package io.github.axst.utils

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.FontRenderer
import net.minecraft.client.settings.GameSettings

interface IWizz {
    companion object {
        val minecraft: Minecraft = Minecraft.getMinecraft()
        val gameSettings: GameSettings = minecraft.gameSettings
        val font: FontRenderer = minecraft.fontRendererObj
    }
}