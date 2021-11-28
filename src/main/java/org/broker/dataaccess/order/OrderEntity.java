package org.broker.dataaccess.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.broker.dataaccess.common.JPATools;
import org.broker.dataaccess.counterparty.CounterPartyEntity;
import org.broker.dataaccess.embeddable.Audit;
import org.broker.dataaccess.instrument.InstrumentEntity;
import org.broker.dataaccess.status.StatusEntity;
import org.broker.dataaccess.trade.TradeEntity;
import org.broker.dataaccess.user.UserEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE Order SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "Order")
@Table(name = "orders")
public class OrderEntity {

    public static final String SEQUENCE_NAME = "order_sequence";

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
    private Audit audit;

    // ---------------- Order reference data ----------------
    // for market order it will be null
    @Column
    private Double price;

    @NonNull
    @Column
    private Double quantity;

    @CreationTimestamp
    private LocalDateTime orderDateTime;

    //client request id
    @NonNull
    @Column(
            name = "external_ref",
            nullable = false
    )
    private String externalRef;

    // ---------------- internal reference ----------------
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "order_type_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_order__order_type_id_with_order_type_ref_id"
            )
    )
    @ToString.Exclude
    private OrderTypeEntity orderTypeEntity;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "status_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_order__status_id_with_status_ref_id"
            )
    )
    @ToString.Exclude
    private StatusEntity statusEntity;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "trader_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_order__trader_id_with_user_ref_id"
            )
    )
    @ToString.Exclude
    private UserEntity trader;

    // client can specify a favorite broker
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "broker_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_order__counter_party_id_with_counter_party_ref_id"
            )
    )
    @ToString.Exclude
    private CounterPartyEntity broker;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "instrument_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_order__instrument_id_with_instrument_ref_id"
            )
    )
    @ToString.Exclude
    private InstrumentEntity instrumentEntity;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "currency_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_order__currency_id_with_instrument_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private InstrumentEntity currency;

    @OneToMany(
            mappedBy = "orderEntity",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TradeEntity> tradeEntity;
}
