package hu.pbes.blog.modulithexample.shipment.internal.repository;

import hu.pbes.blog.modulithexample.shipment.internal.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String> {

    List<Shipment> findByOrderId(String orderId);

}
