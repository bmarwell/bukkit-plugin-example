package de.bmarwell.bukkit;

import com.google.common.base.Enums;
import com.google.common.base.Optional;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class ExamplePluginConfig {

  private final Logger logger;
  private FileConfiguration config;
  private final JavaPlugin plugin;

  private Optional<TeleportCause> teleportCauseToCancel = null;

  /**
   * Creates a Plugin config for this plugin.
   *
   * @param plugin
   *          enter <i>this</i> from your main class.
   */
  public ExamplePluginConfig(final JavaPlugin plugin) {
    this.plugin = plugin;
    this.config = plugin.getConfig();
    this.logger = plugin.getLogger();

    reloadConfig();
  }

  /**
   * Force reload the config.
   */
  public void reloadConfig() {
    plugin.reloadConfig();
    this.config = plugin.getConfig();

    String cancelCause = config.getRoot().getString("cancel.cause");
    this.teleportCauseToCancel = Enums.getIfPresent(TeleportCause.class, cancelCause);
  }

  public Logger getLogger() {
    return logger;
  }

  public FileConfiguration getConfig() {
    return config;
  }

  public JavaPlugin getPlugin() {
    return plugin;
  }

  public Optional<TeleportCause> getTeleportCauseToCancel() {
    return teleportCauseToCancel;
  }

}
