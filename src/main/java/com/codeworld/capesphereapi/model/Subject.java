package com.codeworld.capesphereapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(
        name = "tbl_subject"
)

public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subject_id;
    private String name;
    @Column(name = "sub_level")
    private String level;
//create a relationship with candidate
    @ManyToMany
    @JoinTable(
            name = "subject_enrollment",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "candidateID")
    )
    private Set<Candidate> candidates = new HashSet<>();

    //create a relationship with grade
    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    private Set<Grade> grades = new HashSet<>();


}
