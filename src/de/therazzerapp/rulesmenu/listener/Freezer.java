package de.therazzerapp.rulesmenu.listener;

import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.PlayerMoveHook;
import net.canarymod.hook.player.TeleportHook;
import net.canarymod.plugin.PluginListener;

/**
 * Project: RulesMenu
 * User: Pual
 * Date: 19/04/2015
 * Time: 02:19 PM
 * Package: com.therazzerapp.rulesmenu.listener
 * E-Mail: rezzer101@googlemail.com
 */

public class Freezer implements PluginListener{

    @HookHandler
    public void onMovement(PlayerMoveHook hook){
        if(!hook.getPlayer().hasPermission("rulesmenu.accepted")){
            hook.setCanceled();
        }
    }

    @HookHandler
    public void onTeleport(TeleportHook hook){
        if(!hook.getPlayer().hasPermission("rulesmenu.accepted")){
            hook.setCanceled();
        }
    }
}
