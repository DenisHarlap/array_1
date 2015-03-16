import com.exadel.lab.Matrix;

public class Main {

    public static void main(String[] args) {
        /*
         * Загрузка массива из файла
         */
        Matrix arrFirst = new Matrix(args[0]);
        /*
         * Создание массива b по заданному условию
         */
        double [] massSecond = arrFirst.newArray();
       /*
        * Вывод в консоль исходного и созданного массива
        */
        arrFirst.print();
        System.out.println("");
        System.out.println("Array b: ");
        for (double  i : massSecond) {
            System.out.printf("%7.3f",i);
        }
    }
}
