package io.github.axst.mixins.ui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public class GuiMainMenuMixins {
    @Inject(method = "initGui", at = @At("HEAD"))
    public void initGui(CallbackInfo callbackInfo) {
      //  Minecraft.getMinecraft().displayGuiScreen(new io.github.axst.ui.minecraft.GuiMainMenu());
    }
}
