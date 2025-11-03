package collectionFramework.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Maths", 95);
        map.put("Science", 95);
        map.put("Hindi", 95);
        map.put("English", 95);

        System.out.println("Marks in Maths is - " + map.get("Maths"));

        System.out.println("Total Subjects - " + map.keySet());

        System.out.println("Marks in Chemistry - " + map.getOrDefault("Chemistry", 0));
        System.out.println();
        for(String key : map.keySet()){
            System.out.println("Key : " + key + " Values : " + map.get(key));
        }
    }
}
