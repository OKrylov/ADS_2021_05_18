package my_lesson5.task1;

public class Test {
    public static void main(String[] args) {
        System.out.println("2^8 = " + new MatOperationsImplIter().ErendIntoDegree(2, 8));
        System.out.println("2^8 = " + new MatOperationsImplRec().ErendIntoDegree(2, 8));
        System.out.println("2^2 = " + new MatOperationsImplIter().ErendIntoDegree(2, 2));
        System.out.println("2^2 = " + new MatOperationsImplRec().ErendIntoDegree(2, 2));
    }
}
