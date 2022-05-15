package com.gildedrose;

import java.util.stream.IntStream;

public class ConjuringItemHandler extends RegularItemHandler {
    private static final int DEGRADATION_FACTOR = 2;

    public ConjuringItemHandler(Item item) {
        super(item);
    }

    @Override
    protected void handleItemExpiration(Item item) {
        IntStream.range(0, DEGRADATION_FACTOR).forEach(count -> super.handleItemExpiration(item));
    }

    @Override
    protected void updateItemQuality(Item item) {
        IntStream.range(0, DEGRADATION_FACTOR).forEach(count -> super.updateItemQuality(item));
    }
}
