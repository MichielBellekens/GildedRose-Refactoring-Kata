package com.gildedrose;

public class ImprovingItemHandler extends ItemHandler {
    public ImprovingItemHandler(Item item) {
        super(item);
    }

    @Override
    protected void handleItemExpiration(Item item) {
        incrementItemQuality(item);
    }

    @Override
    protected void updateItemQuality(Item item) {
        incrementItemQuality(item);
    }
}
