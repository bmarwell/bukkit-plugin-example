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

package de.bmarwell.bukkit.events;

import com.google.common.base.Optional;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 * A Teleport Cancelled Event.
 *
 * <p>
 * Probably not actually useful, but works as an example.
 * </p>
 */
public class PlayerTeleportCancelledEvent extends PlayerTeleportEvent {

  private Optional<String> reason = Optional.absent();

  public PlayerTeleportCancelledEvent(Player player, Location from, Location to, String reason,
      TeleportCause cause) {
    super(player, from, to, cause);
    this.reason = Optional.fromNullable(reason);
  }

  public Optional<String> getReason() {
    return this.reason;
  }

  @Override
  public String toString() {
    return "PlayerTeleportCancelledEvent [reason=" + reason.or("No reason defined")
        + ", getCause()=" + getCause().toString()
        + ", getPlayer()=" + getPlayer().getUniqueId() + "/" + getPlayer().getName() + "]";
  }

}
