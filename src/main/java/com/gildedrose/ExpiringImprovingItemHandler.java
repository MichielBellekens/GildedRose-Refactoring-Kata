package com.gildedrose;

public class ExpiringImprovingItemHandler extends ImprovingItemHandler {
    public ExpiringImprovingItemHandler(Item item) {
        super(item);
    }

    @Override
    protected void handleItemExpiration(Item item) {
        item.quality = 0;
    }

    @Override
    protected void updateItemQuality(Item item) {
        super.updateItemQuality(item);

        if (item.sellIn < 11) {
            incrementItemQuality(item);
        }

        if (item.sellIn < 6) {
            incrementItemQuality(item);
        }
    }
}
