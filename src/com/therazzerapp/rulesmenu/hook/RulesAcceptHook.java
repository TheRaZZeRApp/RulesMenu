package com.therazzerapp.rulesmenu.hook;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.Hook;

/**
 * Called when a player without the permission <i>"rulesmenu.accepted"</i><br>
 * uses the command <i>"/rulesmenu accept"</i>.
 */
public class RulesAcceptHook extends Hook {
    private final Player player;


    public RulesAcceptHook(Player player) {
        this.player = player;
    }

    /**
     * Returns the player who has <i>accepted</i> the rules.
     * @return player
     */
    public Player getPlayer() {
        return player;
    }
}
