package hu.pbes.blog.modulithexample.shipment.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.modulith.events.Externalized;

@Externalized
public class ShipmentCreatedEvent extends ApplicationEvent {

    private String shipmentId;

    public ShipmentCreatedEvent(Object source, String shipmentId) {
        super(source);
        this.shipmentId = shipmentId;
    }
}
