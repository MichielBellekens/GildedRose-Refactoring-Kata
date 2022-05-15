package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    //Test regular cases
    @Test
    void normalItemDegradation() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void normalItemNeverBelowZero() {
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void normalItemExpiredDegradation() {
        Item[] items = new Item[]{new Item("Regular Item", 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void normalItemExpiredNeverBelowZero() {
        Item[] items = new Item[]{new Item("Regular Item", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    //Test Improving cases
    @Test
    void agedBrieDegradation() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void agedBrieNeverAbove50() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void expiredAgedBrieDegradation() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void expiredAgedBrieNeverAbove50() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 0, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    //Test Expirable Improving cases
    @Test
    void backstagePassesNormalDegradation() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 15, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void backstagePasses10DayDegradation() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void backstagePasses5DayDegradation() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void backstagePasses5DayDegradationNeverAbove50() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 5, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void expiredBackstagePasses() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASSES, 0, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    //Test legendary cases
    @Test
    void sulfurasItemNeverChanges() {
        Item[] items = new Item[]{new Item(SULFURAS, 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sulfurasExpiredItemNeverChanges() {
        Item[] items = new Item[]{new Item(SULFURAS, -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    //Test conjured cases
    @Test
    void conjuredItemDegradation() {
        Item[] items = new Item[]{new Item(CONJURED, 10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void conjuredItemNeverBelowZero() {
        Item[] items = new Item[]{new Item(CONJURED, 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredItemExpiredDegradation() {
        Item[] items = new Item[]{new Item(CONJURED, 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void conjuredItemExpiredNeverBelowZero() {
        Item[] items = new Item[]{new Item(CONJURED, 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
