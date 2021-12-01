package org.broker.dataaccess.database.config;

import org.broker.dataaccess.model.embeddable.CommonInputData;
import org.broker.dataaccess.model.trade.TradeTypeEntity;
import org.broker.dataaccess.model.trade.TradeTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(value = 2)
@Component
public class TradeTypeDBLoad implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(TradeTypeDBLoad.class);

    @Autowired
    private TradeTypeService tradeTypeService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Configuration...");

        final TradeTypeEntity normal = new TradeTypeEntity(new CommonInputData("Normal",
                "Normal Trade type"));
        final TradeTypeEntity exercise = new TradeTypeEntity(new CommonInputData("Exercise",
                "Exercise Trade type"));

        tradeTypeService.bulkUpset(List.of(normal, exercise));
    }
}
