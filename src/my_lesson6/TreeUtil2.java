package my_lesson6;

import java.util.ArrayList;

public class TreeUtil2 {

    /**
     * Печатает графическое представление дерева !!!! НЕ ДОРАБОТАН
     */
    public static ArrayList<ArrayList<Integer>> display(Tree tree) {
//    public static ArrayList<ArrayList<Integer>> display(Tree tree) {

        int countTreeLevels = getCountTreeLevels(tree.root);
        int maxCountLevelItems = getMaxCountLevelItems(tree.root);
        ArrayList<ArrayList<Integer>> treeArray = getTreeArray(tree);
        System.out.println("treeArray print");
        for (int i = 0; i < treeArray.size(); i++) {
            for (int j = 0; j < treeArray.get(i).size(); j++) {
                System.out.print(treeArray.get(i).get(j) + " ");
            }
            System.out.println();
        }
        String[] treeStringArray = getTreeStringArray(treeArray, countTreeLevels, maxCountLevelItems);
        for (int i = 0; i < treeStringArray.length; i++) {
            System.out.println(treeStringArray[i]);
        }
//        System.out.println("treeString print");
//        System.out.println(treeStringArray);
        return treeArray;
    }



    /**
     * Считает фактическое колличество уровней дерева / рассояние до самой далёкой вершины
     */
    public static int getCountTreeLevels(Tree tree){
        return getCountTreeLevels(tree.root);
    }
    private static int getCountTreeLevels(Node rootNode, Integer... count) {
        int countLoc = count.length == 0 ? 0 : count[0];
        if (rootNode == null) return countLoc;
        int countLeft = getCountTreeLevels(rootNode.leftChild, countLoc + 1);
        int countRight = getCountTreeLevels(rootNode.rightChild, countLoc + 1);
        return Math.max(countLeft, countRight);
    }

    /**
     * Считает нормативное колличество уровней дерева
     */
    public static int getNormCountTreeLevels(int countNode){
        return (int) Math.ceil((Math.log(countNode) / Math.log(2)));
    }




    /**
     * Вычесляет маклимальное кол-во элементов в строке массива дерева
     */
    private static int getMaxCountLevelItems(Node node, Integer... position) {
        int maxPosition = getMaxItemPosition(node, position);
        return maxPosition == -1 ? 0 : maxPosition + 1;
    }

    /**
     * Вычисляет максимальный индекс числа в строке массива дерева
     */
    private static int getMaxItemPosition(Node node, Integer... position) {
        if (node == null) return -1;
        int positionLoc = position.length == 0 ? 0 : position[0];
        int positionLeft = node.leftChild == null ? positionLoc : getMaxItemPosition(node.leftChild, positionLoc * 2);
        int positionRight = node.rightChild == null ? positionLoc : getMaxItemPosition(node.rightChild, positionLoc * 2 + 1);
        return Math.max(positionLeft, positionRight);
    }

