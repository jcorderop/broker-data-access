package org.broker.dataaccess.model.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderTypeService {

    private final OrderTypeRepository orderTypeRepository;

    @Transactional
    public void bulkUpset(final List<OrderTypeEntity> orderTypeEntityList) {
        orderTypeEntityList.forEach(orderTypeRepository::save);
    }

    public List<OrderType> getAllOrdersType() {
        return orderTypeRepository.findAllDTO();
    }
}
