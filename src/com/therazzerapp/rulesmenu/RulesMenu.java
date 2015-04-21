package com.therazzerapp.rulesmenu;

import com.therazzerapp.rulesmenu.config.Config;
import com.therazzerapp.rulesmenu.listener.Builder;
import com.therazzerapp.rulesmenu.listener.ChatSilent;
import com.therazzerapp.rulesmenu.listener.Freezer;
import com.therazzerapp.rulesmenu.listener.ShowMenu;
import net.canarymod.Canary;
import net.canarymod.commandsys.CommandDependencyException;
import net.canarymod.exceptions.PluginLoadFailedException;
import net.canarymod.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 * Project: RulesMenu
 * User: Pual
 * Date: 18/04/2015
 * Time: 03:12 PM
 * Package: com.therazzerapp.rulesmenu
 * E-Mail: rezzer101@googlemail.com
 */

public class RulesMenu extends Plugin {

    private static Translator translator;
    public static Settings settings;

    @Override
    public boolean enable() {

        try{
            translator = new Translator();
            getLogman().info("Language files loaded!");
        } catch (NullPointerException ex){
            getLogman().error("No language files found, language is set to default (en_US)");
            translator = new Translator("en_US");
        }

        File configDir = new File("./config/RulesMenu/");
        if(!configDir.exists()){
            configDir.mkdir();
        }

        File configFile = new File("./config/RulesMenu/config.json");
        if(!configFile.exists()){
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getLogman().info("Config file created");
            Config.createConfig(configFile);
        }
        settings = new Settings(Config.readJsonFile(configFile));
        getLogman().info("Config loaded!");

        try {
            Canary.commands().registerCommands(new CommandList(),this,false);
        } catch (CommandDependencyException e) {
            e.printStackTrace();
        }

        if (settings.isFreezed()){
            registerListener(new Freezer());
        }
        if(settings.isCantBuild()){
            registerListener(new Builder());
        }
        if(settings.isChatMuted()){
            registerListener(new ChatSilent());
        }
        registerListener(new ShowMenu());
        return true;
    }

    @Override
    public void disable() {

    }

    public static Translator getTranslator() {
        return translator;
    }
}
