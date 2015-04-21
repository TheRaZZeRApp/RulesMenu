package com.therazzerapp.rulesmenu.listener;

import com.therazzerapp.rulesmenu.Menu;
import com.therazzerapp.rulesmenu.RulesMenu;
import net.canarymod.Canary;
import net.canarymod.api.GameMode;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.ConnectionHook;
import net.canarymod.plugin.PluginListener;
import net.canarymod.tasks.ServerTask;

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
    public void onConnect(final ConnectionHook hook){
        if(hook.getPlayer().hasPermission("rulesmenu.accepted")){
            return;
        }

        if(RulesMenu.settings.isMuted()){
            hook.getPlayer().setMuted(true);
        }

        if(RulesMenu.settings.isSpectator()){
            hook.getPlayer().setMode(GameMode.SPECTATOR);
            hook.getPlayer().teleportTo(hook.getPlayer().getSpawnPosition());
        }

        if(RulesMenu.settings.isChatMuted()){
            ChatSilent.activate(hook.getPlayer());
        }

        Canary.getServer().addSynchronousTask(new ServerTask(new RulesMenu(),20,false) {
            @Override
            public void run() {
                hook.getPlayer().sendChatComponent(new Menu().getMenu(hook.getPlayer()));
            }
        });
    }
}
