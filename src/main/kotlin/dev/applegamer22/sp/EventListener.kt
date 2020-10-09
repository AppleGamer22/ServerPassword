package dev.applegamer22.sp

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
//import org.bukkit.event.player.PlayerStatisticIncrementEvent
//import org.bukkit.event.player.PlayerTeleportEvent

class EventListener: Listener {
	private fun sendMessage(player: Player) {
		val message = "${player.name}, in order to interact with the server, you need to provide its password by /password [password]"
		Bukkit.getPlayer(player.name)?.sendMessage(message)
	}

	@EventHandler fun onPlayerJoin(event: PlayerJoinEvent) {
		event.player.isWhitelisted = false
		this.sendMessage(event.player)
	}

	@EventHandler fun onPlayerQuit(event: PlayerQuitEvent) {
		event.player.isWhitelisted = false
	}

	@EventHandler fun onPlayerMove(event: PlayerMoveEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
//			this.sendMessage(event.player)
		}
	}

	@EventHandler fun onPlayerInteract(event: PlayerInteractEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
//			this.sendMessage(event.player)
		}
	}

	@EventHandler fun onPlayerChat(event: AsyncPlayerChatEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
//			this.sendMessage(event.player)
		}
	}
//	@EventHandler fun onPlayerStatisticIncrement(event: PlayerStatisticIncrementEvent) {
//		if (!event.player.isWhitelisted) {
//			event.isCancelled = true
////			this.sendMessage(event.player)
//		}
//	}
//
//	@EventHandler fun onPlayerTeleport(event: PlayerTeleportEvent) {
//		if (!event.player.isWhitelisted) {
//			event.isCancelled = true
////			this.sendMessage(event.player)
//		}
//	}
}
