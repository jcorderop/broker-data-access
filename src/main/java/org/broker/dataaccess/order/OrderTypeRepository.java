package org.broker.dataaccess.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTypeRepository extends JpaRepository<OrderTypeEntity, Long> {

    @Query("SELECT new org.broker.dataaccess.order.OrderType(c.id, " +
            "c.commonInputData.name, " +
            "c.commonInputData.description) " +
            "FROM OrderType c")
    List<OrderType> findAllDTO();
}
