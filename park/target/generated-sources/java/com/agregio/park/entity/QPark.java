package com.agregio.park.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPark is a Querydsl query type for Park
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPark extends EntityPathBase<Park> {

    private static final long serialVersionUID = -1351347880L;

    public static final QPark park = new QPark("park");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final SetPath<Offer, QOffer> offers = this.<Offer, QOffer>createSet("offers", Offer.class, QOffer.class, PathInits.DIRECT2);

    public final EnumPath<com.agregio.park.constant.ParkType> type = createEnum("type", com.agregio.park.constant.ParkType.class);

    public QPark(String variable) {
        super(Park.class, forVariable(variable));
    }

    public QPark(Path<? extends Park> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPark(PathMetadata metadata) {
        super(Park.class, metadata);
    }

}

