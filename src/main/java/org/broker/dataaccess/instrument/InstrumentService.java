package org.broker.dataaccess.instrument;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class InstrumentService {

    private final InstrumentRepository instrumentRepository;

    @Transactional
    public void bulkUpset(final List<InstrumentEntity> instrumentEntityList) {
        instrumentEntityList.forEach(instrumentRepository::save);
    }

    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAllDTO();
    }
}
