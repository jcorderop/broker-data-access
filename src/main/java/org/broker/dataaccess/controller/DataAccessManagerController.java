package org.broker.dataaccess.controller;

import lombok.AllArgsConstructor;
import org.broker.dataaccess.counterparty.*;
import org.broker.dataaccess.instrument.Instrument;
import org.broker.dataaccess.instrument.InstrumentService;
import org.broker.dataaccess.instrument.InstrumentType;
import org.broker.dataaccess.instrument.InstrumentTypeService;
import org.broker.dataaccess.order.OrderType;
import org.broker.dataaccess.order.OrderTypeService;
import org.broker.dataaccess.portfolio.Portfolio;
import org.broker.dataaccess.portfolio.PortfolioService;
import org.broker.dataaccess.status.Status;
import org.broker.dataaccess.status.StatusService;
import org.broker.dataaccess.trade.TradeType;
import org.broker.dataaccess.trade.TradeTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
@AllArgsConstructor
public class DataAccessManagerController {

    private static Logger logger = LoggerFactory.getLogger(CounterPartyDBLoad.class);

    private final CounterPartyService counterPartyService;
    private final CounterPartyTypeService counterPartyTypeService;
    private final InstrumentService instrumentService;
    private final InstrumentTypeService instrumentTypeService;
    private final OrderTypeService orderTypeService;
    private final PortfolioService portfolioService;
    private final StatusService statusService;
    private final TradeTypeService tradeTypeService;

    @GetMapping(path = "/counterpartys")
    public List<Counterparty> getCounterparties() {
        final var counterparties = counterPartyService.getAllCounterParties();
        logger.info("N.of CounterParties: {}", counterparties.size());
        return counterparties;
    }

    @GetMapping(path = "/counterpartiestype")
    public List<CounterpartyType> getCounterpartiesType() {
        final var counterpartyTypes = counterPartyTypeService.getAllCounterPartyTypes();
        logger.info("N.of CounterPartyTypes: {}", counterpartyTypes.size());
        return counterpartyTypes;
    }

    @GetMapping(path = "/instruments")
    public List<Instrument> getInstruments() {
        final var instruments = instrumentService.getAllInstruments();
        logger.info("N.of Instruments: {}", instruments.size());
        return instruments;
    }

    @GetMapping(path = "/instrumentsType")
    public List<InstrumentType> getInstrumentsType() {
        final var instrumentsType = instrumentTypeService.getAllInstrumentsType();
        logger.info("N.of InstrumentsType: {}", instrumentsType.size());
        return instrumentsType;
    }

    @GetMapping(path = "/currencies")
    public List<String> getCurrenciesType() {
        final var currency = instrumentTypeService.getAllCurrencies();
        logger.info("N.of Currency: {}", currency.size());
        return currency;
    }

    @GetMapping(path = "/orderstype")
    public List<OrderType> getOrdersType() {
        final var ordersType = orderTypeService.getAllOrdersType();
        logger.info("N.of OrdersTypes: {}", ordersType.size());
        return ordersType;
    }

    @GetMapping(path = "/portfolios")
    public List<Portfolio> getPortfolios() {
        final var portfolios = portfolioService.getAllPortfolios();
        logger.info("N.of Portfolio: {}", portfolios.size());
        return portfolios;
    }

    @GetMapping(path = "/status")
    public List<Status> getStatus() {
        final var status = statusService.getAllStatus();
        logger.info("N.of Status: {}", status.size());
        return status;
    }

    @GetMapping(path = "/tradeType")
    public List<TradeType> getTradesType() {
        final var tradesTypes = tradeTypeService.getAllTradeTypes();
        logger.info("N.of TradesTypes: {}", tradesTypes.size());
        return tradesTypes;
    }
}
