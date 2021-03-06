package com.jpmac26.olddays;

import com.jpmac26.olddays.settings.*;
import com.jpmac26.olddays.settings.mob.EndermanSettings;
import com.jpmac26.olddays.settings.mob.SheepSettings;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    public static ActionSettings action;
    public static CraftingSettings crafting;
    public static EyecandySettings eyecandy;
    public static GameplaySettings gameplay;
    public static MobSettings mob;
    public static SoundSettings sound;
    public static TextureSettings texture;
    public static WorldSettings world;


    public static void init(File file) {
        config = new Configuration(file);
        load();
        save();
    }

    public static void load() {
        String category;

        category = "mobs";
        config.addCustomCategoryComment(category, "Mob-specific settings");
        EndermanSettings.load();
        SheepSettings.load();
    }

    public static void save() {
        String category;

        category = "mobs";
        config.addCustomCategoryComment(category, "Mob-specific settings");
        EndermanSettings.save();
        SheepSettings.save();

        if (config.hasChanged())
            config.save();
    }
}
