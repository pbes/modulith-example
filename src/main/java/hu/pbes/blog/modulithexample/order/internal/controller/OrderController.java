package hu.pbes.blog.modulithexample.order.internal.controller;

import hu.pbes.blog.modulithexample.order.internal.action.CancelOrderAction;
import hu.pbes.blog.modulithexample.order.internal.action.CreateOrderAction;
import hu.pbes.blog.modulithexample.order.internal.dto.CreateOrderDTO;
import hu.pbes.blog.modulithexample.order.internal.dto.OrderDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CreateOrderAction createOrderAction;

    private final CancelOrderAction cancelOrderAction;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(
        @RequestBody @Valid CreateOrderDTO createOrderDTO
    ) {
        final var result = createOrderAction.execute(createOrderDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(
            @PathVariable String orderId
    ) {
        cancelOrderAction.execute(orderId);
    }

}
