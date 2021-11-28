package org.broker.dataaccess.instrument;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InstrumentTypeService {

    private final InstrumentTypeRepository instrumentTypeRepository;

    @Transactional
    public void bulkUpset(final List<InstrumentTypeEntity> instrumentTypeEntityList) {
        instrumentTypeEntityList.forEach(instrumentTypeRepository::save);
    }

    public InstrumentTypeEntity getInstrumentType(String instFxSpot) {
        return instrumentTypeRepository.findByCommonInputData_Name(instFxSpot).orElseThrow();
    }

    public List<InstrumentType> getAllInstrumentsType() {
        return instrumentTypeRepository.findAllDTO();
    }

    public List<String> getAllCurrencies() {
        return Arrays.stream(Currencies.values()).map(currency -> currency.name()).collect(Collectors.toList());
    }
}
