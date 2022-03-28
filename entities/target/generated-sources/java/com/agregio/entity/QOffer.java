package com.agregio.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOffer is a Querydsl query type for Offer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOffer extends EntityPathBase<Offer> {

    private static final long serialVersionUID = 1549652504L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOffer offer = new QOffer("offer");

    public final NumberPath<java.math.BigDecimal> bottomPrice = createNumber("bottomPrice", java.math.BigDecimal.class);

    public final EnumPath<com.agregio.constant.ChunkType> chunk = createEnum("chunk", com.agregio.constant.ChunkType.class);

    public final DateTimePath<java.util.Date> day = createDateTime("day", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.agregio.constant.MarketType> market = createEnum("market", com.agregio.constant.MarketType.class);

    public final QPark park;

    public final NumberPath<java.math.BigDecimal> quantity = createNumber("quantity", java.math.BigDecimal.class);

    public QOffer(String variable) {
        this(Offer.class, forVariable(variable), INITS);
    }

    public QOffer(Path<? extends Offer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOffer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOffer(PathMetadata metadata, PathInits inits) {
        this(Offer.class, metadata, inits);
    }

    public QOffer(Class<? extends Offer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.park = inits.isInitialized("park") ? new QPark(forProperty("park")) : null;
    }

}

