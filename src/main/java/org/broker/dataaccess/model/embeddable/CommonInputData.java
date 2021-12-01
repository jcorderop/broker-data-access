package org.broker.dataaccess.model.embeddable;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Embeddable
public class CommonInputData implements Serializable {

    @NonNull
    @Column(
            nullable = false,
            unique = true
    )
    private String name;

    @NonNull
    @Column(
            nullable = false
    )
    private String description;
}
