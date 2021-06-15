package my_lesson5.task2;


/**
 * Описывает вещь которую можно поместить в рюкзак
 */
public class ThingForBackpack {
    private int weight;
    private int prise;

    public ThingForBackpack(int weight, int prise){
        this.weight = weight;
        this.prise = prise;
    }

    public ThingForBackpack(){
        this.weight = (int) (Math.random() * 40);
        this.prise = (int) (Math.random() * 1000);
    }

    public int getWeight(){
        return this.weight;
    }

    public int getPrise() {
        return this.prise;
    }

    @Override
    public String toString(){
        return "[weight = " + weight + ", prise = " + prise + "]";
    }

    public void display(){

    }



}
