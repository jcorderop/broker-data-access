package org.broker.dataaccess.model.counterparty;

import lombok.AllArgsConstructor;
import org.broker.dataaccess.database.config.CounterPartyTypeDBLoad;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class CounterPartyTypeService {

    private final CounterPartyTypeRepository counterPartyTypeRepository;

    @Transactional
    public void bulkUpset(final List<CounterPartyTypeEntity> counterPartyTypeList) {
        counterPartyTypeList.forEach(counterPartyTypeRepository::save);
    }

    public CounterPartyTypeEntity getCounterpartyBroker() {
        return counterPartyTypeRepository.findCounterPartyTypeByCommonInputData_Name(CounterPartyTypeDBLoad.COUNTERPARTY_TYPE_BROKER)
                .orElseThrow();
    }

    public CounterPartyTypeEntity getCounterpartyClient() {
        return counterPartyTypeRepository.findCounterPartyTypeByCommonInputData_Name(CounterPartyTypeDBLoad.COUNTERPARTY_TYPE_CLIENT)
                .orElseThrow();
    }

    public List<CounterpartyType> getAllCounterPartyTypes() {
        return counterPartyTypeRepository.findAllDTO();
    }
}
