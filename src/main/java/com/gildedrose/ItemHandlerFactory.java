package com.gildedrose;

import java.util.Arrays;
import java.util.List;

public class ItemHandlerFactory {
    private static final List<String> LEGENDARY_ITEMS = Arrays.asList("Sulfuras, Hand of Ragnaros");
    private static final List<String> IMPROVING_ITEMS = Arrays.asList("Aged Brie");
    private static final List<String> EXPIRING_ITEMS = Arrays.asList("Backstage passes to a TAFKAL80ETC concert");
    private static final List<String> CONJURING_ITEMS = Arrays.asList("Conjured Mana Cake");

    public static ItemHandler getItemHandler(final Item item) {
        if (LEGENDARY_ITEMS.contains(item.name)) {
            return new LegendaryItemHandler(item);
        }
        if (IMPROVING_ITEMS.contains(item.name)) {
            return new ImprovingItemHandler(item);
        }
        if (EXPIRING_ITEMS.contains(item.name)) {
            return new ExpiringImprovingItemHandler(item);
        }
        if (CONJURING_ITEMS.contains(item.name)) {
            return new ConjuringItemHandler(item);
        }
        return new RegularItemHandler(item);
    }
}
