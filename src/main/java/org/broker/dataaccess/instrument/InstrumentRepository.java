package org.broker.dataaccess.instrument;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentRepository extends JpaRepository<InstrumentEntity, Long> {

    @Query("SELECT new org.broker.dataaccess.instrument.Instrument(c.id, " +
            "c.name, " +
            "c.baseCurrency, " +
            "c.quotedCurrency, " +
            "c.freeTest, " +
            "c.externalId1, " +
            "c.externalId2 ) " +
            "FROM Instrument c")
    List<Instrument> findAllDTO();
}
