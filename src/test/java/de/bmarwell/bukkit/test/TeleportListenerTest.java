package de.bmarwell.bukkit.test;

import de.bmarwell.bukkit.ExamplePlugin;
import de.bmarwell.bukkit.ExamplePluginConfig;
import de.bmarwell.bukkit.events.PlayerTeleportCancelledEvent;
import de.bmarwell.bukkit.listener.PlayerTeleportListener;
import de.bmarwell.bukkit.test.helper.ListingPluginManager;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.PluginManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

@PrepareForTest({ Bukkit.class, ExamplePlugin.class })
public class TeleportListenerTest {

  private static final Logger LOG = Logger.getLogger("TeleportListenerTest");

  @Rule
  public PowerMockRule rule = new PowerMockRule();

  private ExamplePluginConfig epc;

  private PlayerTeleportListener tpListener;

  @Before
  public void setUp() throws FileNotFoundException, IOException, InvalidConfigurationException {
    ExamplePlugin exPl = PowerMockito.mock(ExamplePlugin.class);

    File configfile = new File(getClass().getResource("/config.yml").getPath());
    LOG.info("Using config file [" + configfile.getAbsolutePath() + "].");
    YamlConfiguration configuration = new YamlConfiguration();
    configuration.load(configfile.getAbsolutePath());
    Mockito.doReturn(configuration).when(exPl).getConfig();
    this.epc = new ExamplePluginConfig(exPl);

    tpListener = new PlayerTeleportListener(epc);

    PluginManager pm = new ListingPluginManager();

    PowerMockito.mockStatic(Bukkit.class);
    Server server = PowerMockito.mock(Server.class);
    PowerMockito.doReturn(pm).when(server).getPluginManager();
    Mockito.when(Bukkit.getServer()).thenReturn(server);
  }

  @Test
  public void test() {
    PlayerTeleportEvent event = new PlayerTeleportEvent(null, null, null,
        TeleportCause.ENDER_PEARL);

    Assert.assertNotNull(
        ListingPluginManager.class == Bukkit.getServer().getPluginManager().getClass());
    ListingPluginManager truePm = (ListingPluginManager) Bukkit.getServer().getPluginManager();
    Assert.assertEquals(0, truePm.getEventsCalled().size());

    tpListener.onPlayerTeleport(event);

    Assert.assertEquals(1, truePm.getEventsCalled().size());
    Event called = truePm.getEventsCalled().get(0);
    Assert.assertTrue(PlayerTeleportCancelledEvent.class == called.getClass());
  }

}
