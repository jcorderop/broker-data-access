package org.broker.dataaccess.model.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.broker.dataaccess.model.common.JPATools;
import org.broker.dataaccess.model.embeddable.Audit;
import org.broker.dataaccess.model.embeddable.CommonInputData;
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
@SQLDelete(sql = "UPDATE OrderType SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "OrderType")
@Table(name = "orders_type")
public class OrderTypeEntity {

    public static final String SEQUENCE_NAME = "order_type_sequence";

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
            mappedBy = "orderTypeEntity",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<OrderEntity> orderEntities = new ArrayList<>();

}
