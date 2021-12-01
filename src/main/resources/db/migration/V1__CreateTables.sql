create table counter_party_type
(
    id           bigint       not null
        constraint counter_party_type_pkey
            primary key,
    created_time timestamp    not null,
    created_user bigint       not null,
    deleted      boolean      not null,
    updated_time timestamp    not null,
    updated_user bigint       not null,
    description  varchar(255) not null,
    name         varchar(255) not null
        constraint uk_qj7nvpkuqt0bggtsbeqosky3r
            unique
);

alter table counter_party_type
    owner to postgres;

create table counter_party
(
    id                    bigint       not null
        constraint counter_party_pkey
            primary key,
    address               varchar(255),
    alias                 varchar(255) not null
        constraint uk_counter_party_alias_unique
            unique,
    created_time          timestamp    not null,
    created_user          bigint       not null,
    deleted               boolean      not null,
    updated_time          timestamp    not null,
    updated_user          bigint       not null,
    corporate_name        varchar(255),
    email                 varchar(255) not null
        constraint counter_party_email_unique
            unique,
    first_name            varchar(255),
    individual            boolean      not null,
    last_name             varchar(255),
    telephone             varchar(255),
    counter_party_type_id bigint       not null
        constraint fk_crty_party__crty_party_type_id_with_crty_party_type_ref_id
            references counter_party_type
);

alter table counter_party
    owner to postgres;

create table instruments_type
(
    id           bigint       not null
        constraint instruments_type_pkey
            primary key,
    created_time timestamp    not null,
    created_user bigint       not null,
    deleted      boolean      not null,
    updated_time timestamp    not null,
    updated_user bigint       not null,
    description  varchar(255) not null,
    name         varchar(255) not null
        constraint uk_nquw26suktehgdomiwemih2ch
            unique
);

alter table instruments_type
    owner to postgres;

create table instruments
(
    id                 bigint       not null
        constraint instruments_pkey
            primary key,
    created_time       timestamp    not null,
    created_user       bigint       not null,
    deleted            boolean      not null,
    updated_time       timestamp    not null,
    updated_user       bigint       not null,
    base_currency      varchar(5)   not null,
    exteranl_id1       varchar(255),
    exteranl_id2       varchar(255),
    free_text          varchar(255),
    name               varchar(255) not null
        constraint uk_instrument_name_unique
            unique,
    quoted_currency    varchar(5),
    instrument_type_id bigint       not null
        constraint fk_instrument__instrument_id_with_instrument_type_ref_id
            references instruments_type
);

alter table instruments
    owner to postgres;

create table orders_type
(
    id           bigint       not null
        constraint orders_type_pkey
            primary key,
    created_time timestamp    not null,
    created_user bigint       not null,
    deleted      boolean      not null,
    updated_time timestamp    not null,
    updated_user bigint       not null,
    description  varchar(255) not null,
    name         varchar(255) not null
        constraint uk_chhdrp8jh9q1d4p8jswwpkgsg
            unique
);

alter table orders_type
    owner to postgres;

create table portfolios
(
    id           bigint       not null
        constraint portfolios_pkey
            primary key,
    created_time timestamp    not null,
    created_user bigint       not null,
    deleted      boolean      not null,
    updated_time timestamp    not null,
    updated_user bigint       not null,
    description  varchar(255) not null,
    name         varchar(255) not null
        constraint uk_ecphwf71dv3fipe9up2fpj30q
            unique
);

alter table portfolios
    owner to postgres;

create table status
(
    id           bigint       not null
        constraint status_pkey
            primary key,
    created_time timestamp    not null,
    created_user bigint       not null,
    deleted      boolean      not null,
    updated_time timestamp    not null,
    updated_user bigint       not null,
    description  varchar(255) not null,
    name         varchar(255) not null
        constraint uk_reccgx9nr0a8dwv201t44l6pd
            unique
);

alter table status
    owner to postgres;

create table trade_type
(
    id           bigint       not null
        constraint trade_type_pkey
            primary key,
    created_time timestamp    not null,
    created_user bigint       not null,
    deleted      boolean      not null,
    updated_time timestamp    not null,
    updated_user bigint       not null,
    description  varchar(255) not null,
    name         varchar(255) not null
        constraint uk_heut0ggjatw344ub1jdd43fg3
            unique
);

