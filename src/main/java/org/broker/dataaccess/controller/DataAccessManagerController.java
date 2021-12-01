package org.broker.dataaccess.controller;

import lombok.AllArgsConstructor;
import org.broker.dataaccess.database.config.CounterPartyDBLoad;
import org.broker.dataaccess.model.counterparty.CounterPartyService;
import org.broker.dataaccess.model.counterparty.CounterPartyTypeService;
import org.broker.dataaccess.model.counterparty.Counterparty;
import org.broker.dataaccess.model.counterparty.CounterpartyType;
import org.broker.dataaccess.model.instrument.Instrument;
import org.broker.dataaccess.model.instrument.InstrumentService;
import org.broker.dataaccess.model.instrument.InstrumentType;
import org.broker.dataaccess.model.instrument.InstrumentTypeService;
import org.broker.dataaccess.model.order.OrderType;
import org.broker.dataaccess.model.order.OrderTypeService;
import org.broker.dataaccess.model.portfolio.Portfolio;
import org.broker.dataaccess.model.portfolio.PortfolioService;
import org.broker.dataaccess.model.status.Status;
import org.broker.dataaccess.model.status.StatusService;
import org.broker.dataaccess.model.trade.TradeType;
import org.broker.dataaccess.model.trade.TradeTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.broker.dataaccess.controller.DataAccessEndPoints.*;

@RestController
@RequestMapping(path = API_NAME)
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

    @GetMapping(path = ENDPOINT_COUNTERPARTYS)
    public List<Counterparty> getCounterparties() {
        final var counterparties = counterPartyService.getAllCounterParties();
        logger.info("N.of CounterParties: {}", counterparties.size());
        return counterparties;
    }

    @GetMapping(path = ENDPOINT_COUNTERPARTIESTYPE)
    public List<CounterpartyType> getCounterpartiesType() {
        final var counterpartyTypes = counterPartyTypeService.getAllCounterPartyTypes();
        logger.info("N.of CounterPartyTypes: {}", counterpartyTypes.size());
        return counterpartyTypes;
    }

    @GetMapping(path = ENDPOINT_INSTRUMENTS)
    public List<Instrument> getInstruments() {
        final var instruments = instrumentService.getAllInstruments();
        logger.info("N.of Instruments: {}", instruments.size());
        return instruments;
    }

    @GetMapping(path = ENDPOINT_INSTRUMENTS_TYPE)
    public List<InstrumentType> getInstrumentsType() {
        final var instrumentsType = instrumentTypeService.getAllInstrumentsType();
        logger.info("N.of InstrumentsType: {}", instrumentsType.size());
        return instrumentsType;
    }

    @GetMapping(path = ENDPOINT_CURRENCIES)
    public List<String> getCurrenciesType() {
        final var currency = instrumentTypeService.getAllCurrencies();
        logger.info("N.of Currency: {}", currency.size());
        return currency;
    }

    @GetMapping(path = ENDPOINT_ORDERSTYPE)
    public List<OrderType> getOrdersType() {
        final var ordersType = orderTypeService.getAllOrdersType();
        logger.info("N.of OrdersTypes: {}", ordersType.size());
        return ordersType;
    }

    @GetMapping(path = ENDPOINT_PORTFOLIOS)
    public List<Portfolio> getPortfolios() {
        final var portfolios = portfolioService.getAllPortfolios();
        logger.info("N.of Portfolio: {}", portfolios.size());
        return portfolios;
    }

    @GetMapping(path = ENDPOINT_STATUS)
    public List<Status> getStatus() {
        final var status = statusService.getAllStatus();
        logger.info("N.of Status: {}", status.size());
        return status;
    }

    @GetMapping(path = ENDPOINT_TRADE_TYPE)
    public List<TradeType> getTradesType() {
        final var tradesTypes = tradeTypeService.getAllTradeTypes();
        logger.info("N.of TradesTypes: {}", tradesTypes.size());
        return tradesTypes;
    }
}
