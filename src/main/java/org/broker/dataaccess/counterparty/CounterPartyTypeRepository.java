package org.broker.dataaccess.counterparty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CounterPartyTypeRepository extends JpaRepository<CounterPartyTypeEntity, Long> {

    Optional<CounterPartyTypeEntity> findCounterPartyTypeByCommonInputData_Name(String name);

    @Query("SELECT new org.broker.dataaccess.counterparty.CounterpartyType(c.id, " +
            "c.commonInputData.name, " +
            "c.commonInputData.description) " +
            "FROM CounterPartyType c")
    List<CounterpartyType> findAllDTO();
}
