package org.broker.dataaccess.database.config;

import org.broker.dataaccess.model.instrument.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(value = 3)
@Component
public class InstrumentDBLoad implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(InstrumentDBLoad.class);

    @Autowired
    private InstrumentService instrumentService;

    @Autowired
    private InstrumentTypeService instrumentTypeService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Configuration...");

        InstrumentTypeEntity instTypeSpot = instrumentTypeService.getInstrumentType(InstrumentTypeDBLoad.INST_FX_SPOT);

        final InstrumentEntity btcusd = new InstrumentEntity(Currencies.BTC.name() + Currencies.USD.name(),
                Currencies.BTC.name(),
                Currencies.USD.name(),
                instTypeSpot);
        final InstrumentEntity solusd = new InstrumentEntity(Currencies.SOL.name() + Currencies.USD.name(),
                Currencies.SOL.name(),
                Currencies.USD.name(),
                instTypeSpot);
        final InstrumentEntity ethusd = new InstrumentEntity(Currencies.ETH.name() + Currencies.USD.name(),
                Currencies.ETH.name(),
                Currencies.USD.name(),
                instTypeSpot);
        final InstrumentEntity adausd = new InstrumentEntity(Currencies.ADA.name() + Currencies.USD.name(),
                Currencies.ADA.name(),
                Currencies.USD.name(),
                instTypeSpot);
        final InstrumentEntity xrpusd = new InstrumentEntity(Currencies.XRP.name() + Currencies.USD.name(),
                Currencies.XRP.name(),
                Currencies.USD.name(),
                instTypeSpot);

        instrumentService.bulkUpset(List.of(btcusd,
                solusd,
                ethusd,
                adausd,
                xrpusd));
    }
}
