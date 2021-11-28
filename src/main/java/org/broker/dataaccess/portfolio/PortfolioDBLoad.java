package org.broker.dataaccess.portfolio;

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
public class PortfolioDBLoad implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(PortfolioDBLoad.class);

    @Autowired
    private PortfolioService portfolioService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Configuration...");

        final PortfolioEntity tradingPortfolioEntity = new PortfolioEntity(new CommonInputData("100100",
                "Trading desk 1"));
        final PortfolioEntity clientPortfolioEntity = new PortfolioEntity(new CommonInputData("200100",
                "Client portfolio"));

        portfolioService.bulkUpset(List.of(tradingPortfolioEntity, clientPortfolioEntity));
    }
}
