package com.therazzerapp.rulesmenu;

import net.canarymod.chat.MessageReceiver;

/**
 * Project: RulesMenu
 * User: Sonny
 * Date: 21/04/2015
 * Time: 10:44 PM
 * Package: com.therazzerapp.rulesmenu
 */
public interface RulesMenuCommand {
    void run(MessageReceiver caller, String[] args);
}
