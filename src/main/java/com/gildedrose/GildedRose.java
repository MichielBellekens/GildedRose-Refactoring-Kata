package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    decrementItemQuality(item);
                }
            } else {
                incrementItemQuality(item);

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        incrementItemQuality(item);
                    }

                    if (item.sellIn < 6) {
                        incrementItemQuality(item);
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            decrementItemQuality(item);
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
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
