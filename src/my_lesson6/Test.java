package my_lesson6;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Tree[] trees = TreeUtil2.build(20, 6, -100, 100);

        TreeUtil2.displayTreeArray(trees[0], "  ");
        System.out.println("фактическое колличество уровней дерева " + TreeUtil2.getCountTreeLevels(trees[0]));
        int countTreeNodes = TreeUtil2.getCountTreeNods(trees[0]);
        System.out.println("фактическое колличество нод дерева " + countTreeNodes);
        System.out.println("нормативное колличество уровней дерева " + TreeUtil2.getNormCountTreeLevels(countTreeNodes));
        int deletedValue = getFirstValueInLastLevel(trees[0]);
        System.out.println("deletedValue " + deletedValue);
        trees[0].delete(deletedValue);
        TreeUtil2.displayTreeArray(trees[0], "  ");
        System.out.println("фактическое колличество уровней дерева " + TreeUtil2.getCountTreeLevels(trees[0]));
        countTreeNodes = TreeUtil2.getCountTreeNods(trees[0]);
        System.out.println("фактическое колличество нод дерева " + countTreeNodes);
        System.out.println("нормативное колличество уровней дерева " + TreeUtil2.getNormCountTreeLevels(countTreeNodes));
        int countTrees = trees.length;
        int countNotBalancedTrees = 0;
        int countBalancedTrees = 0;
        System.out.println("номер дерева | кол-во нод | кол-во уровней | норм кол-во уровней | isBalanced");
        for (int i = 0; i < countTrees; i++) {
            System.out.print("    " + i + "              " + TreeUtil2.getCountTreeNods(trees[i]) + "              " + TreeUtil2.getCountTreeLevels(trees[i]) + "              " + TreeUtil2.getNormCountTreeLevels(TreeUtil2.getCountTreeNods(trees[i])) + "                 ");
            if (!TreeUtil2.isBalanced(trees[i])){
                System.out.print("false");
                countNotBalancedTrees++;
            } else {
                System.out.print("true");
                countBalancedTrees++;
            }
            System.out.println();
        }
        System.out.println("Всего деревьев " + countTrees);
        System.out.println("Колличество не сбалансированных деревьев " + countNotBalancedTrees);
        System.out.println("Процента не сбалансированных деревьев " + countNotBalancedTrees/countNotBalancedTrees*100);

    }

    private static int getFirstValueInLastLevel(Tree tree){
        ArrayList<ArrayList<Integer>> treeArray = TreeUtil2.getTreeArray(tree);
        int deletedValue = 0;
        for (int i = 0; i < treeArray.get(treeArray.size()-1).size(); i++) {
            if (treeArray.get(treeArray.size()-1).get(i) !=null){
                deletedValue = treeArray.get(treeArray.size()-1).get(i);
                break;
            }
        }
        return deletedValue;
    }


}
