package org.broker.dataaccess.counterparty;

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

