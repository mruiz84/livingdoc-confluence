package info.novatec.testit.livingdoc.confluence.listeners;

import com.atlassian.event.api.EventListener;
import com.atlassian.event.api.EventPublisher;
import com.atlassian.plugin.event.events.PluginInstalledEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;


public class UpgradeVersionListener implements DisposableBean {

    private static Logger log = LoggerFactory.getLogger(UpgradeVersionListener.class);


    private EventPublisher eventPublisher;

    public UpgradeVersionListener(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        eventPublisher.register(this);
    }

    @EventListener
    public void pluginInstalledEvent(PluginInstalledEvent pluginInstalledEvent) {
        int pluginVersion = pluginInstalledEvent.getPlugin().getPluginsVersion();

        log.debug("#####################################################################");
        log.debug("#####################################################################");
        log.debug("#### LivingDoc version: " + pluginVersion);
        log.debug("#### pluginInstalledEvent: " + pluginInstalledEvent.toString());
        log.debug("#### pluginInstalledEvent: " + pluginInstalledEvent.getPlugin().toString());
        log.debug("#####################################################################");
        log.debug("#####################################################################");

        System.out.println("#####################################################################");
        System.out.println("#####################################################################");
        System.out.println("#### LivingDoc version: " + pluginVersion);
        System.out.println("#### pluginInstalledEvent: " + pluginInstalledEvent.toString());
        System.out.println("#### pluginInstalledEvent: " + pluginInstalledEvent.getPlugin().toString());
        System.out.println("#####################################################################");
        System.out.println("#####################################################################");

    }

    @Override
    public void destroy() {
        eventPublisher.unregister(this);
    }
}