alter table trade_type
    owner to postgres;

create table user_permissions
(
    id           bigint       not null
        constraint user_permissions_pkey
            primary key,
    created_time timestamp    not null,
    created_user bigint       not null,
    deleted      boolean      not null,
    updated_time timestamp    not null,
    updated_user bigint       not null,
    description  varchar(255) not null,
    name         varchar(255) not null
        constraint uk_37rs1t064fvu26lg5hfjvxkmj
            unique
);

alter table user_permissions
    owner to postgres;

create table user_roles
(
    id           bigint       not null
        constraint user_roles_pkey
            primary key,
    created_time timestamp    not null,
    created_user bigint       not null,
    deleted      boolean      not null,
    updated_time timestamp    not null,
    updated_user bigint       not null,
    description  varchar(255) not null,
    name         varchar(255) not null
        constraint uk_182xa1gitcxqhaq6nn3n2kmo3
            unique
);

alter table user_roles
    owner to postgres;

create table users
(
    id           bigint       not null
        constraint users_pkey
            primary key,
    alias        varchar(255) not null
        constraint uk_user_alias_unique
            unique,
    created_time timestamp    not null,
    created_user bigint       not null,
    deleted      boolean      not null,
    updated_time timestamp    not null,
    updated_user bigint       not null,
    email        varchar(255),
    first_name   varchar(255) not null,
    last_name    varchar(255) not null
);

alter table users
    owner to postgres;

create table orders
(
    id              bigint       not null
        constraint orders_pkey
            primary key,
    created_time    timestamp    not null,
    created_user    bigint       not null,
    deleted         boolean      not null,
    updated_time    timestamp    not null,
    updated_user    bigint       not null,
    external_ref    varchar(255) not null,
    order_date_time timestamp,
    price           double precision,
    quantity        double precision,
    broker_id       bigint
        constraint fk_order__counter_party_id_with_counter_party_ref_id
            references counter_party,
    currency_id     bigint       not null
        constraint fk_order__currency_id_with_instrument_ref_id
            references instruments,
    instrument_id   bigint       not null
        constraint fk_order__instrument_id_with_instrument_ref_id
            references instruments,
    order_type_id   bigint       not null
        constraint fk_order__order_type_id_with_order_type_ref_id
            references orders_type,
    status_id       bigint       not null
        constraint fk_order__status_id_with_status_ref_id
            references status,
    trader_id       bigint       not null
        constraint fk_order__trader_id_with_user_ref_id
            references users
);

alter table orders
    owner to postgres;

create table trades
(
    id                  bigint    not null
        constraint trades_pkey
            primary key,
    acquired_date_time  timestamp,
    created_time        timestamp not null,
    created_user        bigint    not null,
    deleted             boolean   not null,
    updated_time        timestamp not null,
    updated_user        bigint    not null,
    broker_fees         double precision,
    execution_date_time timestamp,
    trade_date_time     timestamp,
    value_date_time     timestamp,
    broker_id           bigint
        constraint fk_trade__broker_id_with_counter_party_ref_id
            references counter_party,
    counter_party_id    bigint    not null
        constraint fk_trade__counter_party_id_with_counter_party_ref_id
            references counter_party,
    ctpy_portfolio_id   bigint    not null
        constraint fk_trade__ctpy_portfolio_id_with_portfolio_ref_id
            references portfolios,
    currency_id         bigint    not null
        constraint fk_tarde__currency_id_with_instrument_ref_id
            references instruments,
    instrument_id       bigint    not null
        constraint fk_trade__instrument_id_with_instrument_ref_id
            references instruments,
    order_id            bigint
        constraint fk_trade__order_id_with_order_ref_id
            references orders,
    portfolio_id        bigint    not null
        constraint fk_trade__portfolio_id_with_portfolio_ref_id
            references portfolios,
    status_id           bigint    not null
        constraint fk_trade__status_id_with_status_ref_id
            references status,
    trade_type_id       bigint    not null
        constraint fk_trade__trade_type_id_with_trade_type_ref_id
            references trade_type,
    trader_id           bigint    not null
        constraint fk_trade__trader_id_with_user_ref_id
            references users
);

alter table trades
    owner to postgres;

