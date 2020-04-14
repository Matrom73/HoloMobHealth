package com.loohp.holomobhealth.Utils;

import java.text.DecimalFormat;

import org.bukkit.entity.LivingEntity;

import com.loohp.holomobhealth.HoloMobHealth;

import net.md_5.bungee.api.ChatColor;

public class ParsePlaceholders {
	
	@SuppressWarnings("deprecation")
	public static String parse(LivingEntity entity, String text) {
		DecimalFormat formatter = new DecimalFormat("#,###.00");	
		if (text.contains("{Health_Rounded_Commas}")) {
			long health = Math.round(entity.getHealth());	
			text = text.replace("{Health_Rounded_Commas}", String.valueOf(formatter.format(health)));
		}
		if (text.contains("{Max_Health_Rounded_Commas}")) {
			long health = Math.round(entity.getMaxHealth());
			text = text.replace("{Max_Health_Rounded_Commas}", String.valueOf(formatter.format(health)));
		}
		if (text.contains("{Health_1DB_Commas}")) {
			double health = (double) Math.round(entity.getHealth() * (double) 10) / (double) 10;
			text = text.replace("{Health_1DB_Commas}", String.valueOf(formatter.format(health)));
		}
		if (text.contains("{Max_Health_1DB_Commas}")) {
			double health = (double) Math.round(entity.getMaxHealth() * (double) 10) / (double) 10;
			text = text.replace("{Max_Health_1DB_Commas}", String.valueOf(formatter.format(health)));
		}
		if (text.contains("{Health_2DB_Commas}")) {
			double health = (double) Math.round(entity.getHealth() * (double) 10) / (double) 10;
			text = text.replace("{Health_2DB_Commas}", String.valueOf(formatter.format(health)));
		}
		if (text.contains("{Max_Health_2DB_Commas}")) {
			double health = (double) Math.round(entity.getMaxHealth() * (double) 10) / (double) 10;
			text = text.replace("{Max_Health_2DB_Commas}", String.valueOf(formatter.format(health)));
		}		
		if (text.contains("{Health_Rounded}")) {
			long health = Math.round(entity.getHealth());
			text = text.replace("{Health_Rounded}", String.valueOf(health));
		}
		if (text.contains("{Max_Health_Rounded}")) {
			long health = Math.round(entity.getMaxHealth());
			text = text.replace("{Max_Health_Rounded}", String.valueOf(health));
		}
		if (text.contains("{Health_1DB}")) {
			double health = (double) Math.round(entity.getHealth() * (double) 10) / (double) 10;
			text = text.replace("{Health_1DB}", String.valueOf(health));
		}
		if (text.contains("{Max_Health_1DB}")) {
			double health = (double) Math.round(entity.getMaxHealth() * (double) 10) / (double) 10;
			text = text.replace("{Max_Health_1DB}", String.valueOf(health));
		}
		if (text.contains("{Health_2DB}")) {
			double health = (double) Math.round(entity.getHealth() * (double) 10) / (double) 10;
			text = text.replace("{Health_2DB}", String.valueOf(health));
		}
		if (text.contains("{Max_Health_2DB}")) {
			double health = (double) Math.round(entity.getMaxHealth() * (double) 10) / (double) 10;
			text = text.replace("{Max_Health_2DB}", String.valueOf(health));
		}
		if (text.contains("{Health_Percentage}")) {
			long health = Math.round((entity.getHealth() / (double) entity.getMaxHealth()) * 100);
			text = text.replace("{Health_Percentage}", String.valueOf(health));
		}
		if (text.contains("{Health_Percentage_1DB}")) {
			double health = (double) Math.round((entity.getHealth() / (double) entity.getMaxHealth()) * 1000) / (double) 10;
			text = text.replace("{Health_Percentage_1DB}", String.valueOf(health));
		}
		if (text.contains("{Health_Percentage_2DB}")) {
			double health = (double) Math.round((entity.getHealth() / (double) entity.getMaxHealth()) * 10000) / (double) 10;
			text = text.replace("{Health_Percentage_2DB}", String.valueOf(health));
		}
		if (text.contains("{Mob_Type}")) {
			String type = EntityTypeUtils.getMinecraftName(entity);
			text = text.replace("{Mob_Type}", type);
		}
		if (text.contains("{DynamicColor}")) {
			double healthpercentage = (entity.getHealth() / entity.getMaxHealth());
			String symbol = "";
			if (healthpercentage < 0.33) {
				symbol = HoloMobHealth.LowColor;
			} else if (healthpercentage < 0.67) {
				symbol = HoloMobHealth.HalfColor;
			} else {
				symbol = HoloMobHealth.HealthyColor;
			}
			text = text.replace("{DynamicColor}", symbol);
		}
		if (text.contains("{ScaledSymbols}")) {
			String symbol = "";
			double healthpercentagescaled = (entity.getHealth() / entity.getMaxHealth()) * (double) HoloMobHealth.heartScale;
			double i = 1;
			for (i = 1; i < healthpercentagescaled; i = i + 1) {
				symbol = symbol + HoloMobHealth.HealthyChar;
			}
			i = i - 1;
			if ((healthpercentagescaled - i) > 0 && (healthpercentagescaled - i) < 0.33) {
				symbol = symbol + HoloMobHealth.EmptyChar;
			} else if ((healthpercentagescaled - i) > 0 && (healthpercentagescaled - i) < 0.67) {
				symbol = symbol + HoloMobHealth.HalfChar;
			} else if ((healthpercentagescaled - i) > 0) {
				symbol = symbol + HoloMobHealth.HealthyChar;
			}
			for (i = HoloMobHealth.heartScale - 1; i >= healthpercentagescaled; i = i - 1) {
				symbol = symbol + HoloMobHealth.EmptyChar;
			}
			text = text.replace("{ScaledSymbols}", symbol);
		}
		
		text = ChatColor.translateAlternateColorCodes('&', text);
		
		if (text.contains("{Mob_Type_Or_Name}")) {
			String name = "";
			if (entity.getCustomName() != null) {
				name = ChatColor.RESET + entity.getCustomName();
			}
			if (name.equals("")) {
				name = ChatColor.translateAlternateColorCodes('&', EntityTypeUtils.getMinecraftName(entity));
			}
			text = text.replace("{Mob_Type_Or_Name}", String.valueOf(name));
		}
		return text;
	}

}
