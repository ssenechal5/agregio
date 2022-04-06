package com.agregio.park.entity;

import com.agregio.park.constant.ChunkType;
import com.agregio.park.constant.MarketType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date day;
    @Enumerated(EnumType.STRING)
    private MarketType market;
    private BigDecimal quantity;
    private BigDecimal bottomPrice;
    @Enumerated(EnumType.STRING)
    private ChunkType chunk;

    @ManyToOne
    @JoinColumn(name="parkId", nullable=false)
    @JsonManagedReference
    protected Park park;
}
