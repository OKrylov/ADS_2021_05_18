package my_lesson5.task2;

import java.util.ArrayList;


/**
 * Класс описывает рюкзак
 */
public class Backpack implements Cloneable{
    private ArrayList<ThingForBackpack> things;

    public Backpack(){
        this.things = new ArrayList<>();
    }

    public Backpack(ThingForBackpack thing){
        this.things = new ArrayList<>();
        this.things.add(thing);

    }

    public void addThing(ThingForBackpack thing) {
        this.things.add(thing);

    }

   public int getTotalCost() {
        int totalCost = 0;
        for (ThingForBackpack thing : this.things) {
            totalCost += thing.getPrise();
        }
        return totalCost;
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (ThingForBackpack thing : this.things) {
            totalWeight += thing.getWeight();
        }
        return totalWeight;
    }

    @Override
    public Backpack clone(){
        Backpack backpack = new Backpack();
        for (ThingForBackpack thing: this.things) {
            backpack.addThing(thing);
        }
        return backpack;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Backpack<");
        for (ThingForBackpack thing: this.things) {
            stringBuilder.append(thing.toString());
        }
        stringBuilder.append("TotalWeight = " + this.getTotalWeight() + ", TotalCost = " + this.getTotalCost() + ">");
        return new String(stringBuilder);
    }




}
