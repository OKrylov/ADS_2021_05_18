package my_lesson5.task1;

public class MatOperationsImplRec implements MatOperations {

    @Override
    public int ErendIntoDegree(int num, int degree) {
        if (degree == 1){
            return num;
        }
        return num * ErendIntoDegree(num, --degree);
    }



}
