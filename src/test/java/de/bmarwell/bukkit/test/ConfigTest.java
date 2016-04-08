package de.bmarwell.bukkit.test;

import de.bmarwell.bukkit.ExamplePlugin;
import de.bmarwell.bukkit.ExamplePluginConfig;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

public class ConfigTest {

  private static final Logger LOG = Logger.getLogger("ConfigTest");

  private ExamplePluginConfig epc;

  @Before
  public void setUp() throws FileNotFoundException, IOException, InvalidConfigurationException {
    ExamplePlugin exPl = Mockito.mock(ExamplePlugin.class);

    File configfile = new File(getClass().getResource("/config.yml").getPath());
    LOG.info("Using config file [" + configfile.getAbsolutePath() + "].");
    YamlConfiguration configuration = new YamlConfiguration();
    configuration.load(configfile.getAbsolutePath());
    Mockito.doReturn(configuration).when(exPl).getConfig();
    this.epc = new ExamplePluginConfig(exPl);
  }

  @Test
  public void testCreateConfig() {
    Assert.assertTrue(epc.getTeleportCauseToCancel().isPresent());
    Assert.assertEquals(TeleportCause.ENDER_PEARL, epc.getTeleportCauseToCancel().get());
  }

}
