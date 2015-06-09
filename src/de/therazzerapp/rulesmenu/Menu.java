package de.therazzerapp.rulesmenu;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;

/**
 * Project: RulesMenu
 * User: Pual
 * Date: 18/04/2015
 * Time: 10:02 PM
 * Package: com.therazzerapp.rulesmenu
 * E-Mail: rezzer101@googlemail.com
 */

public class Menu {
    public ChatComponent getMenu(Player player){

        ChatComponentFactory f = Canary.factory().getChatComponentFactory();

        ChatComponent cCHeadline = f.newChatComponent("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + RulesMenu.getTranslator().localeTranslate("headline", player.getLocale()) + "\n" + "============================" + "\n");

        ChatComponent cCRules = f.newChatComponent("");

        int counter = 0;
        boolean foundEnd = false;

        do{
            String ruleName = "rule_" + counter;

            if(!RulesMenu.getTranslator().localeTranslate(ruleName,player.getLocale()).equals("") && !RulesMenu.getTranslator().localeTranslate(ruleName,player.getLocale()).equals(ruleName)){
                ChatComponent rule = f.newChatComponent(RulesMenu.getTranslator().localeTranslate(ruleName,player.getLocale()) + "\n");

                String ruleToolTip = RulesMenu.getTranslator().localeTranslate(ruleName + "_tooltip", player.getLocale());
                if(!ruleToolTip.equals("") && !ruleToolTip.equals(ruleName + "_tooltip")){
                    rule.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(ruleToolTip)));
                }

                cCRules.appendSibling(rule);
            }

            counter++;

            if (counter == RulesMenu.settings.getMaxRules()){
                foundEnd = true;
            }
        }while (!foundEnd);

        ChatComponent cCAccept = f.newChatComponent(RulesMenu.getTranslator().localeTranslate("accept",player.getLocale()));
        cCAccept.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(),"/rulesmenu accept"));

        String acceptToolTip = RulesMenu.getTranslator().localeTranslate("accept_tooltip", player.getLocale());

        if(!acceptToolTip.equals("")){
            cCAccept.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(acceptToolTip)));
        }

        ChatComponent cCDecline = f.newChatComponent(RulesMenu.getTranslator().localeTranslate("decline",player.getLocale()));
        cCDecline.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(),"/rulesmenu decline"));

        String declineToolTip = RulesMenu.getTranslator().localeTranslate("decline_tooltip", player.getLocale());

        if(!declineToolTip.equals("")){
            cCDecline.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(declineToolTip)));
        }

        ChatComponent cCButtons = f.newChatComponent("============================\n");
        cCButtons.appendSibling(cCAccept);
        cCButtons.appendText("\n");
        cCButtons.appendSibling(cCDecline);

        return cCHeadline.appendSibling(cCRules).appendSibling(cCButtons);
    }
}
