package org.broker.dataaccess.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 1)
@Component
public class UserDBLoad implements CommandLineRunner {

    public static final String DEFAULT_USER_SYSTEM = "system";
    private static Logger logger = LoggerFactory.getLogger(UserDBLoad.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Configuration...");

        final UserEntity system = new UserEntity(DEFAULT_USER_SYSTEM,
                DEFAULT_USER_SYSTEM,
                DEFAULT_USER_SYSTEM,
                DEFAULT_USER_SYSTEM + "@company.com");
        userRepository.save(system);
    }
}
