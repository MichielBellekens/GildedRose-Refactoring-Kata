package com.gildedrose;

import javax.swing.plaf.basic.BasicComboBoxUI;
import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
            .map(ItemHandlerFactory::getItemHandler)
            .forEach(ItemHandler::handle);
    }

}
