package hu.pbes.blog.modulithexample.order.internal.action;

import hu.pbes.blog.modulithexample.order.event.OrderCreatedEvent;
import hu.pbes.blog.modulithexample.order.internal.dto.CreateOrderDTO;
import hu.pbes.blog.modulithexample.order.internal.dto.OrderDTO;
import hu.pbes.blog.modulithexample.order.internal.entity.Order;
import hu.pbes.blog.modulithexample.order.internal.entity.OrderState;
import hu.pbes.blog.modulithexample.order.internal.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrderAction {

    private final OrderRepository orderRepository;

    private final ModelMapper orderMapper;

    private final ApplicationEventPublisher eventPublisher;

    @Transactional(Transactional.TxType.REQUIRED)
    public OrderDTO execute(CreateOrderDTO createOrderDTO) {
        final var order = new Order();
        order.setState(OrderState.CREATED);
        order.setUserId(createOrderDTO.getUserId());

        final var savedOrder = orderRepository.save(order);
        eventPublisher.publishEvent(new OrderCreatedEvent(this, savedOrder.getId()));
        return orderMapper.map(savedOrder, OrderDTO.class);
    }

}
