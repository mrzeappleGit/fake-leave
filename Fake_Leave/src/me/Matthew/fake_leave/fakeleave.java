package me.Matthew.fake_leave;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class fakeleave extends JavaPlugin
{
	  public final Logger logger = Logger.getLogger("Leaving");
	  public static fakeleave plugin;
	  
	  public void onDisable()
	  {
	    PluginDescriptionFile pdfFile = getDescription();
	    this.logger.info(pdfFile.getName() + "on nos it broke");
	    getServer().getPluginManager().removePermission(new Permissions().canPrefromCommand);
	  }
	  
	  public void onEnable()
	  {
	    PluginDescriptionFile pdfFile = getDescription();
	    this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Me am better");
	    getConfig().options().copyDefaults(true);
	    saveConfig();
	    PluginManager pm = getServer().getPluginManager();
	    pm.addPermission(new Permissions().canPrefromCommand);
	  }
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args)
	  {
	    Player player = (Player)sender;
	    //Player[] arrayOfPlayer;
	    //int j;
	    //int i;
	    if (commandLable.equalsIgnoreCase("faleave"))
	    {
	      if (sender.hasPermission(new Permissions().canPrefromCommand))
	      {
	        String color = getConfig().getString("color");
	        String color1 = color.toUpperCase();
	        getServer().broadcastMessage(ChatColor.valueOf(color1) + player.getName() + " " + getConfig().getString("leave_message"));
	        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000000, 1));
	        if (getConfig().getString("gamemode") == "true")
	        {
	          player.setGameMode(GameMode.CREATIVE);
	        }
	        else
	        {
	          PluginDescriptionFile pdfFile = getDescription();
	          this.logger.severe(pdfFile.getName() + ": Auto Gamemode is set to False not true");
	        }
	        //j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
	        //for (i = 0; i < j; i++)
	        //{
	         // Player online = arrayOfPlayer[i];
	         // online.hidePlayer(player);
	        }
	      //}
	      else
	      {
	        sender.sendMessage("I Can't let you do that " + player.getName());
	      }
	    }
	    else if (commandLable.equalsIgnoreCase("fajoin"))
	    {
	      if (sender.hasPermission(new Permissions().canPrefromCommand))
	      {
	        String color = getConfig().getString("join_color");
	        String color1 = color.toUpperCase();
	        getServer().broadcastMessage(ChatColor.valueOf(color1) + player.getName() + " " + getConfig().getString("join_message"));
	        player.removePotionEffect(PotionEffectType.INVISIBILITY);
	        if (getConfig().getString("gamemode_join") == "true")
	        {
	          player.setGameMode(GameMode.SURVIVAL);
	        }
	        else
	        {
	          PluginDescriptionFile pdfFile = getDescription();
	          this.logger.severe(pdfFile.getName() + ": Auto Gamemode is set to False not true");
	        }
	        //j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
	       // for (i = 0; i < j; i++)
	        //{
	          //Player online = arrayOfPlayer[i];
	          //online.showPlayer(player);
	       // }
	      }
	      else
	      {
	        sender.sendMessage("I Can't let you do that " + player.getName());
	      }
	    }
	    else if ((commandLable.equalsIgnoreCase("faload")) && 
	      (sender.hasPermission(new Permissions().canPrefromCommand)))
	    {
	      reloadConfig();
	      player.sendMessage("Reload Complete!");
	    }
	    return false;
	  }
	}
