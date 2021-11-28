package org.broker.dataaccess.user;

import lombok.*;
import org.broker.dataaccess.common.JPATools;
import org.broker.dataaccess.embeddable.Audit;
import org.broker.dataaccess.embeddable.CommonInputData;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE UserRole SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "UserRole")
@Table(name = "user_roles")
public class UserRoleEntity {

    public static final String SEQUENCE_NAME = "user_role_sequence";

    @Id
    @SequenceGenerator(
            name = SEQUENCE_NAME,
            sequenceName = SEQUENCE_NAME,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = SEQUENCE_NAME
    )
    @Column(
            name = JPATools.PK_NAME,
            updatable = false
    )
    private Long id;

    @NonNull
    @Embedded
    private Audit audit;

    @Embedded
    private CommonInputData commonInputData;
}
