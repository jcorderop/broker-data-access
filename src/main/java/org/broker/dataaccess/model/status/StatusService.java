package org.broker.dataaccess.model.status;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class StatusService {

    private final StatusRepository statusRepository;

    @Transactional
    public void bulkUpset(final List<StatusEntity> statusList) {
        statusList.forEach(statusRepository::save);
    }

    public List<Status> getAllStatus() {
        return statusRepository.findAllDTO();
    }
}
