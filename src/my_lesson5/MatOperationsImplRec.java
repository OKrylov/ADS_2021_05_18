package my_lesson5;

public class MatOperationsImplRec implements MatOperations {

    @Override
    public int ErendIntoDegree(int num, int degree) {
        if (degree == 1){
            return num;
        }
        return num * ErendIntoDegree(num, --degree);
    }

    public static void main(String[] args) {
        System.out.println(new MatOperationsImplRec().ErendIntoDegree(2, 8));
    }

}
