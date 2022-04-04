package com.agregio.park.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.agregio.constant.ParkType;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Park {
    @Id
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ParkType type;
}
