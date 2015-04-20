package com.therazzerapp.rulesmenu;

import com.therazzerapp.rulesmenu.commands.Accept;
import com.therazzerapp.rulesmenu.commands.Decline;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.Command;
import net.canarymod.commandsys.CommandListener;

/**
 * Project: RulesMenu
 * User: Pual
 * Date: 18/04/2015
 * Time: 03:12 PM
 * Package: com.therazzerapp.rulesmenu
 * E-Mail: rezzer101@googlemail.com
 */

public class CommandList implements CommandListener{

    @Command(aliases = {"rulesmenu"},
            description = "Accept the rules.",
            permissions = {""},
            toolTip = "/rulesmenu",
            min = 1
    )
    public void commandRulesMenu(MessageReceiver caller, String[] args){

    }
    @Command(aliases = {"accept"},
            parent = "rulesmenu",
            description = "Accept the rules.",
            permissions = {""},
            toolTip = "/rulesmenu accept",
            min = 1
    )
    public void commandAcceptRules(MessageReceiver caller, String[] args){
        new Accept().run(caller,args);
    }
    @Command(aliases = {"decline"},
            parent = "rulesmenu",
            description = "Decline the rules.",
            permissions = {""},
            toolTip = "/rulesmenu decline",
            min = 1
    )
    public void commandDeclineRules(MessageReceiver caller, String[] args){
        new Decline().run(caller,args);
    }

}
