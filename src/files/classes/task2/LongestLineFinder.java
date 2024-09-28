package files.classes.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LongestLineFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод пути к файлу
        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();

        // Инициализация переменных для хранения самой длинной строки и её длины
        String longestLine = "";
        int maxLength = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            // Чтение файла построчно
            while ((currentLine = reader.readLine()) != null) {
                // Если длина текущей строки больше, чем у предыдущей самой длинной строки
                if (currentLine.length() > maxLength) {
                    maxLength = currentLine.length();  // Обновляем максимальную длину
                    longestLine = currentLine;         // Обновляем самую длинную строку
                }
            }

            // Вывод результата
            System.out.println("Длина самой длинной строки: " + maxLength);
            System.out.println("Сама строка: " + longestLine);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
