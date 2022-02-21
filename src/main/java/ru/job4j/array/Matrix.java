package ru.job4j.array;

import java.io.FileOutputStream;
import java.util.Arrays;

public class Matrix {
    public static int[][] multiple(int size) {
        int[][] rez = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                rez[x][y] = (x + 1) * (y + 1);
            }
        }
        return rez;
    }

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            int[][] rsl = Matrix.multiple(5);
            for (int x = 0; x < rsl.length; x++) {
                for (int y = 0; y < rsl[x].length; y++) {
                    out.write(Integer.toString(rsl[x][y]).getBytes());
                    out.write("   ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



