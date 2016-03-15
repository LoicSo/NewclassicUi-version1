package org.eclipse.smarthome.ui.classic.event_subscriber;

import java.util.Set;

import org.eclipse.smarthome.config.discovery.inbox.events.InboxAddedEvent;
import org.eclipse.smarthome.core.events.Event;
import org.eclipse.smarthome.core.events.EventFilter;
import org.eclipse.smarthome.core.events.EventSubscriber;
import org.eclipse.smarthome.core.events.TopicEventFilter;

import com.google.common.collect.ImmutableSet;

public class CameraSubscriber implements EventSubscriber {

    private final Set<String> subscribedEventTypes = ImmutableSet.of(EventSubscriber.ALL_EVENT_TYPES);
    // ItemStateEvent.TYPE, ItemCommandEvent.TYPE,InboxAddedEvent.TYPE, InboxUpdatedEvent.TYPE);
    private final EventFilter eventFilter = new TopicEventFilter(
            // "smarthome/inbox/.*");
            "smarthome/inbox/upnpcamera:camera:bc329e00-1dd8-11b2-8601-28107b13b27e/.*");

    @Override
    public Set<String> getSubscribedEventTypes() {
        // TODO Auto-generated method stub
        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXTT");
        return subscribedEventTypes;
    }

    @Override
    public EventFilter getEventFilter() {
        // TODO Auto-generated method stub
        System.err.println("TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
        // return eventFilter;
        return null;
    }

    @Override
    public void receive(Event event) {
        // TODO Auto-generated method stub
        String topic = event.getTopic();
        String type = event.getType();
        String payload = event.getPayload();
        if (event instanceof InboxAddedEvent) {

            InboxAddedEvent itemCommandEvent = (InboxAddedEvent) event;

            // Command command = itemCommandEvent.getItemCommand();

            System.err.println("ceci est un test de item name: " + itemCommandEvent.getDiscoveryResult());
            // ...
        }

    }
}
