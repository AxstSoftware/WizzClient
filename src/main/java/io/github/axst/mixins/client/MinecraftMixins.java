package io.github.axst.mixins.client;

import io.github.axst.WizzCore;
import io.github.axst.ui.module.FrameGui;
import io.github.axst.ui.module.HudScreen;
import io.github.axst.utils.IWizz;
import io.github.axst.utils.Keybinding;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixins {

    @Inject(method = "startGame", at = @At(value = "RETURN"))
    public void injectStartGame(CallbackInfo ci) {
        WizzCore.getInstance().initializeClient();
    }

    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Keyboard;next()Z"))
    public void injectRuntTuck2(final CallbackInfo ci) {
        if(Keybinding.Companion.getOPEN_HUD().isPressed()) IWizz.Companion.getMinecraft().displayGuiScreen(new HudScreen());
        if(Keybinding.Companion.getOPEN_MANAGER().isPressed()) IWizz.Companion.getMinecraft().displayGuiScreen(new FrameGui());
    }
}
