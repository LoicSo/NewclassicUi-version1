package org.eclipse.smarthome.ui.classic.event_subscriber;

import org.eclipse.smarthome.core.events.EventFilter;
import org.eclipse.smarthome.core.events.TopicEventFilter;
import org.eclipse.smarthome.core.items.events.AbstractItemEventSubscriber;
import org.eclipse.smarthome.core.items.events.ItemCommandEvent;
import org.eclipse.smarthome.core.items.events.ItemStateEvent;
import org.eclipse.smarthome.core.types.Command;

public class CameraEventSubscriber extends AbstractItemEventSubscriber {

    private final EventFilter eventFilter = new TopicEventFilter("smarthome/inbox/.*");
    // "smarthome/inbox/upnpcamera:camera:bc329e00-1dd8-11b2-8601-28107b13b27e/added");

    @Override
    public EventFilter getEventFilter() {
        System.err.println("TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
        return eventFilter;
    }

    @Override
    protected void receiveCommand(ItemCommandEvent event) {

        String topic = event.getTopic();
        String type = event.getType();
        String payload = event.getPayload();

        String itemName = event.getItemName();
        System.err.println("ceci est un test de item name: " + itemName);

        Command command = event.getItemCommand();
        // ...
    }

    @Override
    protected void receiveUpdate(ItemStateEvent stateEvent) {

    }

}
