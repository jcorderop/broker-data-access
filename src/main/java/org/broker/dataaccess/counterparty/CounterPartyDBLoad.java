package org.broker.dataaccess.counterparty;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Order(value = 3)
@Component
public class CounterPartyDBLoad implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(CounterPartyDBLoad.class);

    @Autowired
    private CounterPartyService counterPartyService;

    @Autowired
    private CounterPartyTypeService counterPartyTypeService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Configuration...");
        Faker faker = new Faker();
        createBrokers(faker);
        createClients(faker);
    }

    private void createBrokers(Faker faker) {
        CounterPartyTypeEntity cpBroker = counterPartyTypeService.getCounterpartyBroker();
        createBroker(faker, cpBroker, "binance");
        createBroker(faker, cpBroker, "bitmex");
    }

    private void createBroker(Faker faker,
                              CounterPartyTypeEntity cpBroker,
                              String name) {
        final CounterPartyEntity binance = new CounterPartyEntity(cpBroker,
                name,
                false,
                "support@" + name + ".com");
        binance.setCorporateName(name + " Company");
        binance.setAddress(faker.address().fullAddress());
        binance.setTelephone(faker.phoneNumber().phoneNumber());
        counterPartyService.bulkUpset(List.of(binance));
    }

    private void createClients(Faker faker) {
        CounterPartyTypeEntity cpClient = counterPartyTypeService.getCounterpartyClient();
        createClient(faker, cpClient);
    }

    private void createClient(Faker faker, CounterPartyTypeEntity cpClient) {
        final List<CounterPartyEntity> counterParties = IntStream.range(0, 20).mapToObj(value -> {
            final CounterPartyEntity client = new CounterPartyEntity(cpClient,
                    faker.superhero().name(),
                    true,
                    faker.internet().emailAddress());
            client.setFistName(faker.name().firstName());
            client.setLastName(faker.name().lastName());
            client.setAddress(faker.address().fullAddress());
            client.setTelephone(faker.phoneNumber().phoneNumber());
            return client;
        }).collect(Collectors.toList());

        counterPartyService.bulkUpset(counterParties);
    }
}
