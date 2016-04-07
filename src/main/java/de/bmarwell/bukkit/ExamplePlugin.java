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

package de.bmarwell.bukkit;

import de.bmarwell.bukkit.listener.PlayerTeleportListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The example plugin main class.
 *
 * @since 0.0.1-SNAPSHOT.
 */
public class ExamplePlugin extends JavaPlugin {

  private ExamplePluginConfig config = null;

  @Override
  public void onDisable() {
  }

  @Override
  public void onEnable() {
    // 1.) init your config.
    this.config = new ExamplePluginConfig(this);

    // 2.) register events.
    registerEvents();
  }

  private void registerEvents() {
    Bukkit.getServer().getPluginManager().registerEvents(
        new PlayerTeleportListener(config), this);
  }

}
