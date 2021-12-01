insert into users (id, alias, created_time, created_user, deleted, updated_time, updated_user, email, first_name,
                   last_name)
values (1, 'system', '2021-11-30 23:27:39.443316', 1, false, '2021-11-30 23:27:39.443316', 1, 'system@company.com',
        'system', 'system');

insert into counter_party_type (id, created_time, created_user, deleted, updated_time, updated_user, description,
                                name)
values (1, '2021-11-30 23:27:39.512978', 1, false, '2021-11-30 23:27:39.512978', 1, 'Client counterparty type',
        'Client'),
       (2, '2021-11-30 23:27:39.561638', 1, false, '2021-11-30 23:27:39.561638', 1, 'Broker counterparty type',
        'Broker');

insert into instruments_type (id, created_time, created_user, deleted, updated_time, updated_user, description,
                              name)
values (1, '2021-11-30 23:27:39.584363', 1, false, '2021-11-30 23:27:39.584363', 1, 'Instrument FXSpot', 'FXSpot');

insert into orders_type (id, created_time, created_user, deleted, updated_time, updated_user, description, name)
values (1, '2021-11-30 23:27:39.604317', 1, false, '2021-11-30 23:27:39.604317', 1, 'Market order type', 'Market'),
       (2, '2021-11-30 23:27:39.615455', 1, false, '2021-11-30 23:27:39.615455', 1, 'Limit order type', 'Limit');

insert into trade_type (id, created_time, created_user, deleted, updated_time, updated_user, description, name)
values (1, '2021-11-30 23:27:39.734542', 1, false, '2021-11-30 23:27:39.734542', 1, 'Normal Trade type', 'Normal'),
       (2, '2021-11-30 23:27:39.745542', 1, false, '2021-11-30 23:27:39.745542', 1, 'Exercise Trade type', 'Exercise');

insert into status (id, created_time, created_user, deleted, updated_time, updated_user, description, name)
values (1, '2021-11-30 23:27:39.669982', 1, false, '2021-11-30 23:27:39.669982', 1, 'Deal Cancelled', 'Cancelled'),
       (2, '2021-11-30 23:27:39.681205', 1, false, '2021-11-30 23:27:39.681205', 1, 'Trading accepts the deal',
        'FO-Confirmed'),
       (3, '2021-11-30 23:27:39.692575', 1, false, '2021-11-30 23:27:39.692575', 1, 'Deal in progress and monitored',
        'MO-Confirmed'),
       (4, '2021-11-30 23:27:39.704061', 1, false, '2021-11-30 23:27:39.704061', 1,
        'Deal completed and in progress to settle', 'BO-Confirmed');

insert into portfolios (id, created_time, created_user, deleted, updated_time, updated_user, description, name)
values (1, '2021-11-30 23:27:39.638242', 1, false, '2021-11-30 23:27:39.638242', 1, 'Trading desk 1', '100100'),
       (2, '2021-11-30 23:27:39.648370', 1, false, '2021-11-30 23:27:39.648370', 1, 'Client portfolio', '200100');

insert into counter_party (id, address, alias, created_time, created_user, deleted, updated_time, updated_user,
                           corporate_name, email, first_name, individual, last_name, telephone,
                           counter_party_type_id)
