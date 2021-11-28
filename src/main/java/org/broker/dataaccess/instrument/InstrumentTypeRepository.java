package org.broker.dataaccess.instrument;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstrumentTypeRepository extends JpaRepository<InstrumentTypeEntity, Long> {

    Optional<InstrumentTypeEntity> findByCommonInputData_Name(String name);

    @Query("SELECT new org.broker.dataaccess.instrument.InstrumentType(c.id, " +
            "c.commonInputData.name, " +
            "c.commonInputData.description) " +
            "FROM InstrumentType c")
    List<InstrumentType> findAllDTO();
}
