package org.broker.dataaccess.trade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class TradeTypeService {

    private final TradeTypeRepository tradeTypeRepository;

    @Transactional
    public void bulkUpset(final List<TradeTypeEntity> tradeTypeEntityList) {
        tradeTypeEntityList.forEach(tradeTypeRepository::save);
    }

    public List<TradeType> getAllTradeTypes() {
        return tradeTypeRepository.findAllDTO();
    }
}
