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
            out.write(Arrays.deepToString(Matrix.multiple(5)).getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



