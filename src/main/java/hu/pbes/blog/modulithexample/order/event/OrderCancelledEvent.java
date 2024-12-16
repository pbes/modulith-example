package hu.pbes.blog.modulithexample.order.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OrderCancelledEvent extends ApplicationEvent {
    private String orderId;

    public OrderCancelledEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }
}
