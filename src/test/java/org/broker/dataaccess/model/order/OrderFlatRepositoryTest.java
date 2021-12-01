package org.broker.dataaccess.model.order;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.broker.dataaccess.model.counterparty.Counterparty;
import org.broker.dataaccess.model.counterparty.CounterpartyType;
import org.broker.dataaccess.model.instrument.Instrument;
import org.broker.dataaccess.model.instrument.InstrumentType;
import org.broker.dataaccess.model.portfolio.Portfolio;
import org.broker.dataaccess.model.status.Status;
import org.broker.dataaccess.model.trade.TradeType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.broker.dataaccess.controller.DataAccessEndPoints.*;

@SpringBootTest
@ActiveProfiles("test")
class OrderFlatRepositoryTest {

    ImmutableMap<String, Long> counterparty;
    ImmutableMap<String, Long> counterpartyType;
    ImmutableMap<String, Long> instrument;
    ImmutableMap<String, Long> instrumentType;
    ImmutableMap<String, Long> orderType;
    ImmutableMap<String, Long> portfolio;
    ImmutableMap<String, Long> status;
    ImmutableMap<String, Long> tradeType;
    ImmutableList<String> currency;

    @Value("${server.port}")
    private int port;
    private String host = "http://localhost:";

    @BeforeEach
    void setUp() {
        host += port + "/" + API_NAME;
        loadCache();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create_new_order() {
        //given
        System.out.println("----");
        instrument.entrySet().stream().forEach(System.out::println);
        System.out.println("----");
        status.entrySet().stream().forEach(System.out::println);
        System.out.println("----");
        orderType.entrySet().stream().forEach(System.out::println);
        System.out.println("----");
        counterparty.entrySet().stream().forEach(System.out::println);
        //user
        /*
        OrderFlatEntity order = new OrderFlatEntity();
        order.setCurrencyId("BTC");
        order.setExternalRef("100001");
        order.setInstrumentId("BTCUSD");
        order.setStatusId("New");
        order.setTraderId("User");
        order.setOrderTypeId("Market");
        order.setPrice(56800.0);
        order.setQuantity(0.2);
        order.setBrokerId("BINANCE");*/

        //when

        //then
    }

    @Test
    void create_cancel_an_order() {
        //given


        //when

        //then
    }

    @Test
    void create_full_fill_an_order() {
        //given

        //when

        //then
    }

    void loadCache() {
        RestTemplate restTemplate = new RestTemplate();

        counterparty = ImmutableMap.copyOf(Arrays.stream(restTemplate.getForObject(host + ENDPOINT_COUNTERPARTYS, Counterparty[].class))
                .collect(Collectors
                        .toMap(Counterparty::alias, Counterparty::id))
        );
        counterpartyType = ImmutableMap.copyOf(Arrays.stream(restTemplate.getForObject(host + ENDPOINT_COUNTERPARTIESTYPE, CounterpartyType[].class))
                .collect(Collectors
                        .toMap(CounterpartyType::name, CounterpartyType::id))
        );
        instrument = ImmutableMap.copyOf(Arrays.stream(restTemplate.getForObject(host + ENDPOINT_INSTRUMENTS, Instrument[].class))
                .collect(Collectors
                        .toMap(Instrument::name, Instrument::id))
        );
        instrumentType = ImmutableMap.copyOf(Arrays.stream(restTemplate.getForObject(host + ENDPOINT_INSTRUMENTS_TYPE, InstrumentType[].class))
                .collect(Collectors
                        .toMap(InstrumentType::name, InstrumentType::id))
        );
        orderType = ImmutableMap.copyOf(Arrays.stream(restTemplate.getForObject(host + ENDPOINT_ORDERSTYPE, OrderType[].class))
                .collect(Collectors
                        .toMap(OrderType::name, OrderType::id))
        );
        portfolio = ImmutableMap.copyOf(Arrays.stream(restTemplate.getForObject(host + ENDPOINT_PORTFOLIOS, Portfolio[].class))
                .collect(Collectors
                        .toMap(Portfolio::name, Portfolio::id))
        );
        status = ImmutableMap.copyOf(Arrays.stream(restTemplate.getForObject(host + ENDPOINT_STATUS, Status[].class))
                .collect(Collectors
                        .toMap(Status::name, Status::id))
        );
        tradeType = ImmutableMap.copyOf(Arrays.stream(restTemplate.getForObject(host + ENDPOINT_TRADE_TYPE, TradeType[].class))
                .collect(Collectors
                        .toMap(TradeType::name, TradeType::id))
        );
        currency = ImmutableList.copyOf(restTemplate.getForObject(host + ENDPOINT_CURRENCIES, String[].class));
    }
}