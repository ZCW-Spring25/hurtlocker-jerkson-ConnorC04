package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {

        GroceryReporter reporter = new GroceryReporter("RawInput.JerkSON");
        ItemParser parser = new ItemParser();

        List<Item> items = parser.parseItemList("RawInput.JerkSON");

        Map<Item, Integer> itemCount = new HashMap<>();
        Map<Item, Map<Double, Integer>> priceCount = new HashMap<>();
        int errorCount = 0;

        for (Item item : items){
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
            priceCount.putIfAbsent(item, new HashMap<>());
            priceCount.get(item).put(item.getPrice(), priceCount.get(item).getOrDefault(item.getPrice(), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Item item : items){
            sb.append("name:    ").append(item.getName()).append(" \t seen: ").append(itemCount.get(item)).append(" times\n");
            sb.append("=============  \t =============\n");
            Map<Double, Integer> prices = priceCount.get(item);
            for (Double price : prices.keySet()) {
                sb.append("Price:     ").append(price).append(" \t seen: ").append(prices.get(price)).append(" times\n");
                sb.append("------------- \t -------------\n");
            }
            sb.append("\n");
        }


        sb.append("Errors          \t seen: ").append(errorCount).append(" times\n");

        return sb.toString();
    }
}
