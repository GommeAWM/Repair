package reyd.nukkit.repair.utils;

import cn.nukkit.utils.Config;
import reyd.nukkit.repair.Repair;

import java.io.File;

public class RepairConfig {

    private Repair repair;
    private File file;
    private Config config;

    public RepairConfig(Repair repair){
        this.repair = repair;
        this.file = new File(repair.getDataFolder(), "config.yml");
        this.config = new Config(this.file, Config.YAML);
    }

    public void createDefaultConfig(){
        this.addDefault("options.messages.repair", "§3Youre item has been repaired!");
        this.addDefault("options.messages.isNotAPlayer", "§cYou are not a player!");
        this.addDefault("options.messages.notToolorArmor", "§cPlease use a Tool or a Armor to repair!");
        this.addDefault("options.messages.permission", "§cYou don't have Permission");
        this.addDefault("options.messages.experience", "$cYou need 2 ExperienceLevel for Repair Your Item");
        this.addDefault("command.description", "Repair your Items!");
        this.addDefault("command.usageMessage", "§cPlease use /repair");
        this.addDefault("command.experienceForRepair", 2);
    }

    public String repair() {
        return this.config.getString("options.messages.repair");
    }

    public String isNotAPlayer() {
        return this.config.getString("options.messages.isNotAPlayer");
    }

    public String notToolorArmor() {
        return this.config.getString("options.messages.notToolorArmor");
    }

    public String permission(){ return this.config.getString("options.messages.permission"); }

    public String experience(){ return this.config.getString("options.messages.experience"); }

    public String commandDescription() {
        return this.config.getString("command.description");
    }

    public String usageMessage() {
        return this.config.getString("command.usageMessage");
    }

    public int experienceForRepair() {
        return this.config.getInt("command.experienceForRepair");
    }

    public void addDefault(String path, Object object){
        if(!this.config.exists(path)){
            this.config.set(path, object);
            this.config.save(this.file);
        }
    }

}
