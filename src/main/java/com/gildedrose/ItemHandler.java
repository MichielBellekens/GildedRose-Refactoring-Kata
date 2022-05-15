package com.gildedrose;

public abstract class ItemHandler {


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

    protected abstract void handleItemExpiration(Item item);

    protected void updateItemSellIn(Item item) {
        item.sellIn--;
    }

    protected abstract void updateItemQuality(Item item);

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
