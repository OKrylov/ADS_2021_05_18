package my_lesson5.task2;

import lesson4.SimpleLinkedListImpl;
import lesson4.TwoSideLinkedList;
import lesson4.TwoSideLinkedListImpl;

/**
 * Описывает произвольный набор вещей на основании которого происходит комплектование рюкзака
 */
public class ThingStorage {
    private TwoSideLinkedList<ThingForBackpack> thingsStorage;

    public ThingStorage(){
        thingsStorage = new TwoSideLinkedListImpl<>();
    }

    public ThingStorage (int numberOfThings){
        thingsStorage = new TwoSideLinkedListImpl<>();
        for (int i = 0; i < numberOfThings; i++) {
            this.thingsStorage.insertFirst(new ThingForBackpack());
        }
    }

    public void addThing(ThingForBackpack thing){
        this.thingsStorage.insertLast(thing);
    }

    public TwoSideLinkedList<ThingForBackpack> getThingsStorage() {
        return thingsStorage;
    }

    @Override
    public ThingStorage clone(){
        ThingStorage thingStorageClone = new ThingStorage();
        for (ThingForBackpack thing: thingsStorage) {
            thingStorageClone.addThing(thing);
        }
        return thingStorageClone;
    }

    public void display(){
        System.out.println("ThingsStorage<");
        for (ThingForBackpack thing: thingsStorage) {
            System.out.println(thing.toString());
        }
        System.out.println(">");
    }
}
