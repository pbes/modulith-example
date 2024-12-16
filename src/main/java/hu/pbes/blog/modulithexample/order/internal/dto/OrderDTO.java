package hu.pbes.blog.modulithexample.order.internal.dto;

import hu.pbes.blog.modulithexample.order.internal.entity.OrderState;
import lombok.Data;

@Data
public class OrderDTO {
    private String id;
    private String userId;
    private OrderState state;

}
