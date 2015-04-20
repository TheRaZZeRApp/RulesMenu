package com.therazzerapp.rulesmenu.listener;

import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.BlockPlaceHook;
import net.canarymod.plugin.PluginListener;

/**
 * Project: RulesMenu
 * User: Pual
 * Date: 19/04/2015
 * Time: 02:41 PM
 * Package: com.therazzerapp.rulesmenu.listener
 * E-Mail: rezzer101@googlemail.com
 */

public class Builder implements PluginListener {

    @HookHandler
    public void onBlockPlacement(BlockPlaceHook hook){
        if(!hook.getPlayer().hasPermission("rulesmenu.accepted")){
            hook.setCanceled();
        }
    }
}
