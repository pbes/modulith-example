package hu.pbes.blog.modulithexample.shipment.internal.handler;

import hu.pbes.blog.modulithexample.order.event.OrderCancelledEvent;
import hu.pbes.blog.modulithexample.shipment.internal.entity.ShipmentState;
import hu.pbes.blog.modulithexample.shipment.internal.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderCancelledHandler {

    private final ShipmentRepository shipmentRepository;

    @ApplicationModuleListener
    public void handleOrderCancelled(OrderCancelledEvent event) {
        log.info("Order cancelled: {}", event.getOrderId());
        shipmentRepository.findByOrderId(event.getOrderId())
                .forEach(shipment -> {
                    shipment.setState(ShipmentState.CANCELLED);
                    shipmentRepository.save(shipment);
                });
    }
}