values (1, '6328 Eugene Dale, Yuonnefurt, CO 17558', 'binance', '2021-11-30 23:27:39.851757', 1, false,
        '2021-11-30 23:27:39.851757', 1, 'binance Company', 'support@binance.com', null, false, null,
        '1-033-863-9623 x960', 2),
       (2, '986 Norbert Street, Senahaven, NY 64203', 'bitmex', '2021-11-30 23:27:39.869686', 1, false,
        '2021-11-30 23:27:39.869686', 1, 'bitmex Company', 'support@bitmex.com', null, false, null, '981-487-4754', 2),
       (3, '251 Nicolas Curve, Medhurstland, WV 37486-1756', 'Cyborg Doppelganger', '2021-11-30 23:27:39.948413', 1,
        false, '2021-11-30 23:27:39.948413', 1, null, 'kaci.rath@gmail.com', 'Margareta', true, 'Lindgren',
        '(431) 323-2739 x2616', 1),
       (4, '239 DuBuque Lock, New Tinishahaven, IL 08434', 'Colossus Strike', '2021-11-30 23:27:39.955806', 1, false,
        '2021-11-30 23:27:39.955806', 1, null, 'marcelene.hane@hotmail.com', 'Jinny', true, 'Effertz', '293-650-4647',
        1),
       (5, 'Suite 312 8739 Herman Parks, Rodneyberg, NE 65271', 'Archangel Boy', '2021-11-30 23:27:39.966553', 1, false,
        '2021-11-30 23:27:39.966553', 1, null, 'joel.olson@gmail.com', 'Freddie', true, 'Cummerata',
        '876.272.9218 x309', 1),
       (6, '8668 Bradtke Cove, Lianneside, NC 00342-3456', 'Captain Hyperion', '2021-11-30 23:27:39.981105', 1, false,
        '2021-11-30 23:27:39.981105', 1, null, 'joel.bernhard@gmail.com', 'Camie', true, 'Beer', '1-916-584-7147 x1343',
        1),
       (7, 'Suite 824 597 Marcos Avenue, Schmittfort, GA 95969', 'Illustrious Azrael', '2021-11-30 23:27:39.998573', 1,
        false, '2021-11-30 23:27:39.998573', 1, null, 'mila.gleason@hotmail.com', 'Tula', true, 'Koss',
        '1-733-085-0082 x62175', 1),
       (8, '3965 Michaele Vista, Eldonfurt, NC 89399-0154', 'Sasquatch', '2021-11-30 23:27:40.011810', 1, false,
        '2021-11-30 23:27:40.011810', 1, null, 'alisia.shanahan@gmail.com', 'Bryan', true, 'Daniel', '1-292-784-6371',
        1),
       (9, '7936 Okuneva Greens, North Desmond, MN 36331-1501', 'Dark Faora Machine', '2021-11-30 23:27:40.021963', 1,
        false, '2021-11-30 23:27:40.021963', 1, null, 'arie.hamill@hotmail.com', 'Mike', true, 'Blick', '688-688-4514',
        1),
       (10, 'Apt. 478 9996 McCullough Trafficway, Eldenton, IN 59188', 'Doctor Tinkerer of Hearts',
        '2021-11-30 23:27:40.030929', 1, false, '2021-11-30 23:27:40.030929', 1, null, 'emory.hagenes@gmail.com',
        'Antione', true, 'Robel', '1-207-762-9908', 1),
       (11, 'Suite 754 4858 Jeneva Grove, Port Jame, MO 25780', 'Shang-Chi', '2021-11-30 23:27:40.039447', 1, false,
        '2021-11-30 23:27:40.039447', 1, null, 'shon.green@gmail.com', 'Alena', true, 'Hand', '781.603.1225 x0257', 1),
       (12, 'Suite 126 85600 Dean Ramp, Okunevamouth, SC 54971', 'Ink', '2021-11-30 23:27:40.047474', 1, false,
        '2021-11-30 23:27:40.047474', 1, null, 'julia.schimmel@gmail.com', 'Sanjuanita', true, 'Terry',
        '(872) 210-5782', 1),
       (13, 'Suite 966 2607 Reynolds Corner, Leuschketon, KS 79126', 'Groot Ivy', '2021-11-30 23:27:40.056039', 1,
        false, '2021-11-30 23:27:40.056039', 1, null, 'rick.fay@gmail.com', 'Monte', true, 'Kertzmann',
        '1-840-515-8401', 1),
       (14, 'Apt. 934 4191 Abernathy Mountain, West Kerstin, DE 30092-6685', 'Jack-Jack', '2021-11-30 23:27:40.062934',
        1, false, '2021-11-30 23:27:40.062934', 1, null, 'felton.blanda@hotmail.com', 'Arron', true, 'Wisozk',
        '(338) 584-2206 x012', 1),
       (15, '93203 Mana Pines, South August, AL 94616', 'Angel', '2021-11-30 23:27:40.071742', 1, false,
        '2021-11-30 23:27:40.071742', 1, null, 'tommye.ritchie@yahoo.com', 'Rosendo', true, 'Brekke', '(529) 207-8281',
        1),
       (16, 'Apt. 583 760 Evelin Pines, Shanitown, ND 50353-0001', 'Mr Leech Boy', '2021-11-30 23:27:40.078631', 1,
        false, '2021-11-30 23:27:40.078631', 1, null, 'delia.tremblay@hotmail.com', 'Josefina', true, 'Medhurst',
        '086-822-9456', 1),
       (17, 'Suite 329 788 Quincy Pass, Gleichnerchester, TX 43134-6450', 'Deathlok Lord', '2021-11-30 23:27:40.086658',
        1, false, '2021-11-30 23:27:40.086658', 1, null, 'emerson.bartell@hotmail.com', 'Shanika', true, 'Kozey',
        '006-495-7946 x917', 1),
       (18, '587 Micheal Corners, Ellanberg, SD 49803-0802', 'Illustrious Titan Fist', '2021-11-30 23:27:40.094091', 1,
        false, '2021-11-30 23:27:40.094091', 1, null, 'josef.senger@yahoo.com', 'Victor', true, 'Gleichner',
        '041.395.3885 x9422', 1),
       (19, 'Apt. 036 07773 Cronin Circle, Lake Everettestad, DE 41007-2139', 'Spectre Fist',
        '2021-11-30 23:27:40.102777', 1, false, '2021-11-30 23:27:40.102777', 1, null, 'bessie.stamm@hotmail.com',
        'Tim', true, 'Nikolaus', '(859) 674-5736 x496', 1),
       (20, 'Suite 509 97742 Kris Place, North Katherina, IL 26118', 'Zatanna Brain', '2021-11-30 23:27:40.110197', 1,
        false, '2021-11-30 23:27:40.110197', 1, null, 'moises.reinger@gmail.com', 'Lawrence', true, 'Metz',
        '(343) 116-0931', 1),
       (21, '060 Steve Field, Paucekport, VA 74462', 'Walrus Claw', '2021-11-30 23:27:40.117714', 1, false,
        '2021-11-30 23:27:40.117714', 1, null, 'romana.lynch@gmail.com', 'Cordell', true, 'Aufderhar',
        '(700) 382-8893 x5337', 1),
       (22, 'Apt. 398 5532 Dot Freeway, East Louettaview, AL 08318', 'Supah Zatanna', '2021-11-30 23:27:40.125783', 1,
        false, '2021-11-30 23:27:40.125783', 1, null, 'joaquin.koch@hotmail.com', 'Corene', true, 'Lindgren',
        '688-389-0043 x974', 1);

insert into instruments (id, created_time, created_user, deleted, updated_time, updated_user, base_currency,
                         exteranl_id1, exteranl_id2, free_text, name, quoted_currency, instrument_type_id)
values (1, '2021-11-30 23:27:40.169165', 1, false, '2021-11-30 23:27:40.169165', 1, 'BTC', null, null, null, 'BTCUSD',
        'USD', 1),
       (2, '2021-11-30 23:27:40.177249', 1, false, '2021-11-30 23:27:40.177249', 1, 'SOL', null, null, null, 'SOLUSD',
        'USD', 1),
       (3, '2021-11-30 23:27:40.186409', 1, false, '2021-11-30 23:27:40.186409', 1, 'ETH', null, null, null, 'ETHUSD',
        'USD', 1),
       (4, '2021-11-30 23:27:40.195121', 1, false, '2021-11-30 23:27:40.195121', 1, 'ADA', null, null, null, 'ADAUSD',
        'USD', 1),
       (5, '2021-11-30 23:27:40.204177', 1, false, '2021-11-30 23:27:40.204177', 1, 'XRP', null, null, null, 'XRPUSD',
        'USD', 1);



