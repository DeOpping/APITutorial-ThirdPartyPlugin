package dev.paracausal.thirdparty;

import dev.paracausal.testplugin.api.TestAPI;
import dev.paracausal.thirdparty.listeners.AddCurrencyListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ThirdParty extends JavaPlugin {

    private TestAPI testApi;

    @Override
    public void onEnable() {
        final Plugin testPlugin = getServer().getPluginManager().getPlugin("TestPlugin");
        if (testPlugin == null) {
            getLogger().info("This plugin requires TestPlugin!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        testApi = (TestAPI) testPlugin;
        new AddCurrencyListener(this);
        getLogger().info("ThirdParty enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ThirdParty disabled!");
    }

    public TestAPI testApi() { return testApi; }

}
