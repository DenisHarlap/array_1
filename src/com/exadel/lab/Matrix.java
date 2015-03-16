package com.exadel.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Denis on 17.02.15.
 */
public class Matrix {

    private double mass[][];
    private int size;

    public Matrix(String filename) {
        File file = new File(filename);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String temp;
            size = Integer.valueOf(bufferedReader.readLine());
            mass = new double[size][size];
            int i = 0;
            while ((temp = bufferedReader.readLine()) != null) {
                String [] arr = temp.split(" ");
                if (arr.length == size){
                    for (int j = 0; j < size; j++, i++)
                        mass[i][j] = Double.valueOf(arr[j]);
                }
                else {
                    System.err.println("Data format is wrong");
                    System.exit(1);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Error on the reading file");
            System.exit(1);
        }
    }

    public Matrix (){}

    public double[][] getMass() {
        return mass;
    }


    public double [] newArray(){
        double [] array = new double[size];
        double min;
        for (int i = 0; i < size; i++){
            min = mass[i][0];
            for (int j = 1; j < size; j++) {
                if (min > mass[i][j])
                    min = mass[i][j];
            }
            for(int j = 0; j < size; j++){
                if (mass[j][i] >= 0)
                    array[i] += mass[j][i];
            }
            array[i] += min;
        }
        return array;
    }

    public void print(){
        System.out.println("Array a: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.printf("%7.3f", mass[i][j]);
            System.out.println("");
        }
    }


}
