package org.broker.dataaccess.database.config;

import org.broker.dataaccess.model.embeddable.CommonInputData;
import org.broker.dataaccess.model.instrument.InstrumentTypeEntity;
import org.broker.dataaccess.model.instrument.InstrumentTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(value = 2)
@Component
public class InstrumentTypeDBLoad implements CommandLineRunner {

    public static final String INST_FX_SPOT = "FXSpot";
    private static Logger logger = LoggerFactory.getLogger(InstrumentTypeDBLoad.class);
    @Autowired
    private InstrumentTypeService instrumentTypeService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Configuration...");

        final InstrumentTypeEntity fxSpot = new InstrumentTypeEntity(new CommonInputData(INST_FX_SPOT,
                "Instrument " + INST_FX_SPOT));

        instrumentTypeService.bulkUpset(List.of(fxSpot));
    }
}
