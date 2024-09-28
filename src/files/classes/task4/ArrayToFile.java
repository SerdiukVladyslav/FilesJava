package files.classes.task4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayToFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод пути к файлу
        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();

        // Ввод массива целых чисел
        System.out.println("Введите элементы массива, разделенные пробелом:");
        String[] input = scanner.nextLine().split(" ");
        int[] originalArray = new int[input.length];

        // Преобразование строк в целые числа
        for (int i = 0; i < input.length; i++) {
            originalArray[i] = Integer.parseInt(input[i]);
        }

        // Списки для четных и нечетных значений
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        // Разделение четных и нечетных значений
        for (int num : originalArray) {
            if (num % 2 == 0) {
                evenList.add(num);
            } else {
                oddList.add(num);
            }
        }

        // Перевернутый массив
        int[] reversedArray = new int[originalArray.length];
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }

        // Сохранение данных в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Сохранение оригинального массива
            writer.write(arrayToString(originalArray));
            writer.newLine();
            // Сохранение четных значений
            writer.write(listToString(evenList));
            writer.newLine();
            // Сохранение нечетных значений
            writer.write(listToString(oddList));
            writer.newLine();
            // Сохранение перевернутого массива
            writer.write(arrayToString(reversedArray));
            writer.newLine();

            System.out.println("Данные успешно сохранены в файл.");

        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
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

    // Метод для преобразования списка в строку
    private static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}
