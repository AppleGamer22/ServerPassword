package dev.applegamer22.sp

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerQuitEvent

public class EventListener: Listener {
	@EventHandler fun onPlayerJoin(event: PlayerJoinEvent) {
		event.player.isWhitelisted = false
		val message = "${event.player.name}, in order to interact with the server, you need to provide its password by /password [password]"
		Bukkit.getPlayer(event.player.name)?.sendMessage(message)
	}

	@EventHandler fun onPlayerMove(event: PlayerMoveEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerInteract(event: PlayerInteractEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerQuit(event: PlayerQuitEvent) {
		event.player.isWhitelisted = false
	}
}
