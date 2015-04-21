package com.therazzerapp.rulesmenu.commands;

import com.therazzerapp.rulesmenu.RulesMenu;
import com.therazzerapp.rulesmenu.hook.RulesAcceptHook;
import com.therazzerapp.rulesmenu.listener.ChatSilent;
import net.canarymod.api.GameMode;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.MessageReceiver;

/**
 * Project: RulesMenu
 * User: Pual
 * Date: 18/04/2015
 * Time: 03:16 PM
 * Package: com.therazzerapp.rulesmenu.commands
 * E-Mail: rezzer101@googlemail.com
 */

public class Accept {
    public void run (MessageReceiver caller, String[] parameters){
        if (!(caller instanceof Player)){
            return;
        }

        Player player = caller.asPlayer();

        if (player.hasPermission("rulesmenu.accepted")){
            player.message(RulesMenu.getTranslator().localeTranslate("error_alreadyaccepted",player.getLocale()));
        } else {

            if(RulesMenu.settings.isMuted() && player.isMuted()){
                player.setMuted(false);
            }

            if(RulesMenu.settings.isSpectator() && player.getMode() == GameMode.SPECTATOR){
                player.setMode(player.getWorld().getGameMode());
            }

            if(RulesMenu.settings.isChatMuted() && ChatSilent.chatMap.containsKey(player)){
                ChatSilent.deactivate(player);
            }

            player.message(RulesMenu.getTranslator().localeTranslate("rules_accepted",player.getLocale()));
            player.getPermissionProvider().addPermission("rulesmenu.accepted", true);
            player.getPermissionProvider().reload();

            new RulesAcceptHook(player).call();
        }
    }
}