    /**
     * Создаёт массив дерева  размером countTreeLevels х maxCountLevelItems,
     * заполняет его значениями null
     */
    private static void fillNullTreeArray(ArrayList<ArrayList<Integer>> treeArray, int countTreeLevels, int maxCountLevelItems) {
        for (int i = 0; i < countTreeLevels; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < maxCountLevelItems; j++) {
                arrayList.add(j, null);
            }
            treeArray.add(i, arrayList);
        }
    }

    /**
     *создаёт treeArray
     */
    public static ArrayList<ArrayList<Integer>> getTreeArray(Tree tree){
        ArrayList<ArrayList<Integer>> treeArray = new ArrayList<>();
        int countTreeLevels = getCountTreeLevels(tree.root);
        int maxCountLevelItems = getMaxCountLevelItems(tree.root);
        fillNullTreeArray(treeArray, countTreeLevels, maxCountLevelItems);
        fillValueTreeArray(tree.root, treeArray);
        return treeArray;
    }
    /**
     *Заполняет инициированный значениями null массив дерева
     * размером countTreeLevels х maxCountLevelItems
     * значениями дерева, ставя их на соответсвующие позиции
     */
    private static void fillValueTreeArray(Node rootNode, ArrayList<ArrayList<Integer>> treeArray, Integer... level_position) {
        if (rootNode == null) return;
        int level = level_position.length == 0 ? 0 : level_position[0];
        int position = level_position.length == 0 ? 0 : level_position[1];
        treeArray.get(level).set(position, rootNode.value);
        fillValueTreeArray(rootNode.leftChild, treeArray, level + 1, position * 2);
        fillValueTreeArray(rootNode.rightChild, treeArray, level + 1, position * 2 + 1);
    }

    /**
     * Печатает treeArray
     */
    public static void displayTreeArray(Tree tree, String placeHolderForeNullValue) {
        ArrayList<ArrayList<Integer>> treeArray = getTreeArray(tree);
        for (int i = 0; i < treeArray.size(); i++) {
            for (int j = 0; j < treeArray.get(i).size(); j++) {
                if (treeArray.get(i).get(j) == null) {
                    System.out.print(placeHolderForeNullValue);
                } else {
                    System.out.print(treeArray.get(i).get(j) + "   ");
                }
            }
            System.out.println();
        }
    }



    /**
     * Создаёт массив строк дерева со связями
     */
    private static String[] getTreeStringArray(ArrayList<ArrayList<Integer>> treeArray, int countTreeLevels, int maxCountLevelItems) {

        String placeHolder = " ";
        int countPlaceHolder = 4;
        String[] newRowPlaceHolders = getNewRowPlaceholders(placeHolder, countPlaceHolder, countTreeLevels);
        String[] rowStrings = getRowStringsArray(treeArray, countTreeLevels, maxCountLevelItems, placeHolder, countPlaceHolder);
        String[] upLincStrings = getUpLincStrings(treeArray, countTreeLevels, maxCountLevelItems, placeHolder, countPlaceHolder);
        String[] downLincStrings = getDownLincStrings(treeArray, countTreeLevels, maxCountLevelItems, placeHolder, countPlaceHolder);
        String[] treeStringArray = combineStings(newRowPlaceHolders, rowStrings, upLincStrings, downLincStrings, countTreeLevels);
        return treeStringArray;
    }

    /**
     * Создаёт отступ для каждой строки массива дерева
     */
    private static String[] getNewRowPlaceholders(String placeHolder, int countPlaceHolder, int countTreeLevels) {
        String[] newRowPlaceholders = new String[countTreeLevels];
        float[] countNewRowPlaceholdersOnLevel = getCountNewRowPlaceholdersOnLevel(countTreeLevels);
        for (int i = 0; i < countTreeLevels; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < (countPlaceHolder * countNewRowPlaceholdersOnLevel[i]); j++) {
//                sb.append(placeHolder);
                sb.append("n");
            }
            newRowPlaceholders[i] = sb.toString();
        }
        return newRowPlaceholders;
    }

    /**
     * считает колличество пласхолдеров в начале каждой строки массива дерева
     */
    private static float[] getCountNewRowPlaceholdersOnLevel(int countTreeLevels) {
        float[] countNewRowPlaceholdersOnLevel = new float[countTreeLevels];
        countNewRowPlaceholdersOnLevel[countTreeLevels - 1] = 0f;
        for (int i = countTreeLevels - 2; i >= 0; i--) {
            countNewRowPlaceholdersOnLevel[i] = 0.5f + 2f * countNewRowPlaceholdersOnLevel[i + 1];
            System.out.println("countNewRowPlaceholdersOnLevel[i] print");
            System.out.println(countNewRowPlaceholdersOnLevel[i]);
        }
        return countNewRowPlaceholdersOnLevel;
    }

    /**
     * создаёт массив строк сооветствущщих строкам массива дерева
     */
    private static String[] getRowStringsArray(ArrayList<ArrayList<Integer>> treeArray, int countTreeLevels, int maxCountLevelItems, String placeHolder, int countPlaceHolder) {
        String[] rowsPlaceHolders = getRowsPlaceHolders(countTreeLevels, placeHolder, countPlaceHolder);
        String[] rowsStrings = new String[countTreeLevels];
       for (int i = 0; i < countTreeLevels; i++) {
            StringBuilder sb = new StringBuilder();
            int j;
            for (j = maxCountLevelItems - 1; j >= 0; j--) {
                if (treeArray.get(i).get(j) != null){
                    break;
                }
            }
            for (int k = 0; k <= j ; k++) {
                String numberPlaceHolder = getNumberPaceHolder(treeArray.get(i).get(k), placeHolder, countPlaceHolder);
                sb.append(numberPlaceHolder);
                sb.append(rowsPlaceHolders[i]);
            }
            rowsStrings[i] = sb.toString();
//            System.out.println("rowsStrings print");
//            System.out.println(rowsStrings[i]);
        }
        return rowsStrings;
    }

    /**
     * создаёт массив строк соответствующих промяжуткам между цифрер в уровне дерева
     */
    private static String[] getRowsPlaceHolders(int countTreeLevels, String placeHolder, int countPlaceHolder){

        String[] rowsPlaceHolders = new String[countTreeLevels];
        float[] countRowPlaceHolders = getCountRowPlaceHolders(countTreeLevels);
        for (int i = 0; i < countTreeLevels; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < countRowPlaceHolders[i] * countPlaceHolder; j++) {
                sb.append(placeHolder);
            }
            rowsPlaceHolders[i] = sb.toString();
        }
        return rowsPlaceHolders;
    }

    /**
     * создаёт массив значений соответствующх колличеству пласходеров (countPlaceHolder)
     * между цифрами уровня дерева
     */
    private static float[] getCountRowPlaceHolders(int countTreeLevels){
        float[] countRowPlaceHolders = new float[countTreeLevels];
        countRowPlaceHolders[countTreeLevels - 1] = 0;
        for (int i = countTreeLevels - 2; i >= 0; i--) {
            countRowPlaceHolders[i] = 1f + 2f * countRowPlaceHolders[i + 1];
        }
        return countRowPlaceHolders;
    }

    /**
     * создаёт строку для цифры дерева
     */
    private static String getNumberPaceHolder(Integer number, String placeHolder, int countPlaceHolder){
        StringBuilder sb = new StringBuilder();
        if (number != null){
            if (number.toString().length() > countPlaceHolder){
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Длина номера больше длины пласхолдера");
                }
            }
            for (int i = 0; i < (countPlaceHolder - number.toString().length()) / 2; i++) {
                sb.append(placeHolder);
            }
            sb.append(number.toString());
            for (int i = 0; i < countPlaceHolder - sb.length(); i++) {
                sb.append(placeHolder);
            }
        } else {
            for (int i = 0; i < countPlaceHolder; i++) {
                sb.append(placeHolder);
            }
        }
        return sb.toString();
    }

    private static String[] getUpLincStrings(ArrayList<ArrayList<Integer>> treeArray, int countTreeLevels, int maxCountLevelItems, String placeHolder, int countPlaceHolder){
        float[] countRowPlaceHolders = getCountRowPlaceHolders(countTreeLevels);
        String[] upLincStrings = new String[countTreeLevels - 1];
        for (int i = 0; i < countTreeLevels - 2; i++) {
            StringBuilder sb = new StringBuilder();
            int l;
            for (l = maxCountLevelItems - 1; l >= 0; l--) {
                if (treeArray.get(i).get(l) != null){
                    break;
                }
            }
            for (int j = 0; j <=  l; j++) {
                if (treeArray.get(i).get(j) != null) {
                    if (treeArray.get(i+1).get(j*2) != null) {
                        for (int k = 0; k < countPlaceHolder/2; k++) {
                            sb.append(placeHolder);
                        }
                        for (int k = 0; k < countPlaceHolder - countPlaceHolder/2; k++) {
                            sb.append("_");
                        }
                        for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder/2-1; k++) {
                            sb.append("_");
                        }
                        sb.append("|");
                    } else {
                        for (int k = 0; k < countPlaceHolder; k++) {
                            sb.append(placeHolder);
                        }
                        for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder/2; k++) {
                            sb.append(placeHolder);
                        }
                    }
                    if (treeArray.get(i+1).get(j*2+1) != null) {
                        if(sb.charAt(sb.length()-1) == '|'){
                            for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder/2; k++) {
                                sb.append("_");
                            }
                            for (int k = 0; k < countPlaceHolder/2; k++) {
                                sb.append("_");
                            }
                            for (int k = 0; k < countPlaceHolder - countPlaceHolder/2; k++) {
                                sb.append(placeHolder);
                            }
                            /// TODO: 14.06.2021  
                            for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder; k++) {
                                sb.append(" ");
                            }

                        }else {
                            sb.append("|");
                            for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder/2 - 1; k++) {
                                sb.append("_");
                            }
                            for (int k = 0; k < countPlaceHolder/2; k++) {
                                sb.append("_");
                            }
                            for (int k = 0; k < countPlaceHolder - countPlaceHolder/2; k++) {
                                sb.append(placeHolder);
                            }
                        }

                    }else {
                        for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder/2; k++) {
                            sb.append(placeHolder);
                        }
                        for (int k = 0; k < countPlaceHolder; k++) {
//                            sb.append(placeHolder);
                            sb.append("*");
                        }
                        for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder; k++) {
                            sb.append(placeHolder);
                        }
                    }
                } else {
                    for (int k = 0; k < countPlaceHolder * 2; k++) {
//                        sb.append(placeHolder);
                        sb.append("*");
                    }
                    for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder * 2; k++) {
//                        sb.append(placeHolder);
                        sb.append("*");
                    }
                }
            }
            upLincStrings[i] = sb.toString();
        }
        return upLincStrings;
    }

    private static String[] getDownLincStrings(ArrayList<ArrayList<Integer>> treeArray, int countTreeLevels, int maxCountLevelItems, String placeHolder, int countPlaceHolder){
        float[] countRowPlaceHolders = getCountRowPlaceHolders(countTreeLevels);
        String[] downLincStrings = new String[countTreeLevels - 1];
        for (int i = 0; i < countTreeLevels - 2; i++) {
            StringBuilder sb = new StringBuilder();
            int l;
            for (l = maxCountLevelItems - 1; l >= 0; l--) {
                if (treeArray.get(i).get(l) != null){
                    break;
                }
            }
            for (int j = 0; j <=  l; j++) {
                if (treeArray.get(i).get(j) != null) {
                    if (treeArray.get(i+1).get(j*2) != null) {
                        for (int k = 0; k < countPlaceHolder/2; k++) {
                            sb.append(placeHolder);
                        }
                        sb.append("|");
                        for (int k = 0; k < countPlaceHolder - countPlaceHolder/2 - 1; k++) {
                            sb.append(placeHolder);
                        }

                        for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder; k++) {
                            sb.append(placeHolder);
                        }
                    } else {
                        for (int k = 0; k < countPlaceHolder; k++) {
                            sb.append(placeHolder);
                        }
                        for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder; k++) {
                            sb.append(placeHolder);
                        }
                    }
                    if (treeArray.get(i+1).get(j*2+1) != null) {
                        for (int k = 0; k < countPlaceHolder/2; k++) {
                            sb.append(placeHolder);
                        }
                        sb.append("|");
                        for (int k = 0; k < countPlaceHolder - countPlaceHolder/2 - 1; k++) {
                            sb.append(placeHolder);
                        }

                        for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder; k++) {
                            sb.append(placeHolder);
                        }
                    } else {
                        for (int k = 0; k < countPlaceHolder; k++) {
                            sb.append(placeHolder);
                        }
                        for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder; k++) {
                            sb.append(placeHolder);
                        }
                    }
                } else {
                    for (int k = 0; k < countPlaceHolder * 2; k++) {
                        sb.append(placeHolder);
                    }
                    for (int k = 0; k < countRowPlaceHolders[i+1]*countPlaceHolder * 2; k++) {
                        sb.append(placeHolder);
                    }
                }
            }
            downLincStrings[i] = sb.toString();
        }
        return downLincStrings;
    }
    private static String[] combineStings(String[] newRowPlaceHolders, String[] rowStrings, String[] upLincStrings, String[] downLincStrings, int countTreeLevels){
        String[] treeStringArray = new String[countTreeLevels*3-2];
        String[] rowStringWhitNewRowPlaceHolders = new String[countTreeLevels];
        String[] upLincStringWhitNewRowPlaceHolders = new String[countTreeLevels - 1];
        String[] downLincStringWhitNewRowPlaceHolders = new String[countTreeLevels - 1];
        for (int i = 0; i < rowStringWhitNewRowPlaceHolders.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(newRowPlaceHolders[i]);
            sb.append(rowStrings[i]);
            rowStringWhitNewRowPlaceHolders[i] = sb.toString();
        }
        for (int i = 0; i < upLincStrings.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(newRowPlaceHolders[i+1]);
            sb.append(upLincStrings[i]);
            upLincStringWhitNewRowPlaceHolders[i] = sb.toString();
        }
        for (int i = 0; i < downLincStrings.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(newRowPlaceHolders[i+1]);
            sb.append(downLincStrings[i]);
            downLincStringWhitNewRowPlaceHolders[i] = sb.toString();
        }
        for (int i = 0, j = 0; i < treeStringArray.length - 1; i += 3, j++ ) {
            treeStringArray[i] = rowStringWhitNewRowPlaceHolders[j];
            treeStringArray[i+1] = upLincStringWhitNewRowPlaceHolders[j];
            treeStringArray[i+2] = downLincStringWhitNewRowPlaceHolders[j];
        }
        treeStringArray[treeStringArray.length - 1] = rowStringWhitNewRowPlaceHolders[rowStringWhitNewRowPlaceHolders.length - 1];

        return treeStringArray;
    }

    /**
     * Считает колличество нод в дереве
     */
    public static int getCountTreeNods(Tree tree) {
        return getCountTreeNods(tree.root);
    }
    private static int getCountTreeNods(Node node){
        if (node == null) return 0;
        return  1 + getCountTreeNods(node.leftChild) + getCountTreeNods(node.rightChild);
    }

    /**
     * Проверяет сбалансировано ли дерево:
     * вычисляет фактическое колличество нот в дереве
     * вычисляет нормативное колличество уровней при данном числе нод
     * вычисляет фактическое колличество уровней в данном дереве
     * сравнивает нормативное колличество уровней с фактическим
     */
    public static boolean isBalanced(Tree tree){
        int factCountNod = getCountTreeNods(tree.root);
        int normCountTreeLevels = getNormCountTreeLevels(factCountNod);
        int factCountTreeLevels = getCountTreeNods(tree.root);
        return factCountTreeLevels <= normCountTreeLevels;
    }

    public static Tree[] build (int numberOfTrees, int numberOfLevel, int minValueOfNode, int maxValueOfNode) {
        Tree[] trees = new Tree[numberOfTrees];
        int numberOfNode = (int) Math.pow(2, numberOfLevel) - 1;
        for (int i = 0; i < numberOfTrees; i++) {
            Tree tree = new Tree();
            for (int j = 0; j < numberOfNode; j++) {
                tree.insert(getRndNumber(minValueOfNode, maxValueOfNode));
            }
            trees[i] = tree;
        }
        return trees;
    }


    private static int getRndNumber (int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
