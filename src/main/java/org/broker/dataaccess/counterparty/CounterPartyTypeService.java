package org.broker.dataaccess.counterparty;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static org.broker.dataaccess.counterparty.CounterPartyTypeDBLoad.COUNTERPARTY_TYPE_BROKER;
import static org.broker.dataaccess.counterparty.CounterPartyTypeDBLoad.COUNTERPARTY_TYPE_CLIENT;

@AllArgsConstructor
@Service
public class CounterPartyTypeService {

    private final CounterPartyTypeRepository counterPartyTypeRepository;

    @Transactional
    public void bulkUpset(final List<CounterPartyTypeEntity> counterPartyTypeList) {
        counterPartyTypeList.forEach(counterPartyTypeRepository::save);
    }

    public CounterPartyTypeEntity getCounterpartyBroker() {
        return counterPartyTypeRepository.findCounterPartyTypeByCommonInputData_Name(COUNTERPARTY_TYPE_BROKER)
                .orElseThrow();
    }

    public CounterPartyTypeEntity getCounterpartyClient() {
        return counterPartyTypeRepository.findCounterPartyTypeByCommonInputData_Name(COUNTERPARTY_TYPE_CLIENT)
                .orElseThrow();
    }

    public List<CounterpartyType> getAllCounterPartyTypes() {
        return counterPartyTypeRepository.findAllDTO();
    }
}
