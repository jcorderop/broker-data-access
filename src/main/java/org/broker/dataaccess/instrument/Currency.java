package org.broker.dataaccess.instrument;

public record Currency(Integer id,
                       String name,
                       String description,
                       String baseCurrency,
                       String quotedCurrency,
                       String freeTest,
                       String externalId1,
                       String externalId2) {
}