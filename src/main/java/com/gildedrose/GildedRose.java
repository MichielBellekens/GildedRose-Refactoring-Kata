package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);

            updateItemSellIn(item);

            if (item.sellIn < 0) {
                handleItemExpiration(item);
            }
        }
    }

    private void handleItemExpiration(Item item) {
        if (!item.name.equals(AGED_BRIE)) {
            if (!item.name.equals(BACKSTAGE_PASSES)) {
                if (!item.name.equals(SULFURAS)) {
                    decrementItemQuality(item);
                }
            } else {
                item.quality = 0;
            }
        } else {
            incrementItemQuality(item);
        }
    }

    private void updateItemSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateItemQuality(Item item) {
        if (!item.name.equals(AGED_BRIE)
            && !item.name.equals(BACKSTAGE_PASSES)) {
            if (!item.name.equals(SULFURAS)) {
                decrementItemQuality(item);
            }
        } else {
            incrementItemQuality(item);

            if (item.name.equals(BACKSTAGE_PASSES)) {
                if (item.sellIn < 11) {
                    incrementItemQuality(item);
                }

                if (item.sellIn < 6) {
                    incrementItemQuality(item);
                }
            }
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
