package co.chagas.chews3.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.chagas.chews3.data.MyDB;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Content {

    MyDB dba;
    private class MyRestaurant{
        public MyRestaurant(String n, String a, String t, String c){
            name = n;
            address = a;
            type = t;
            comment = c;
        }

        public String name;
        public String address;
        public String type;
        public String comment;
    }



    /**
     * An array of content items.
     */
    public static List<Item> ITEMS = new ArrayList<Item>();

    /**
     * A map of content items, by ID.
     */
    public static Map<String, Item> ITEM_MAP = new HashMap<String, Item>();

    static {
        // Add 3 sample items.
        addItem(new Item("1", "Item 1"));
        addItem(new Item("2", "Item 2"));
        addItem(new Item("3", "Item 3"));
    }

    private static void addItem(Item item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A content item representing a piece of content.
     */
    public static class Item {
        public String id;
        public String content;

        public Item(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
