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

package de.bmarwell.bukkit.test.helper;

import com.google.common.collect.Lists;

import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.UnknownDependencyException;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * Pluginmanager, which saves events to a map.
 */
public class ListingPluginManager implements PluginManager {

  private List<Event> eventsCalled = Lists.newArrayList();

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#registerInterface(java.lang.Class)
   */
  @Override
  public void registerInterface(Class<? extends PluginLoader> loader)
      throws IllegalArgumentException {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#getPlugin(java.lang.String)
   */
  @Override
  public Plugin getPlugin(String name) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#getPlugins()
   */
  @Override
  public Plugin[] getPlugins() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#isPluginEnabled(java.lang.String)
   */
  @Override
  public boolean isPluginEnabled(String name) {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#isPluginEnabled(org.bukkit.plugin.Plugin)
   */
  @Override
  public boolean isPluginEnabled(Plugin plugin) {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#loadPlugin(java.io.File)
   */
  @Override
  public Plugin loadPlugin(File file)
      throws InvalidPluginException, InvalidDescriptionException, UnknownDependencyException {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#loadPlugins(java.io.File)
   */
  @Override
  public Plugin[] loadPlugins(File directory) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#disablePlugins()
   */
  @Override
  public void disablePlugins() {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#clearPlugins()
   */
  @Override
  public void clearPlugins() {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#callEvent(org.bukkit.event.Event)
   */
  @Override
  public void callEvent(Event event) throws IllegalStateException {
    if (null == event) {
      throw new IllegalStateException("Event is null!");
    }

    this.getEventsCalled().add(event);
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#registerEvents(org.bukkit.event.Listener, org.bukkit.plugin.Plugin)
   */
  @Override
  public void registerEvents(Listener listener, Plugin plugin) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#registerEvent(java.lang.Class, org.bukkit.event.Listener, org.bukkit.event.EventPriority, org.bukkit.plugin.EventExecutor, org.bukkit.plugin.Plugin)
   */
  @Override
  public void registerEvent(Class<? extends Event> event, Listener listener, EventPriority priority,
      EventExecutor executor, Plugin plugin) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#registerEvent(java.lang.Class, org.bukkit.event.Listener, org.bukkit.event.EventPriority, org.bukkit.plugin.EventExecutor, org.bukkit.plugin.Plugin, boolean)
   */
  @Override
  public void registerEvent(Class<? extends Event> event, Listener listener, EventPriority priority,
      EventExecutor executor, Plugin plugin, boolean ignoreCancelled) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#enablePlugin(org.bukkit.plugin.Plugin)
   */
  @Override
  public void enablePlugin(Plugin plugin) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#disablePlugin(org.bukkit.plugin.Plugin)
   */
  @Override
  public void disablePlugin(Plugin plugin) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#getPermission(java.lang.String)
   */
  @Override
  public Permission getPermission(String name) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#addPermission(org.bukkit.permissions.Permission)
   */
  @Override
  public void addPermission(Permission perm) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#removePermission(org.bukkit.permissions.Permission)
   */
  @Override
  public void removePermission(Permission perm) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#removePermission(java.lang.String)
   */
  @Override
  public void removePermission(String name) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#getDefaultPermissions(boolean)
   */
  @Override
  public Set<Permission> getDefaultPermissions(boolean op) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#recalculatePermissionDefaults(org.bukkit.permissions.Permission)
   */
  @Override
  public void recalculatePermissionDefaults(Permission perm) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#subscribeToPermission(java.lang.String, org.bukkit.permissions.Permissible)
   */
  @Override
  public void subscribeToPermission(String permission, Permissible permissible) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#unsubscribeFromPermission(java.lang.String, org.bukkit.permissions.Permissible)
   */
  @Override
  public void unsubscribeFromPermission(String permission, Permissible permissible) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#getPermissionSubscriptions(java.lang.String)
   */
  @Override
  public Set<Permissible> getPermissionSubscriptions(String permission) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#subscribeToDefaultPerms(boolean, org.bukkit.permissions.Permissible)
   */
  @Override
  public void subscribeToDefaultPerms(boolean op, Permissible permissible) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#unsubscribeFromDefaultPerms(boolean, org.bukkit.permissions.Permissible)
   */
  @Override
  public void unsubscribeFromDefaultPerms(boolean op, Permissible permissible) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#getDefaultPermSubscriptions(boolean)
   */
  @Override
  public Set<Permissible> getDefaultPermSubscriptions(boolean op) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#getPermissions()
   */
  @Override
  public Set<Permission> getPermissions() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.bukkit.plugin.PluginManager#useTimings()
   */
  @Override
  public boolean useTimings() {
    // TODO Auto-generated method stub
    return false;
  }

  public List<Event> getEventsCalled() {
    return eventsCalled;
  }

}
