package org.broker.dataaccess.model.instrument;

public record Instrument(Long id,
                         String name,
                         String baseCurrency,
                         String quotedCurrency,
                         String freeTest,
                         String externalId1,
                         String externalId2) {
}