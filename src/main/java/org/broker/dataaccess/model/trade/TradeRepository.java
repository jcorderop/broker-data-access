package org.broker.dataaccess.model.trade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TradeRepository extends JpaRepository<TradeEntity, Long> {
}
