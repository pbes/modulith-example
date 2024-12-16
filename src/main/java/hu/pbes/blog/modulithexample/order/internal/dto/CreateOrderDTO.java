package hu.pbes.blog.modulithexample.order.internal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateOrderDTO {

    @NotNull(message = "order.userId.required")
    @Size(max = 255, message = "order.userId.length")
    private String userId;

}
