package org.broker.dataaccess.counterparty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounterPartyRepository extends JpaRepository<CounterPartyEntity, Long> {

    @Query("SELECT new org.broker.dataaccess.counterparty.Counterparty(c.id, " +
            "c.alias, " +
            "c.email, " +
            "c.individual, " +
            "c.corporateName, " +
            "c.fistName, " +
            "c.lastName, " +
            "c.telephone, " +
            "c.address) FROM CounterParty c")
    List<Counterparty> findAllDTO();
}
