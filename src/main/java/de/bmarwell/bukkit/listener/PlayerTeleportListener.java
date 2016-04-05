/**
 * Bukkit-Plugin-Example by Benjamin Marwell.
 *
 * To the extent possible under law, the person who associated CC0 with
 * Bukkit-Plugin-Example has waived all copyright and related or neighboring rights
 * to Bukkit-Plugin-Example.
 *
 * You should have received a copy of the CC0 legalcode along with this
 * work.  If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */

package de.bmarwell.bukkit.listener;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

/**
 * React on player teleport events.
 *
 * @since 0.0.1.
 */
public class PlayerTeleportListener implements Listener {

  @EventHandler
  public void onPlayerTeleport(PlayerTeleportEvent event) {
    // if this event was cancelled, why bother?
    if (event.isCancelled()) {
      return;
    }

    // If this is not an ender teleport, don't bother.
    if (!TeleportCause.ENDER_PEARL.equals(event.getCause())) {
      return;
    }

    Player teleportedPlayer = event.getPlayer();
    Location origin = event.getFrom();

    boolean teleportSuccess = teleportedPlayer.teleport(origin, TeleportCause.PLUGIN);
    // TODO: log teleportSuccess;
  }

}
