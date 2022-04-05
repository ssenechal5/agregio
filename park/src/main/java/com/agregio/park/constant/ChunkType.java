package com.agregio.park.constant;

public enum ChunkType {
    // une journée de 24h pourrait contenir 8 blocs de 3 heures
    TIME0TO3(1),TIME3TO6(2),TIME6TO9(3),TIME9TO12(4),TIME12TO15(5),
    TIME15TO18(6),TIME18TO21(7),TIME21TO24(8);

    private final int value;

    ChunkType(int value) {
        this.value = value;
    }

    public String value() {
        return name();
    }

    public int getValue() {
        return value;
    }

    public static ChunkType fromValue(String v) {
        return valueOf(v);
    }

    public static ChunkType fromValue(int value) {
        for (ChunkType type : ChunkType.values()) {
            if (type.value == value)
                return type;
        }
        return null;
    }
}
