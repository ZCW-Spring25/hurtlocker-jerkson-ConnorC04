package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {
        List<Item> items = new ArrayList<>();
        String[] entries = valueToParse.split("##");
        return null;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String name = null;
        Double price = null;
        String type = null;
        String expiration = null;

        String[] fields = singleItem.split(";");
        return null;
    }
}
