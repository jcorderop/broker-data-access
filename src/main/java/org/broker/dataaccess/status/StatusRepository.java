package org.broker.dataaccess.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {

    @Query("SELECT new org.broker.dataaccess.status.Status(c.id, " +
            "c.commonInputData.name, " +
            "c.commonInputData.description) " +
            "FROM Status c")
    List<Status> findAllDTO();
}
