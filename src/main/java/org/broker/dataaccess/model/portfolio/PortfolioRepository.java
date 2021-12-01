package org.broker.dataaccess.model.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Long> {

    @Query("SELECT new org.broker.dataaccess.model.portfolio.Portfolio(c.id, " +
            "c.commonInputData.name, " +
            "c.commonInputData.description) " +
            "FROM Portfolio c")
    List<Portfolio> findAllDTO();
}
