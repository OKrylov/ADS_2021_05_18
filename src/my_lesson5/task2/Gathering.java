package my_lesson5.task2;

import lesson4.SimpleLinkedListImpl;

import java.util.ArrayList;
import java.util.List;


/**
 * Класс выполняет комплектование рюкзака вещами на основе переданного набора вещей
 * и переданной максимальной вместительности рюкзака. Формирует осртированный по стоимости
 * массив рюкзаков удовлетворящий критерию максимального веса
 */
public class Gathering {
    private ThingStorage thingStorage;
    private int maxWeightBackpack;
    private List<Backpack> arrayBackpacks;

    public Gathering(ThingStorage thingStorage, int maxWeightBackpack) {
        this.thingStorage = thingStorage;
        this.maxWeightBackpack = maxWeightBackpack;
        arrayBackpacks = new ArrayList<>();
        complete(this.thingStorage);
        this.arrayBackpacks.sort((a, b) -> b.getTotalCost() - a.getTotalCost());
    }

    private void complete(ThingStorage thingStorage) {
        if (thingStorage.getThingsStorage().isEmpty()) {
            return;
        }
//        thingStorage.display();
        ThingForBackpack thing = thingStorage.getThingsStorage().removeFirst();
//        thingStorage.display();

        ThingStorage thingStorageClone = thingStorage.clone();
//        thingStorageClone.display();
        Backpack backpack = new Backpack(thing);
        if (backpack.getTotalWeight() <= this.maxWeightBackpack){
            arrayBackpacks.add(backpack);
            completeBackpacks(new Backpack(thing), thingStorage);
        }
        complete(thingStorageClone);
    }

    private void completeBackpacks(Backpack backpack, ThingStorage thingStorage) {
//
//        arrayBackpacks.add(backpack);
        if (thingStorage.getThingsStorage().isEmpty()) {
            return;
        }
        ThingForBackpack thing = thingStorage.getThingsStorage().removeFirst();
        Backpack nextBackpack = backpack.clone();
        nextBackpack.addThing(thing);
        ThingStorage thingStorageClone = thingStorage.clone();
        if(nextBackpack.getTotalWeight() <= this.maxWeightBackpack){
            arrayBackpacks.add(nextBackpack);
            completeBackpacks(nextBackpack, thingStorage);
        }

        if (!thingStorageClone.getThingsStorage().isEmpty()) {
            completeBackpacks(backpack, thingStorageClone);
        }
    }

    public void display(){
        for (Backpack backpack: this.arrayBackpacks) {
            System.out.println(backpack.toString());
        }
    }
}
