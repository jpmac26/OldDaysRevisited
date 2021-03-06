package com.jpmac26.olddays.client.gui;

import com.jpmac26.olddays.entity.EntityODEnderman;
import com.jpmac26.olddays.entity.EntityODSheep;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

import java.io.IOException;

/**
 * Created by James Pelster on 7/19/2016.
 */
public class GuiConfigMobs extends GuiScreen {

    private final GuiScreen parentGuiScreen;

    public GuiConfigMobs(GuiScreen parent) {
        this.parentGuiScreen = parent;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void initGui() {
        this.buttonList.clear();

        this.buttonList.add(new GuiButton(1, this.width / 2 - 155, this.height / 6 + 24 - 6, 150, 20, I18n.format("Old Block Stealing") + ": " + ( EntityODEnderman.oldBlockStealing ? "ON" : "OFF")));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 5, this.height / 6 + 24 - 6, 150, 20, I18n.format("Old Enderman Health") + ": " + ( EntityODEnderman.oldHealth ? "ON" : "OFF")));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 155, this.height / 6 + 48 - 6, 150, 20, I18n.format("Enderman Design") + ": " + ( EntityODEnderman.oldAppearance ? "Beta" : "Release")));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 5, this.height / 6 + 48 - 6, 150, 20, I18n.format("Old Enderman Sounds") + ": " + ( EntityODEnderman.oldSounds ? "ON" : "OFF")));
        this.buttonList.add(new GuiButton(5, this.width / 2 - 155, this.height / 6 + 72 - 6, 150, 20, I18n.format("Punch Sheep") + ": " + (EntityODSheep.punchToShear ? "ON" : "OFF")));
        this.buttonList.add(new GuiButton(6, this.width / 2 - 100, this.height / 6 + 180 - 6, I18n.format("Back to Menu")));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 1) {
            EntityODEnderman.oldBlockStealing = ! EntityODEnderman.oldBlockStealing;
            button.displayString = I18n.format("Old Block Stealing") + ": " + ( EntityODEnderman.oldBlockStealing ? "ON" : "OFF");
        }
        if (button.id == 2) {
             EntityODEnderman.oldHealth = ! EntityODEnderman.oldHealth;
            button.displayString = I18n.format("Old Enderman Health") + ": " + ( EntityODEnderman.oldHealth ? "ON" : "OFF");
        }
        if (button.id == 3) {
             EntityODEnderman.oldAppearance = ! EntityODEnderman.oldAppearance;
            button.displayString = I18n.format("Enderman Design") + ": " + ( EntityODEnderman.oldAppearance ? "Beta" : "Release");
        }
        if (button.id == 4) {
             EntityODEnderman.oldSounds = ! EntityODEnderman.oldSounds;
            button.displayString = I18n.format("Old Enderman Sounds") + ": " + ( EntityODEnderman.oldSounds ? "ON" : "OFF");
        }
        if (button.id == 5) {
            EntityODSheep.punchToShear = !EntityODSheep.punchToShear;
            button.displayString = I18n.format("Punch Sheep") + ": " + (EntityODSheep.punchToShear ? "ON" : "OFF");
        }
        if (button.id == 6) {
            this.mc.displayGuiScreen(parentGuiScreen);
        }
    }
}
