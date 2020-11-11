package dev.applegamer22.sp

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.entity.Player
import org.bukkit.entity.Monster
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerSwapHandItemsEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerPortalEvent
import org.bukkit.event.player.PlayerAttemptPickupItemEvent
import org.bukkit.event.player.PlayerDropItemEvent
//import org.bukkit.event.player.PlayerBucketEvent
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerEditBookEvent
import org.bukkit.event.player.PlayerFishEvent
import org.bukkit.event.player.PlayerToggleFlightEvent
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.event.player.PlayerToggleSprintEvent
import org.bukkit.event.player.PlayerArmorStandManipulateEvent
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.EntityTargetEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class EventListener: Listener {
	private fun sendMessage(player: Player) {
		val message = "${player.name}, in order to interact with the server, you need to provide its password by /password [password]"
		Bukkit.getPlayer(player.name)?.sendMessage(message)
	}

	@EventHandler fun onPlayerJoin(event: PlayerJoinEvent) {
		event.player.isWhitelisted = false
		this.sendMessage(event.player)
		event.player.addPotionEffect(PotionEffect(PotionEffectType.BLINDNESS, Int.MAX_VALUE, 1))
	}

	@EventHandler fun onPlayerQuit(event: PlayerQuitEvent) {
		event.player.isWhitelisted = false
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

	@EventHandler fun onPlayerChat(event: AsyncPlayerChatEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerInteractEntity(event: PlayerInteractEntityEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerInteractAtEntity(event: PlayerInteractAtEntityEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerPortal(event: PlayerPortalEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerAttemptPickupItem(event: PlayerAttemptPickupItemEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerDropItem(event: PlayerDropItemEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerSwapHandItems(event: PlayerSwapHandItemsEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

//	@EventHandler fun onPlayerPlayerBucket(event: PlayerBucketEvent) {
//		if (!event.player.isWhitelisted) {
//			event.isCancelled = true
//		}
//	}

	@EventHandler fun onPlayerBedEnter(event: PlayerBedEnterEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerArmorStandManipulate(event: PlayerArmorStandManipulateEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerEditBook(event: PlayerEditBookEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerFish(event: PlayerFishEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerToggleFlight(event: PlayerToggleFlightEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerToggleSneak(event: PlayerToggleSneakEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onPlayerToggleSprint(event: PlayerToggleSprintEvent) {
		if (!event.player.isWhitelisted) {
			event.isCancelled = true
		}
	}

	@EventHandler fun onEntityDamageByEntity(event: EntityDamageByEntityEvent) {
		if (event.entity is Player) {
			val player = event.entity as Player
			if (!player.isWhitelisted) {
				event.isCancelled = true
			}
		}
	}

	@EventHandler fun onEntityDamage(event: EntityDamageEvent) {
		if (event.entity is Player) {
			val player = event.entity as Player
			if (!player.isWhitelisted) {
				event.isCancelled = true
			}
		}
	}

	@EventHandler fun onEntityDeath(event: EntityDeathEvent) {
		if (event.entity is Player) {
			val player = event.entity as Player
			if (!player.isWhitelisted) {
				event.isCancelled = true
			}
		}
	}

	@EventHandler fun onEntityTarget(event: EntityTargetEvent) {
		if (event.target is Player) {
			val player = event.target as Player
			if (!player.isWhitelisted) {
				event.isCancelled = true
			}
		}
	}
}
