package org.broker.dataaccess.counterparty;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class CounterPartyService {

    private final CounterPartyRepository counterPartyRepository;

    @Transactional
    public void bulkUpset(final List<CounterPartyEntity> counterPartyList) {
        counterPartyList.forEach(counterPartyRepository::save);
    }

    public List<Counterparty> getAllCounterParties() {
        return counterPartyRepository.findAllDTO();
    }
}
