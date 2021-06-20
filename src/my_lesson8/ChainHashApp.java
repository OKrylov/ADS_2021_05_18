package my_lesson8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChainHashApp {
    public static void main(String[] args) throws IOException {
        boolean check1 = true;
        while (check1) {
            boolean check2 = true;
            int keysPerCell = 100;
            int aKey;
            String aValue;
            Value aDataItem;
            int size, n;
            float fillingCoefficient;
            // Ввод исходного размера таблицы
            System.out.print("Enter initial size of table: ");
            size = getInt();
            // Ввод коэффициента заполнения
            System.out.print("Enter fillingCoefficient of table: ");
            fillingCoefficient = getFloat();
            System.out.print("Enter initial number of items: ");
            n = getInt();
            // Создание таблицы
            MyHashTable<Integer, Value> theHashTable = new ChainHashTableImpl<>(size, fillingCoefficient);

            for (int j = 0; j < n; j++)         // Вставка данных
            {
                aKey = (int) (java.lang.Math.random() * keysPerCell * size);
                aValue = getRandomString();
                aDataItem = new Value(aKey, aValue);
                theHashTable.put(aDataItem.getKey(), aDataItem);
            }

            while (check2) {
                System.out.print("Enter first letter of ");
                System.out.print("show, insert, delete, find, create new table, quit: ");
                char choice = getChar();
                switch (choice) {
                    case 's':
                        theHashTable.display();
                        break;
                    case 'i':
                        System.out.print("Enter key value to insert: ");
                        aKey = getInt();
                        aValue = getRandomString();
                        aDataItem = new Value(aKey, aValue);
                        theHashTable.put(aDataItem.getKey(), aDataItem);
                        break;
                    case 'd':
                        System.out.print("Enter key value to delete: ");
                        aKey = getInt();
                        theHashTable.remove(aKey);
                        break;
                    case 'f':
                        System.out.print("Enter key value to find: ");
                        aKey = getInt();
                        ArrayList<Value> aDataItemArr = theHashTable.get(aKey);
                        if (!aDataItemArr.isEmpty())
                            for (int i = 0; i < aDataItemArr.size(); i++) {
                                System.out.println("Found key " + aDataItemArr.get(i).getKey() + ", value " + aDataItemArr.get(i).getValue());
                            }
                        else
                            System.out.println("Could not find " + aKey);
                        break;
                    case 'c':
                        check2 = false;
                        break;
                    case 'q':
                        check2 = false;
                        check1 = false;
                        break;
                    default:
                        System.out.print("Invalid entry\n");
                }
            }
        }

    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static float getFloat() throws IOException {
        String s = getString();
        return Float.parseFloat(s);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    static class Value {
        private int key;
        private String value;

        public Value(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private static String getRandomString() {
        StringBuilder sb = new StringBuilder();
        char ch = (char) (Math.random() * 27 + 97);
        for (int i = 0; i < 4; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
