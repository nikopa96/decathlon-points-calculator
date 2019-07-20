package ee.decathloncalculator.decathloncalculator.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sport")
@Setter
@Getter
public class Sport {

    @Id
    @NotNull
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit")
    private String unit;

    @Column(name = "category")
    private String category;

    @Column(name = "coefficient_a")
    private Float coefficientA;

    @Column(name = "coefficient_b")
    private Float coefficientB;

    @Column(name = "coefficient_c")
    private Float coefficientC;

}
