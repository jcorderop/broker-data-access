package org.broker.dataaccess.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long getSystemUser() {
        if (userRepository.count() == 0) {
            return 1L;
        } else {
            return userRepository.findUserByAlias(UserDBLoad.DEFAULT_USER_SYSTEM)
                    .orElseThrow(() -> new IllegalStateException("System user not found."))
                    .getId();
        }
    }

    public Long getUserLogged() {
        return getSystemUser();
    }
}
