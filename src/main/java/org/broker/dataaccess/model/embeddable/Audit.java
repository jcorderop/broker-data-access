package org.broker.dataaccess.model.embeddable;

import lombok.*;
import org.broker.dataaccess.database.config.SingletonUserBeanConfig;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

@Configuration
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Embeddable
public class Audit implements Serializable {

    @NonNull
    @Column(
            nullable = false
    )
    private Boolean deleted = false;

    @NonNull
    @Column(
            name = "created_time",
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdTime;

    @NonNull
    @Column(
            name = "created_user",
            nullable = false,
            updatable = false
    )
    private Long createdUser;

    @NonNull
    @Column(
            name = "updated_time",
            nullable = false
    )
    private LocalDateTime updatedTime;

    @NonNull
    @Column(
            name = "updated_user",
            nullable = false
    )
    private Long updatedUser;

    @PrePersist
    public void prePersist() {
        updatedTime = createdTime = LocalDateTime.now();
        updatedUser = createdUser = SingletonUserBeanConfig.singletonServiceBean().getSystemUser();
    }

    @PreUpdate
    public void preUpdate() {
        updatedTime = LocalDateTime.now();
        updatedUser = SingletonUserBeanConfig.singletonServiceBean().getUserLogged();
    }
}
