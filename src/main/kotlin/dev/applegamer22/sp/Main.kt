package dev.applegamer22.sp

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {
	override fun onEnable() {
		server.pluginManager.registerEvents(EventListener(), this)
	}

	override fun onCommand(sender: CommandSender, command: Command, label: String, arguments: Array<out String>): Boolean {
		if (sender is Player && arguments.size == 1) {
			val name = sender.name
			val password = arguments[0]
			if (command.name == "sp" && password == System.getenv("PASSWORD")) {
				Bukkit.getPlayer(name)?.sendMessage("Welcome, $name!")
				sender.player?.isWhitelisted = true
			} else {
				Bukkit.getPlayer(name)?.sendMessage("$name your password is incorrect")
			}
		}
		return true
	}
}
