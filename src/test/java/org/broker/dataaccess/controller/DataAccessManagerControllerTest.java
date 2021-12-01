package org.broker.dataaccess.controller;

import org.broker.dataaccess.model.counterparty.Counterparty;
import org.broker.dataaccess.model.counterparty.CounterpartyType;
import org.broker.dataaccess.model.instrument.Instrument;
import org.broker.dataaccess.model.instrument.InstrumentType;
import org.broker.dataaccess.model.order.OrderType;
import org.broker.dataaccess.model.portfolio.Portfolio;
import org.broker.dataaccess.model.status.Status;
import org.broker.dataaccess.model.trade.TradeType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.broker.dataaccess.controller.DataAccessEndPoints.*;

@SpringBootTest
@ComponentScan(
        basePackages = {
                "org.broker.dataaccess"
        }
)
@ActiveProfiles("test")
class DataAccessManagerControllerTest {

    private static Logger logger = LoggerFactory.getLogger(DataAccessManagerControllerTest.class);

    @Value("${server.port}")
    private int port;
    private String host = "http://localhost:";

    @BeforeEach
    void setUp() {
        host += port + "/" + API_NAME;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCounterparties() {
        //given
        String uri = host + ENDPOINT_COUNTERPARTYS;
        RestTemplate restTemplate = new RestTemplate();

        //when
        var result = restTemplate.getForObject(uri, Counterparty[].class);

        //then
        assertThat(result).isNotNull();
        assertThat(result.length).isGreaterThan(0);
        Arrays.stream(result).forEach(e -> logger.info(String.valueOf(e)));
    }

    @Test
    void getCounterpartiesType() {
        //given
        String uri = host + ENDPOINT_COUNTERPARTIESTYPE;
        RestTemplate restTemplate = new RestTemplate();

        //when
        var result = restTemplate.getForObject(uri, CounterpartyType[].class);

        //then
        assertThat(result).isNotNull();
        assertThat(result.length).isGreaterThan(0);
        Arrays.stream(result).forEach(e -> logger.info(String.valueOf(e)));
    }

    @Test
    void getInstruments() {
        //given
        String uri = host + ENDPOINT_INSTRUMENTS;
        RestTemplate restTemplate = new RestTemplate();

        //when
        var result = restTemplate.getForObject(uri, Instrument[].class);

        //then
        assertThat(result).isNotNull();
        assertThat(result.length).isGreaterThan(0);
        Arrays.stream(result).forEach(e -> logger.info(String.valueOf(e)));
    }

    @Test
    void getInstrumentsType() {
        //given
        String uri = host + ENDPOINT_INSTRUMENTS_TYPE;
        RestTemplate restTemplate = new RestTemplate();

        //when
        var result = restTemplate.getForObject(uri, InstrumentType[].class);

        //then
        assertThat(result).isNotNull();
        assertThat(result.length).isGreaterThan(0);
        Arrays.stream(result).forEach(e -> logger.info(String.valueOf(e)));
    }

    @Test
    void getCurrenciesType() {
        //given
        String uri = host + ENDPOINT_CURRENCIES;
        RestTemplate restTemplate = new RestTemplate();

        //when
        var result = restTemplate.getForObject(uri, String[].class);

        //then
        assertThat(result).isNotNull();
        assertThat(result.length).isGreaterThan(0);
        Arrays.stream(result).forEach(e -> logger.info(String.valueOf(e)));
    }

    @Test
    void getOrdersType() {
        //given
        String uri = host + ENDPOINT_ORDERSTYPE;
        RestTemplate restTemplate = new RestTemplate();

        //when
        var result = restTemplate.getForObject(uri, OrderType[].class);

        //then
        assertThat(result).isNotNull();
        assertThat(result.length).isGreaterThan(0);
        Arrays.stream(result).forEach(e -> logger.info(String.valueOf(e)));
    }

    @Test
    void getPortfolios() {
        //given
        String uri = host + ENDPOINT_PORTFOLIOS;
        RestTemplate restTemplate = new RestTemplate();

        //when
        var result = restTemplate.getForObject(uri, Portfolio[].class);

        //then
        assertThat(result).isNotNull();
        assertThat(result.length).isGreaterThan(0);
        Arrays.stream(result).forEach(e -> logger.info(String.valueOf(e)));
    }

    @Test
    void getStatus() {
        //given
        String uri = host + ENDPOINT_STATUS;
        RestTemplate restTemplate = new RestTemplate();

        //when
        var result = restTemplate.getForObject(uri, Status[].class);

        //then
        assertThat(result).isNotNull();
        assertThat(result.length).isGreaterThan(0);
        Arrays.stream(result).forEach(e -> logger.info(String.valueOf(e)));
    }

    @Test
    void getTradesType() {
        //given
        String uri = host + ENDPOINT_TRADE_TYPE;
        RestTemplate restTemplate = new RestTemplate();

        //when
        var result = restTemplate.getForObject(uri, TradeType[].class);

        //then
        assertThat(result).isNotNull();
        assertThat(result.length).isGreaterThan(0);
        Arrays.stream(result).forEach(e -> logger.info(String.valueOf(e)));
    }
}