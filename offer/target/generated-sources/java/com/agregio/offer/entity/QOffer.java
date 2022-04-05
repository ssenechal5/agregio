package com.agregio.offer.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOffer is a Querydsl query type for Offer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOffer extends EntityPathBase<Offer> {

    private static final long serialVersionUID = 517898026L;

    public static final QOffer offer = new QOffer("offer");

    public final NumberPath<java.math.BigDecimal> bottomPrice = createNumber("bottomPrice", java.math.BigDecimal.class);

    public final EnumPath<com.agregio.offer.constant.ChunkType> chunk = createEnum("chunk", com.agregio.offer.constant.ChunkType.class);

    public final DateTimePath<java.util.Date> day = createDateTime("day", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.agregio.offer.constant.MarketType> market = createEnum("market", com.agregio.offer.constant.MarketType.class);

    public final NumberPath<Long> parkId = createNumber("parkId", Long.class);

    public final NumberPath<java.math.BigDecimal> quantity = createNumber("quantity", java.math.BigDecimal.class);

    public QOffer(String variable) {
        super(Offer.class, forVariable(variable));
    }

    public QOffer(Path<? extends Offer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOffer(PathMetadata metadata) {
        super(Offer.class, metadata);
    }

}

