package com.select.table;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ann on 30.11.19.
 */
public class Application {
    public static void main(String... arg){
        MySelf();
        System.out.println();

        NotMySelf();
    }

    private static void MySelf(){
        List<String> list = Arrays.asList(
                "1111111111111", "2ddddddddddd2", "333",
                "4444", "55555", "666666",
                "7777777", "88888888", "999999999",
                "1111111111111", "2ddddddddddddddddd2", "333",
                "4444", "55555", "666666",
                "7777777", "88888888", "999999999",
                "1111111111111", "2ddddddddddd2", "333",
                "4444", "55555", "666666",
                "7777777", "88888888", "999999999",
                "1111111111111", "2ddddddddddddddddddddddddddddd2", "333",
                "4444", "55555", "666666",
                "7777777", "88888888", "999999999",
                "1111111111111", "2ddddddddddd2", "333",
                "4444", "55555", "666666",
                "7777777", "88888888", "999999999",
                "1111111111111", "2ddddddddddddddddd2", "333",
                "4444", "55555", "666666",
                "7777777", "88888888", "999999999");

        int countColumn = 6;
        int columnNumber = 0;

        int[] arrayMaxValueColumn = new int[countColumn];
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; list.size() - 1 >= i; i++) {
            if (i == 0) {
                for (int j = 0; list.size() - 1 >= j; j += countColumn) {
                    for (int g = 0; arrayMaxValueColumn.length - 1 >= g; g++) {
                        if (j + g > list.size() - 1) break;
                        arrayMaxValueColumn[g] = list.get(j + g).length() > arrayMaxValueColumn[g] ? list.get(j + g).length() : arrayMaxValueColumn[g];
                    }
                }
            }
            if (i != 0 && i % countColumn == 0) {
                stringBuilder.append("\n");
                columnNumber = 0;
            }
            int p = 0;

            for (int g = 0; arrayMaxValueColumn.length - 1 >= g; g++) {
                p = arrayMaxValueColumn[columnNumber] - list.get(i).length();
            }
            columnNumber++;
            stringBuilder.append(list.get(i));
            while (p >= 0) {
                p--;
                stringBuilder.append(" ");
            }
        }
        System.out.println(stringBuilder);
    }

    private static void NotMySelf(){
        List<String> list = Arrays.asList(
                "11111", "22222222", "33333333", "444",
                "11", "222", "3333", "4444444",
                "11111111", "222222", "33333333", "4",
                "1", "2222222222", "3", "44444444444444"
        );

        int columns = 4;
        int[] columnLength = new int[columns];
        String split = "   ";

        for (int i = 0; i < list.size(); i++) {
            int currWordLength = list.get(i).length();

            if (currWordLength > columnLength[i % columns]) {
                columnLength[i % columns] = currWordLength;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i != 0 && i % columns == 0)
                System.out.println();

            String word = list.get(i);
            System.out.print(word);

            for (int k = 0; k < columnLength[i % columns] - word.length(); k++) {
                System.out.print(" ");
            }
            if (i % columns != 0) // removes split after last column
                System.out.print(split);
        }

        // expected output
        // 11111      22222222     33333333   444
        // 11         222          3333       4444444
        // 11111111   222222       33333333   4
        // 1          2222222222   3          44444444444444
    }
}
