package de.therazzerapp.rulesmenu.listener;

import de.therazzerapp.rulesmenu.RulesMenu;
import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.ChatHook;
import net.canarymod.hook.player.DisconnectionHook;
import net.canarymod.hook.player.KickHook;
import net.canarymod.plugin.PluginListener;
import net.canarymod.plugin.Priority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: RulesMenu
 * User: Pual
 * Date: 19/04/2015
 * Time: 11:58 PM
 * Package: com.therazzerapp.rulesmenu.listener
 * E-Mail: rezzer101@googlemail.com
 */

public class ChatSilent implements PluginListener{


    public static final Map<Player, List<String>> chatMap = new HashMap<>();

    @HookHandler
    public void onDisconect(DisconnectionHook hook){
        chatMap.remove(hook.getPlayer());
    }

    @HookHandler
    public void onKick(KickHook hook){
        chatMap.remove(hook.getKickedPlayer());
    }

    public static void activate(Player player) {
        if (!chatMap.containsKey(player)) {
            ChatComponentFactory f = Canary.factory().getChatComponentFactory();
            player.showTitle(f.newChatComponent(RulesMenu.getTranslator().localeTranslate("chatsilent_off", player.getLocale())));
            chatMap.put(player, new ArrayList<String>());
        }
    }

    public static void deactivate(Player player) {
        List<String> msgs = chatMap.remove(player);
        if (msgs != null) {
            ChatComponentFactory f = Canary.factory().getChatComponentFactory();
            player.showTitle(f.newChatComponent(RulesMenu.getTranslator().localeTranslate("chatsilent_on", player.getLocale())));
            for (String msg : msgs) {
                player.message(msg);
            }
        }

    }

    @HookHandler(priority = Priority.LOW, ignoreCanceled = true)
    public void onChat(ChatHook hook) {
        String format = hook.getFormat();

        for (Map.Entry<String, String> entry : hook.getPlaceholderMapping().entrySet()) {
            format = format.replace(entry.getKey(), entry.getValue());
        }

        ArrayList<Player> getter = new ArrayList<>();

        for (Player player : hook.getReceiverList()) {
            List<String> chat = chatMap.get(player);
            if (chat == null) {
                getter.add(player);
            } else {
                chat.add(format);
            }
        }

        hook.setReceiverList(getter);
    }
}
