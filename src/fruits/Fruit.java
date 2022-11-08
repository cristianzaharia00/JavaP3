package fruits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

abstract public class Fruit implements Comparable<Fruit>{
    private double weight;
    private double water_content;
    private double sugar_content;
    private Color color;

    @Override
    public int compareTo(Fruit fruit) {
        if (weight < fruit.weight)
            return -1;
        else if (weight > fruit.weight) {
            return 1;
        }
        else {
            if (sugar_content < fruit.getSugar_content())
                return -1;
            else if (sugar_content > fruit.getSugar_content())
                return 1;
            else return 0;
        }
    }

    public double getSugar_content() {
        return sugar_content;
    }

    public void setSugar_content(double sugar_content) {
        this.sugar_content = sugar_content;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWater_content() {
        return water_content;
    }

    public void setWater_content(double water_content) {
        this.water_content = water_content;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static double computeWeight(ArrayList<Fruit> fruits) {
        double totalWeight = 0;
        for(Fruit f: fruits){
            totalWeight += f.getWeight();
        }
        return totalWeight;
    }

    public static double computeSugarContent(ArrayList<Fruit> fruits) {
        double totalSugarContent = 0;
        for(Fruit f: fruits){
            totalSugarContent += f.getSugar_content();
        }
        return totalSugarContent;
    }

    public static void prepareFruit(ArrayList<Fruit> fruits) {
        for (Fruit f: fruits){
            if(f instanceof Peelable){
                ((Peelable) f).peelOff();
            }
            if(f instanceof SeedRemovable){
                ((SeedRemovable) f).removeSeeds();
            }
        }
    }

    public static Map<String,Integer> countFruit(ArrayList<Fruit> fruits){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for (Fruit f : fruits)
            if (f instanceof Banana) {
                if (map.containsKey("Banana"))
                    map.put("Banana", map.get("Banana") + 1);
                else
                    map.put("Banana", 1);
            } else if (f instanceof Mango) {
                if (map.containsKey("Mango"))
                    map.put("Mango", map.get("Mango") + 1);
                else
                    map.put("Mango", 1);
            }
            else if (f instanceof Apple) {
                if (map.containsKey("Apple"))
                    map.put("Apple", map.get("Apple") + 1);
                else
                    map.put("Apple", 1);
            }
        return map;
    }



    public enum Color {
        RED,
        YELLOW,
        PURPLE,
        GREEN
    }
}

