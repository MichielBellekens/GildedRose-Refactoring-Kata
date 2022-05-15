package com.gildedrose;

public class ItemHandlerFactory {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public static ItemHandler getItemHandler(final Item item) {
        if (item.name.equals(SULFURAS)) {
            return new LegendaryItemHandler(item);
        }
        if (item.name.equals(AGED_BRIE)) {
            return new ImprovingItemHandler(item);
        }
        if (item.name.equals(BACKSTAGE_PASSES)) {
            return new ExpiringImprovingItemHandler(item);
        }
        return new ItemHandler(item);
    }
}
