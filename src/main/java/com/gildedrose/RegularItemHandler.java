package com.gildedrose;

public class RegularItemHandler extends ItemHandler {
    public RegularItemHandler(Item item) {
        super(item);
    }

    @Override
    protected void handleItemExpiration(Item item) {
        decrementItemQuality(item);
    }

    @Override
    protected void updateItemQuality(Item item) {
        decrementItemQuality(item);
    }
}
