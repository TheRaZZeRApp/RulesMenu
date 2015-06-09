package de.therazzerapp.rulesmenu.hook;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.Hook;

/**
 * Called when a player without the permission <i>"rulesmenu.accepted"</i><br>
 * uses the command <i>"/rulesmenu decline"</i>.
 */
public class RulesDeclineHook extends Hook {
    private final Player player;
    private boolean banned;
    private boolean kicked;
    private String reason;

    public RulesDeclineHook(Player player, boolean banned, String reason) {
        this.player = player;
        this.banned = banned;
        this.reason = !reason.equals("") ? reason : null;
    }

    public RulesDeclineHook(Player player, boolean kicked) {
        this.kicked = kicked;
        this.player = player;
    }

    public RulesDeclineHook(Player player) {
        this.player = player;
    }

    /**
     * Returns the {@link Player} who has <i>declined</i> the rules.
     * @return player
     *          The {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Is <i>true</i> when <i>"banOnDecline"</i> is set to true in the config file <br>
     * and the player gets banned.
     *
     * @return boolean
     */
    public boolean isBanned() {
        return banned;
    }

    /**
     * Is <i>true</i> when <i>"kickOnDecline"</i> is set to true in the config file <br>
     * and the {@link Player} gets kicked.
     *
     * @return boolean
     */
    public boolean isKicked() {
        return kicked;
    }

    /**
     * Returns the the <i>"banmessage"</i> which is set in the language file.<br>
     *
     * @return String<br>
     *     <i>null</i> when the player only gets kicked.<br>
     *     <i>null</i> when the <i>"banmessage"</i> is empty.
     */
    public String getBanReason() {
        return reason;
    }
}
