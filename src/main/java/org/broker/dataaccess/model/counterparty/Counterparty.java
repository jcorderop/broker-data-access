package org.broker.dataaccess.model.counterparty;

public record Counterparty(Long id,
                           String alias,
                           String email,
                           Boolean individual,
                           String corporateName,
                           String fistName,
                           String lastName,
                           String telephone,
                           String address) {
}

