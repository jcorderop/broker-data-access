package org.broker.dataaccess.portfolio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.broker.dataaccess.common.JPATools;
import org.broker.dataaccess.embeddable.Audit;
import org.broker.dataaccess.embeddable.CommonInputData;
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
@SQLDelete(sql = "UPDATE Portfolio SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "Portfolio")
@Table(name = "portfolios")
public class PortfolioEntity {

    public static final String SEQUENCE_NAME = "portfolio_sequence";

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
    private CommonInputData commonInputData;

    @Embedded
    private Audit audit = new Audit();

    @OneToMany(
            mappedBy = "portfolioEntity",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TradeEntity> tradesPortfolio = new ArrayList<>();

    @OneToMany(
            mappedBy = "counterPartyPortfolioEntity",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TradeEntity> tradesCounterPartyPortfolio = new ArrayList<>();
}
