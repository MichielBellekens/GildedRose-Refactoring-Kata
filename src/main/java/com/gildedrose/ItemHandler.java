package com.gildedrose;

public class ItemHandler {


    private final Item item;

    public ItemHandler(Item item) {
        this.item = item;
    }

    public final void handle() {
        updateItemQuality(item);

        updateItemSellIn(item);

        if (item.sellIn < 0) {
            handleItemExpiration(item);
        }
    }

    protected void handleItemExpiration(Item item) {
        decrementItemQuality(item);
    }

    protected void updateItemSellIn(Item item) {
        item.sellIn--;
    }

    protected void updateItemQuality(Item item) {
        decrementItemQuality(item);
    }

    protected final void decrementItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    protected final void incrementItemQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
