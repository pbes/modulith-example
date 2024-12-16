package hu.pbes.blog.modulithexample.order.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hu.pbes.blog.modulithexample.order.internal.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
