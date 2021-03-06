package org.broker.dataaccess.model.user;

import lombok.*;
import org.broker.dataaccess.model.common.JPATools;
import org.broker.dataaccess.model.embeddable.Audit;
import org.broker.dataaccess.model.embeddable.CommonInputData;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE UserPermission SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "UserPermission")
@Table(name = "user_permissions")
public class UserPermissionEntity {
    // TODO
    public static final String SEQUENCE_NAME = "user_permission_sequence";

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
