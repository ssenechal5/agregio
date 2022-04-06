package com.agregio.park.entity;

import com.agregio.park.constant.ParkType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ParkType type;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="park")
    @JsonBackReference
    private Set<Offer> offers;
}
