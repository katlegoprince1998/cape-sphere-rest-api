package com.codeworld.capesphereapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_module"
)

public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long module_id;
    private String name;
    private String level;
//create a relationship with candidate
    @ManyToMany
    @JoinTable(
            name = "module_enrollment",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "candidateID")
    )
    private Set<Candidate> candidates = new HashSet<>();

    //create a relationship with grade
    @JsonIgnore
    @OneToMany(mappedBy = "module")
    private Set<Grade> grades = new HashSet<>();
}
