package my_lesson5.task2;

public class Test {
    public static void main(String[] args) {
        ThingStorage thingStorage = new ThingStorage(10);
        thingStorage.display();
        Gathering gathering = new Gathering(thingStorage, 70);
        gathering.display();
    }


}
