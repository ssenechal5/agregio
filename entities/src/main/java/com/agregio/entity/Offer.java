package com.agregio.entity;

import com.agregio.constant.ChunkType;
import com.agregio.constant.MarketType;
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
    @SequenceGenerator(
            name = "offer_id_sequence",
            sequenceName = "offer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "offer_id_sequence"
    )
    private Long id;
    private Date day;
    @Enumerated(EnumType.STRING)
    private MarketType market;
    private BigDecimal quantity;
    private BigDecimal bottomPrice;
    @Enumerated(EnumType.STRING)
    private ChunkType chunk;

    @ManyToOne
    protected Park park;
}
