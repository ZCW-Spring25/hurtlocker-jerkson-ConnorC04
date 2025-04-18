package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {
        List<Item> items = new ArrayList<>();
        String[] entries = valueToParse.split("##");

        for (String entry : entries){
            try {
                Item item = parseSingleItem(entry);
                if (item != null) {
                    items.add(item);
                }
            } catch (ItemParseException e){
                System.out.println("Empty for now may revisit");
            }
        }
        return items;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String name = null;
        Double price = null;
        String type = null;
        String expiration = null;

        String fixSingleItem = singleItem.replaceAll("@", ":").replaceAll("\\^", ":").replaceAll("\\*", ":").replaceAll("%", ":");

        String[] fields = fixSingleItem.split(";");
        for (String field : fields){
            String[] pair = field.split(":");
            if (pair.length == 2){
                String key = pair[0].toLowerCase().trim();
                String value = pair[1].trim();
                if (key.equals("name")){
                    name = value.toLowerCase();
                } else if (key.equals("price")) {
                    price = Double.parseDouble(value);
                } else if (key.equals("type")) {
                    type = value.toLowerCase();
                } else if (key.equals("expiration")){
                    expiration = value.replaceAll("#", "");
                }
            }
        }
        if (name == null || price == null || type == null || expiration == null){
            throw new ItemParseException();
        }
        if (name.contains("0")){
            throw new ItemParseException();
        }
        return new Item(name, price, type, expiration);
    }
}
