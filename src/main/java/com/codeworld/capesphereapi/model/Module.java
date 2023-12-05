package com.codeworld.capesphereapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
