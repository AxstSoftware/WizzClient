package io.github.axst.utils

import net.minecraft.client.Minecraft

interface IHelper {
    val minecraft: Minecraft
        get() = Minecraft.getMinecraft()
}