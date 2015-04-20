package com.therazzerapp.rulesmenu.listener;


import com.therazzerapp.rulesmenu.Menu;
import com.therazzerapp.rulesmenu.RulesMenu;
import net.canarymod.api.GameMode;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.ConnectionHook;
import net.canarymod.plugin.PluginListener;


/**
 * Project: RulesMenu
 * User: Pual
 * Date: 18/04/2015
 * Time: 03:24 PM
 * Package: com.therazzerapp.rulesmenu.listener
 * E-Mail: rezzer101@googlemail.com
 */

public class ShowMenu implements PluginListener {

    @HookHandler
    public void onConnect(ConnectionHook hook){
        if(hook.getPlayer().hasPermission("rulesmenu.accepted")){
            return;
        }

        if(RulesMenu.settings.isMuted()){
            hook.getPlayer().setMuted(true);
        }

        if(RulesMenu.settings.isSpectator()){
            hook.getPlayer().setMode(GameMode.SPECTATOR);
        }

        if(RulesMenu.settings.isChatMuted()){
            ChatSilent.activate(hook.getPlayer());
        }

        hook.getPlayer().sendChatComponent(new Menu().getMenu(hook.getPlayer()));

    }
}
