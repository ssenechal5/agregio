package com.agregio.entity;

import com.agregio.constant.ParkType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Park {
    @Id
    @SequenceGenerator(
            name = "park_id_sequence",
            sequenceName = "park_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "park_id_sequence"
    )
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ParkType type;
}
