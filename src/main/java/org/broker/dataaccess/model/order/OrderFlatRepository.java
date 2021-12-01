package org.broker.dataaccess.model.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFlatRepository extends JpaRepository<OrderFlatEntity, Long> {
}
