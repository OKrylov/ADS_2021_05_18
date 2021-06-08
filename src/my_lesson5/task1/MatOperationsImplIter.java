package my_lesson5.task1;

public class MatOperationsImplIter implements MatOperations {

    @Override
    public int ErendIntoDegree(int num, int degree) {
        int res = 1;
        for (int i = 0; i < degree; i++) {
            res = res * num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MatOperationsImplIter().ErendIntoDegree(2, 8));
    }

}
