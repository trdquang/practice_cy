package Model;

import java.io.Serializable;

public class Dish implements Serializable {
    private int id;
    private String name;
    private String ingredrents;
    private String category;
    private int count;
    private static int length = 0;

    public Dish() {
    }

    public Dish(int id, String name, String ingredrents, String category, int count) {
        this.id = id;
        this.name = name;
        this.ingredrents = ingredrents;
        this.category = category;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredrents() {
        return ingredrents;
    }

    public void setIngredrents(String ingredrents) {
        this.ingredrents = ingredrents;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void sell(int quantity){
        this.count += quantity;
    }

    public static int getLength() {
        return length;
    }

    public static void setLength(int length) {
        Dish.length = length;
    }

    @Override
    public String toString() {
//        return super.toString();
        return String.format("%-10d; %-25s; %-45s; %-25s; %-5d", id, name, ingredrents, category, count);
    }
}
