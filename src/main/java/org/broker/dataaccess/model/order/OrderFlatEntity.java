package org.broker.dataaccess.model.order;

import lombok.*;
import org.broker.dataaccess.model.common.JPATools;
import org.broker.dataaccess.model.embeddable.Audit;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE Order SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "Order")
@Table(name = "orders")
public class OrderFlatEntity {

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
    @Column(
            name = "order_type_id",
            nullable = false
    )
    private Long orderTypeId;

    @Column(
            name = "status_id",
            nullable = false
    )
    private Long statusId;

    @Column(
            name = "trader_id",
            nullable = false
    )
    private Long traderId;

    // client can specify a favorite broker
    @Column(
            name = "broker_id",
            nullable = false
    )
    private Long brokerId;

    @Column(
            name = "instrument_id",
            nullable = false
    )
    private Long instrumentId;

    @Column(
            name = "currency_id",
            nullable = false
    )
    private Long currencyId;
}
