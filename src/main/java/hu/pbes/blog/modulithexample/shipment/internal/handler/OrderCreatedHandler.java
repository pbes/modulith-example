package hu.pbes.blog.modulithexample.shipment.internal.handler;

import hu.pbes.blog.modulithexample.order.event.OrderCreatedEvent;
import hu.pbes.blog.modulithexample.shipment.event.ShipmentCreatedEvent;
import hu.pbes.blog.modulithexample.shipment.internal.entity.Shipment;
import hu.pbes.blog.modulithexample.shipment.internal.entity.ShipmentState;
import hu.pbes.blog.modulithexample.shipment.internal.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderCreatedHandler {

    private final ShipmentRepository shipmentRepository;

    private final ApplicationEventPublisher eventPublisher;

    @ApplicationModuleListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        log.info("Order created: {}", event.getOrderId());
        final var shipment = new Shipment();
        shipment.setOrderId(event.getOrderId());
        shipment.setState(ShipmentState.CREATED);
        final var savedShipment = shipmentRepository.save(shipment);

        eventPublisher.publishEvent(new ShipmentCreatedEvent(this, savedShipment.getId()));
    }
}
