package org.broker.dataaccess.model.instrument;

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
@SQLDelete(sql = "UPDATE InstrumentType SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Entity(name = "InstrumentType")
@Table(name = "instruments_type")
public class InstrumentTypeEntity {

    public static final String SEQUENCE_NAME = "instrument_type_sequence";

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
            mappedBy = "instrumentTypeEntity",
            cascade = {
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<InstrumentEntity> instrumentEntities = new ArrayList<>();
}
