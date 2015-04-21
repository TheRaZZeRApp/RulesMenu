package com.therazzerapp.rulesmenu.commands;

import com.therazzerapp.rulesmenu.RulesMenu;
import com.therazzerapp.rulesmenu.hook.RulesAcceptHook;
import com.therazzerapp.rulesmenu.hook.RulesDeclineHook;
import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.MessageReceiver;

/**
 * Project: RulesMenu
 * User: Pual
 * Date: 18/04/2015
 * Time: 03:17 PM
 * Package: com.therazzerapp.rulesmenu.commands
 * E-Mail: rezzer101@googlemail.com
 */

public class Decline {
    public void run (MessageReceiver caller, String[] parameters){
        if (!(caller instanceof Player)){
            return;
        }

        Player player = caller.asPlayer();

        if (player.hasPermission("rulesmenu.accepted")){
            player.message(RulesMenu.getTranslator().localeTranslate("error_alreadyaccepted",player.getLocale()));
            return;
        }

        if(RulesMenu.settings.isKickOnDecline()){
            player.kick(RulesMenu.getTranslator().localeTranslate("kickmessage",player.getLocale()));
            new RulesDeclineHook(player,true).call();
            return;
        } else if (RulesMenu.settings.isBanOnDecline()){
            String reson = RulesMenu.getTranslator().localeTranslate("banmessage", player.getLocale());
            Canary.bans().issueBan(player, reson);
            player.kick(RulesMenu.getTranslator().localeTranslate("kickmessage", player.getLocale()));
            new RulesDeclineHook(player,true,reson).call();
            return;
        }

        new RulesDeclineHook(player).call();

    }
}
