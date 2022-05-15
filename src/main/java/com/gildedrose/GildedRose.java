package com.gildedrose;

import javax.swing.plaf.basic.BasicComboBoxUI;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            new ItemHandler(item).handle();
        }
    }

}
