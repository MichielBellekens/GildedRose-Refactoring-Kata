package com.gildedrose;

public class ItemHandler {

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

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
        if (item.name.equals(BACKSTAGE_PASSES)) {
            item.quality = 0;
        } else {
            decrementItemQuality(item);
        }
    }

    protected void updateItemSellIn(Item item) {
        item.sellIn--;
    }

    protected void updateItemQuality(Item item) {
        if (item.name.equals(BACKSTAGE_PASSES)) {
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
