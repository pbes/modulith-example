package hu.pbes.blog.modulithexample.order.internal.action;

import hu.pbes.blog.modulithexample.order.event.OrderCancelledEvent;
import hu.pbes.blog.modulithexample.order.internal.entity.OrderState;
import hu.pbes.blog.modulithexample.order.internal.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancelOrderAction {

    private final OrderRepository orderRepository;

    private final ApplicationEventPublisher eventPublisher;

    @Transactional(Transactional.TxType.REQUIRED)
    public void execute(String orderId) {
        final var order = orderRepository.findById(orderId).orElseThrow();
        if (order.getState() != OrderState.CREATED && order.getState() != OrderState.CONFIRMED) {
            throw new IllegalStateException("Order is not cancellable");
        }

        order.setState(OrderState.CANCELLED);
        orderRepository.save(order);

        eventPublisher.publishEvent(new OrderCancelledEvent(this, orderId));
    }

}
