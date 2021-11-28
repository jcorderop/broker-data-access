package org.broker.dataaccess.user;

import lombok.*;
import org.broker.dataaccess.common.JPATools;
import org.broker.dataaccess.embeddable.Audit;
import org.broker.dataaccess.order.OrderEntity;
import org.broker.dataaccess.trade.TradeEntity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE User SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "User")
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_user_alias_unique",
                        columnNames = "alias"
                )
        }
)
public class UserEntity {

    public static final String SEQUENCE_NAME = "user_sequence";

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

    @Embedded
    private Audit audit = new Audit();

    @NonNull
    @Column(
            nullable = false
    )
    private String alias;

    @NonNull
    @Column(
            name = "first_name",
            nullable = false
    )
    private String fistName;

    @NonNull
    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @NonNull
    @Column
    private String email;

    @OneToMany(
            mappedBy = "trader",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<OrderEntity> orderEntities = new ArrayList<>();

    @OneToMany(
            mappedBy = "trader",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<TradeEntity> tradeEntities = new ArrayList<>();
}
