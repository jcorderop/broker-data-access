package org.broker.dataaccess.database.config;

import org.broker.dataaccess.model.counterparty.CounterPartyTypeEntity;
import org.broker.dataaccess.model.counterparty.CounterPartyTypeService;
import org.broker.dataaccess.model.embeddable.CommonInputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(value = 2)
@Component
public class CounterPartyTypeDBLoad implements CommandLineRunner {

    public static final String COUNTERPARTY_TYPE_CLIENT = "Client";
    public static final String COUNTERPARTY_TYPE_BROKER = "Broker";
    private static Logger logger = LoggerFactory.getLogger(CounterPartyTypeDBLoad.class);
    @Autowired
    private CounterPartyTypeService counterPartyTypeService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Configuration...");

        final CounterPartyTypeEntity client = new CounterPartyTypeEntity(new CommonInputData(COUNTERPARTY_TYPE_CLIENT,
                COUNTERPARTY_TYPE_CLIENT + " counterparty type"));
        final CounterPartyTypeEntity broker = new CounterPartyTypeEntity(new CommonInputData(COUNTERPARTY_TYPE_BROKER,
                COUNTERPARTY_TYPE_BROKER + " counterparty type"));

        counterPartyTypeService.bulkUpset(List.of(client, broker));
    }
}
