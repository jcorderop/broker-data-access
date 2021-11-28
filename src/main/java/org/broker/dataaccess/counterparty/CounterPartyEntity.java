package org.broker.dataaccess.counterparty;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@SQLDelete(sql = "UPDATE CounterParty SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "CounterParty")
@Table(
        name = "counter_party",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_counter_party_alias_unique",
                        columnNames = "alias"
                ), @UniqueConstraint(
                name = "counter_party_email_unique",
                columnNames = "email"
        )
        }
)
public class CounterPartyEntity {

    public static final String SEQUENCE_NAME = "counter_party_sequence";

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
    @ManyToOne(
            optional = false
    )
    @JoinColumn(
            name = "counter_party_type_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_crty_party__crty_party_type_id_with_crty_party_type_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CounterPartyTypeEntity counterPartyType;

    @NonNull
    @Column(
            nullable = false
    )
    private String alias;

    //------------------------------------------------------------
    @NonNull
    @Column(
            nullable = false
    )
    private Boolean individual;

    // if no individual
    @Column(
            name = "corporate_name"
    )
    private String corporateName;

    // if individual
    //TODO Join with users
    @Column(
            name = "first_name"
    )
    private String fistName;

    @Column(
            name = "last_name"
    )
    private String lastName;

    //------------------------------------------------------------

    @Column
    private String address;

    @Column
    private String telephone;

    @NonNull
    @Column(
            nullable = false
    )
    private String email;

    //------------------------------------------------------------
    @OneToMany(
            mappedBy = "broker",
            cascade = {
                    CascadeType.PERSIST
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<OrderEntity> orderEntities = new ArrayList<>();

    @OneToMany(
            mappedBy = "counterParty",
            cascade = {
                    CascadeType.PERSIST
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TradeEntity> tradesCounterParty = new ArrayList<>();

    @OneToMany(
            mappedBy = "broker",
            cascade = {
                    CascadeType.PERSIST
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TradeEntity> tradesBroker = new ArrayList<>();
}
