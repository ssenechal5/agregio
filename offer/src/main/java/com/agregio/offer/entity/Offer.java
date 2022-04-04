package com.agregio.offer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.agregio.constant.*;
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
    private Long id;
    private Date day;
    @Enumerated(EnumType.STRING)
    private MarketType market;
    private BigDecimal quantity;
    private BigDecimal bottomPrice;
    @Enumerated(EnumType.STRING)
    private ChunkType chunk;

    private Long parkId;
}
