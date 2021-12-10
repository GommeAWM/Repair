package reyd.nukkit.repair.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import reyd.nukkit.repair.Repair;

public class RepairCommand extends Command {

    public RepairCommand(String name, String description, String UsageMessage){
        super(name, description, UsageMessage);
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] args) {

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(!player.hasPermission("reyd.repair") && !player.isOp()){
                player.sendMessage(Repair.getRepairConfig().permission());
            } else {
                Item hand = player.getInventory().getItemInHand();
                if(!hand.isTool() && !hand.isArmor()){
                    player.sendMessage(Repair.getRepairConfig().notToolorArmor());
                } else {
                    int expLevel = player.getExperienceLevel();
                    int exp = player.getExperience();
                    int expForRepair = Repair.getRepairConfig().experienceForRepair();
                    if(expLevel >= expForRepair){ // If player have ExperienceLevel
                        int getExp = expLevel - expForRepair; // take ExperienceLevel for repair
                        player.setExperience(exp, getExp);
                        hand.setDamage(0);
                        player.getInventory().setItemInHand(hand);
                        player.sendMessage(Repair.getRepairConfig().repair());
                    } else {
                        player.sendMessage(Repair.getRepairConfig().experience());
                    }
                }
            }
        } else {
            commandSender.sendMessage(Repair.getRepairConfig().isNotAPlayer());
        }

        return true;
    }
}
