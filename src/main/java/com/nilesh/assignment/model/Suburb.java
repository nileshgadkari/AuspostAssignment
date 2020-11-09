package com.nilesh.assignment.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
public class Suburb implements Serializable {
    @Id
    @GeneratedValue(generator = "suburb_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "suburb_id_seq",
            sequenceName = "suburb_id_seq",
            allocationSize = 10
    )
    private Long id;
    private String name;
    @ElementCollection
    private List<String> postcodes;

    public Suburb(){}
    public Suburb(String name, List<String> postcodes) {
        this.name = name;
        this.postcodes = postcodes;
    }
}
