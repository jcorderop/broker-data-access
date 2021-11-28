package org.broker.dataaccess.status;

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
public class StatusDBLoad implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(StatusDBLoad.class);

    @Autowired
    private StatusService statusService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Configuration...");
        final StatusEntity cancelled = new StatusEntity(new CommonInputData("Cancelled",
                "Deal Cancelled"));
        final StatusEntity frontOfficeConfirmed = new StatusEntity(new CommonInputData("FO-Confirmed",
                "Trading accepts the deal"));
        final StatusEntity midOfficeConfirmed = new StatusEntity(new CommonInputData("MO-Confirmed",
                "Deal in progress and monitored"));
        final StatusEntity backOfficeConfirmed = new StatusEntity(new CommonInputData("BO-Confirmed",
                "Deal completed and in progress to settle"));

        statusService.bulkUpset(List.of(cancelled,
                frontOfficeConfirmed,
                midOfficeConfirmed,
                backOfficeConfirmed));
    }
}
