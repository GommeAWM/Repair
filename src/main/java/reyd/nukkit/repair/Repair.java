package reyd.nukkit.repair;

import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.PluginBase;
import reyd.nukkit.repair.command.RepairCommand;
import reyd.nukkit.repair.utils.RepairConfig;

public class Repair extends PluginBase{

    public static Repair repair;
    public static RepairConfig repairConfig;

    public Repair(){
    }

    public void onEnable(){
        repair = this;
        this.getLogger().info("§fREPAIR: §aON");
        repairConfig = new RepairConfig(this);
        repairConfig.createDefaultConfig();
        registerListener();
    }

    public void onDisable(){
        this.getLogger().info("§fREPAIR: §cOFF");
    }

    private void registerListener(){
        SimpleCommandMap simpleCommandMap = getServer().getCommandMap();
        simpleCommandMap.register("help", new RepairCommand("repair", getRepair().getConfig().getString("command.description"), getRepair().getConfig().getString("command.usageMessage")));
    }

    public static RepairConfig getRepairConfig(){
        return repairConfig;
    }

    public static Repair getRepair(){
        return repair;
    }

}
