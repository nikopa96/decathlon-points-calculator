package ee.decathloncalculator.decathloncalculator.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PointScore {

    @Valid
    private Sport sport;

    @NotNull
    private Float result;

    private Long points;
}
