package com.gildedrose;

public class ItemHandler {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

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

    private void handleItemExpiration(Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }
        if (item.name.equals(AGED_BRIE)) {
            incrementItemQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            item.quality = 0;
        } else {
            decrementItemQuality(item);
        }
    }

    private void updateItemSellIn(Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }
        item.sellIn--;
    }

    private void updateItemQuality(Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }
        if (item.name.equals(AGED_BRIE)) {
            incrementItemQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            incrementItemQuality(item);

            if (item.sellIn < 11) {
                incrementItemQuality(item);
            }

            if (item.sellIn < 6) {
                incrementItemQuality(item);
            }
        } else {
            decrementItemQuality(item);
        }
    }

    private void decrementItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void incrementItemQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
