package com.nilesh.assignment.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Suburb {
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
