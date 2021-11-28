package org.broker.dataaccess.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.broker.dataaccess.common.JPATools;
import org.broker.dataaccess.counterparty.CounterPartyEntity;
import org.broker.dataaccess.embeddable.Audit;
import org.broker.dataaccess.instrument.InstrumentEntity;
import org.broker.dataaccess.order.OrderEntity;
import org.broker.dataaccess.portfolio.PortfolioEntity;
import org.broker.dataaccess.status.StatusEntity;
import org.broker.dataaccess.user.UserEntity;
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
@SQLDelete(sql = "UPDATE Trade SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "Trade")
@Table(name = "trades")
public class TradeEntity {

    public static final String SEQUENCE_NAME = "trade_sequence";

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

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "trade_type_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_trade__trade_type_id_with_trade_type_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TradeTypeEntity tradeTypeEntity;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "status_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_trade__status_id_with_status_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private StatusEntity statusEntity;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "trader_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_trade__trader_id_with_user_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserEntity trader;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "counter_party_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_trade__counter_party_id_with_counter_party_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CounterPartyEntity counterParty;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "instrument_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_trade__instrument_id_with_instrument_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private InstrumentEntity instrumentEntity;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "currency_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_tarde__currency_id_with_instrument_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private InstrumentEntity currency;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_trade__order_id_with_order_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private OrderEntity orderEntity;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "portfolio_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_trade__portfolio_id_with_portfolio_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private PortfolioEntity portfolioEntity;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "ctpy_portfolio_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_trade__ctpy_portfolio_id_with_portfolio_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private PortfolioEntity counterPartyPortfolioEntity;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "broker_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "FK_trade__broker_id_with_counter_party_ref_id"
            )
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CounterPartyEntity broker;


    @NonNull
    @Column(
            name = "broker_fees"
    )
    private Double brokerFees;

    @NonNull
    @Column(
            name = "trade_date_time"
    )
    private LocalDateTime tradeDateTime;

    @NonNull
    @Column(
            name = "value_date_time",
            updatable = false
    )
    private LocalDateTime valueDateTime;

    @NonNull
    @Column(
            name = "acquired_date_time",
            updatable = false
    )
    private LocalDateTime acquiredDateTime;

    @CreationTimestamp
    private LocalDateTime executionDateTime;
}
