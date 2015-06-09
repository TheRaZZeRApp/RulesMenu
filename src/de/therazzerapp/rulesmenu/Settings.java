package de.therazzerapp.rulesmenu;

import com.google.gson.JsonObject;

/**
 * Project: RulesMenu
 * User: Pual
 * Date: 18/04/2015
 * Time: 10:25 PM
 * Package: com.therazzerapp.rulesmenu
 * E-Mail: rezzer101@googlemail.com
 */

public class Settings {
    private final int maxRules;
    private final boolean cantBuild;
    private final boolean isFreezed;
    private final boolean chatMuted;
    private final boolean isMuted;
    private final boolean kickOnDecline;
    private final boolean banOnDecline;
    private final boolean isSpectator;
    private final boolean teleportToSpawn;

    public Settings(JsonObject root) {
        this.maxRules = root.getAsJsonPrimitive("maxRules").getAsInt();
        this.cantBuild = root.getAsJsonPrimitive("cantBuild").getAsBoolean();
        this.isFreezed = root.getAsJsonPrimitive("isFreezed").getAsBoolean();
        this.chatMuted = root.getAsJsonPrimitive("chatSilent").getAsBoolean();
        this.isMuted = root.getAsJsonPrimitive("isMuted").getAsBoolean();
        this.kickOnDecline = root.getAsJsonPrimitive("kickOnDecline").getAsBoolean();
        this.banOnDecline = root.getAsJsonPrimitive("banOnDecline").getAsBoolean();
        this.isSpectator = root.getAsJsonPrimitive("isSpectator").getAsBoolean();
        this.teleportToSpawn = root.getAsJsonPrimitive("teleportToSpawnOnAccept").getAsBoolean();
    }

    public int getMaxRules() {
        return maxRules;
    }

    public boolean isCantBuild() {
        return cantBuild;
    }

    public boolean isFreezed() {
        return isFreezed;
    }

    public boolean isChatMuted() {
        return chatMuted;
    }

    public boolean isMuted() {
        return isMuted;
    }

    public boolean isKickOnDecline() {
        return kickOnDecline;
    }

    public boolean isBanOnDecline() {
        return banOnDecline;
    }

    public boolean isSpectator() {
        return isSpectator;
    }

    public boolean isTeleportToSpawn() {
        return teleportToSpawn;
    }
}
