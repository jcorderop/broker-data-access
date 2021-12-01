package org.broker.dataaccess.model.trade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeTypeRepository extends JpaRepository<TradeTypeEntity, Long> {

    @Query("SELECT new org.broker.dataaccess.model.trade.TradeType(c.id, " +
            "c.commonInputData.name, " +
            "c.commonInputData.description) " +
            "FROM TradeType c")
    List<TradeType> findAllDTO();
}
