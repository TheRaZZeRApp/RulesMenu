package de.therazzerapp.rulesmenu.commands;

import de.therazzerapp.rulesmenu.RulesMenuCommand;
import net.canarymod.Canary;
import net.canarymod.chat.MessageReceiver;

/**
 * Project: RulesMenu
 * User: Sonny
 * Date: 21/04/2015
 * Time: 10:48 PM
 * Package: com.therazzerapp.rulesmenu.commands
 */
public class RulesMenu implements RulesMenuCommand{
    @Override
    public void run(MessageReceiver caller, String[] args) {
        caller.message("[RulesMenu] Version: " + Canary.pluginManager().getPlugin("RulesMenu").getVersion() + " loaded!" + "\n" +
        "[RulesMenu] Author: " + Canary.pluginManager().getPlugin("RulesMenu").getAuthor());
    }
}
