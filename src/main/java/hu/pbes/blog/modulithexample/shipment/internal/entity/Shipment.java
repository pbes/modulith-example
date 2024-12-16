package hu.pbes.blog.modulithexample.shipment.internal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, name = "order_id")
    private String orderId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "state", length = 50)
    private ShipmentState state;

}
