package files.classes.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayDataProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод пути к файлу
        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();

        List<int[]> arrays = new ArrayList<>(); // Список для хранения массивов
        int totalSum = 0; // Общая сумма всех массивов
        int overallMax = Integer.MIN_VALUE; // Максимум среди всех массивов
        int overallMin = Integer.MAX_VALUE; // Минимум среди всех массивов

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            // Чтение файла построчно
            while ((currentLine = reader.readLine()) != null) {
                // Разделение строки на элементы массива
                String[] stringElements = currentLine.split(" ");
                int[] array = new int[stringElements.length];
                int sum = 0;
                int max = Integer.MIN_VALUE; // Максимум текущего массива
                int min = Integer.MAX_VALUE; // Минимум текущего массива

                // Преобразование строк в целые числа и вычисление суммы, минимума и максимума
                for (int i = 0; i < stringElements.length; i++) {
                    int number = Integer.parseInt(stringElements[i]);
                    array[i] = number;
                    sum += number; // Суммируем элементы
                    max = Math.max(max, number); // Находим максимум
                    min = Math.min(min, number); // Находим минимум
                }

                arrays.add(array); // Добавляем массив в список
                totalSum += sum; // Добавляем к общей сумме
                overallMax = Math.max(overallMax, max); // Обновляем общий максимум
                overallMin = Math.min(overallMin, min); // Обновляем общий минимум

                // Вывод информации о текущем массиве
                System.out.println("Массив " + (arrays.size()) + ":");
                System.out.println("Элементы: " + arrayToString(array));
                System.out.println("Максимум: " + max);
                System.out.println("Минимум: " + min);
                System.out.println("Сумма: " + sum);
                System.out.println();
            }

            // Вывод общей информации
            System.out.println("Общая сумма всех массивов: " + totalSum);
            System.out.println("Общий максимум: " + overallMax);
            System.out.println("Общий минимум: " + overallMin);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Метод для преобразования массива в строку
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}
