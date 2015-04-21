package com.therazzerapp.rulesmenu;

import com.therazzerapp.rulesmenu.commands.*;
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

    static final RulesMenuCommand[] cmds = new RulesMenuCommand[3];

    static {
        cmds[0] = new Accept();
        cmds[1] = new Decline();
        cmds[2] = new com.therazzerapp.rulesmenu.commands.RulesMenu();
    }

    @Command(aliases = {"rulesmenu"},
            description = "Accept the rules.",
            permissions = {""},
            toolTip = "/rulesmenu",
            min = 1
    )
    public void commandRulesMenu(MessageReceiver caller, String[] args){
        cmds[2].run(caller,args);
    }
    @Command(aliases = {"accept"},
            parent = "rulesmenu",
            description = "Accept the rules.",
            permissions = {""},
            toolTip = "/rulesmenu accept",
            min = 1
    )
    public void commandAcceptRules(MessageReceiver caller, String[] args){
        cmds[0].run(caller, args);
    }
    @Command(aliases = {"decline"},
            parent = "rulesmenu",
            description = "Decline the rules.",
            permissions = {""},
            toolTip = "/rulesmenu decline",
            min = 1
    )
    public void commandDeclineRules(MessageReceiver caller, String[] args){
        cmds[1].run(caller, args);
    }

}
