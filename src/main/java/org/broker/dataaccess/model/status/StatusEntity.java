package org.broker.dataaccess.model.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.broker.dataaccess.model.common.JPATools;
import org.broker.dataaccess.model.embeddable.Audit;
import org.broker.dataaccess.model.embeddable.CommonInputData;
import org.broker.dataaccess.model.order.OrderEntity;
import org.broker.dataaccess.model.trade.TradeEntity;
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
@SQLDelete(sql = "UPDATE Status SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "Status")
@Table(name = "status")
public class StatusEntity {

    public static final String SEQUENCE_NAME = "status_sequence";

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
            mappedBy = "statusEntity",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<OrderEntity> orderEntities = new ArrayList<>();

    @OneToMany(
            mappedBy = "statusEntity",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TradeEntity> tradeEntities = new ArrayList<>();
}
