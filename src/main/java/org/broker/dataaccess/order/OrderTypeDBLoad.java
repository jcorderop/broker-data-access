package org.broker.dataaccess.order;

import org.broker.dataaccess.embeddable.CommonInputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(value = 2)
@Component
public class OrderTypeDBLoad implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(OrderTypeDBLoad.class);

    @Autowired
    private OrderTypeService orderTypeService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Configuration...");

        final OrderTypeEntity market = new OrderTypeEntity(new CommonInputData("Market",
                "Market order type"));
        final OrderTypeEntity limit = new OrderTypeEntity(new CommonInputData("Limit",
                "Limit order type"));

        orderTypeService.bulkUpset(List.of(market, limit));

    }
}
