package com.jpmac26.olddays;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

/**
 * Created by James Pelster on 7/14/2016.
 */
@SideOnly(Side.CLIENT)
public class KeyHandler {

    public static final int CUSTOM_INV = 0;

    private static final String[] desc = {"key.olddays_menu.desc"};

    private static final int[] keyValues = {Keyboard.KEY_H};

    private final KeyBinding[] keys;

    public KeyHandler() {
        keys = new KeyBinding[desc.length];

        for(int i = 0; i < desc.length; i++) {
            keys[i] = new KeyBinding(desc[i], keyValues[i], "key.olddays.category");

            ClientRegistry.registerKeyBinding(keys[i]);
        }
    }

    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event) {
        //OldDaysRevisited.LOGGER.debug("Key Down");

        EntityPlayer player = FMLClientHandler.instance().getClient().player;

        if(FMLClientHandler.instance().getClient().inGameHasFocus) {
            //OldDaysRevisited.LOGGER.debug("Game does have focus");

            int kb = Keyboard.getEventKey();
            boolean isDown = Keyboard.getEventKeyState();

            if(kb == keys[0].getKeyCode() && isDown) {
                OldDaysRevisited.LOGGER.debug("Opening OldDays Config Menu");
                player.openGui(OldDaysRevisited.instance, 0, player.world, (int) player.posX, (int) player.posY, (int) player.posZ);
                //if you're not sure, use player.openGui(MAINMODCLASS.instance, YOURGUIID, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);

            }
        }
    }
}
