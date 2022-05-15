package com.gildedrose;

public class ItemHandlerFactory {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";

    public static ItemHandler getItemHandler(final Item item) {
        if (item.name.equals(SULFURAS)) {
            return new LegendaryItemHandler(item);
        }
        if (item.name.equals(AGED_BRIE)) {
            return new ImprovingItemHandler(item);
        }
        return new ItemHandler(item);
    }
}
