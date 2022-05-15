package com.gildedrose;

public class ItemHandlerFactory {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static ItemHandler getItemHandler(final Item item) {
        if (item.name.equals(SULFURAS)) {
            return new LegendaryItemHandler(item);
        }
        return new ItemHandler(item);
    }
}
