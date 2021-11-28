package org.broker.dataaccess.instrument;

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
@SQLDelete(sql = "UPDATE Instrument SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "Instrument")
@Table(
        name = "instruments",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_instrument_name_unique",
                        columnNames = "name"
                )
        }
)
public class InstrumentEntity {

    public static final String SEQUENCE_NAME = "instrument_sequence";

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
    private String name;

    @Column(
            name = "exteranl_id1"
    )
    private String externalId1;

    @Column(
            name = "exteranl_id2"
    )
    private String externalId2;

    @Column(
            name = "free_text"
    )
    private String freeTest;

    @NonNull
    @Column(
            name = "base_currency",
            nullable = false,
            length = 5
    )
    private String baseCurrency;

    @NonNull
    @Column(
            name = "quoted_currency",
            length = 5
    )
    private String quotedCurrency;

    @NonNull
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "instrument_type_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_instrument__instrument_id_with_instrument_type_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private InstrumentTypeEntity instrumentTypeEntity;

    //------------------------------------------------------------
    @OneToMany(
            mappedBy = "instrumentEntity",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY,
            orphanRemoval = true // TODO
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<OrderEntity> ordersInstrument = new ArrayList<>();

    @OneToMany(
            mappedBy = "currency",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY,
            orphanRemoval = true // TODO
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<OrderEntity> ordersCurrency = new ArrayList<>();

    @OneToMany(
            mappedBy = "instrumentEntity",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TradeEntity> tradesInstrument = new ArrayList<>();

    @OneToMany(
            mappedBy = "currency",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TradeEntity> tradesCurrency = new ArrayList<>();

}
