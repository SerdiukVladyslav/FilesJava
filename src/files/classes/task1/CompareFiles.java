package files.classes.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CompareFiles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод путей к файлам
        System.out.println("Введите путь к первому файлу:");
        String path1 = scanner.nextLine();

        System.out.println("Введите путь ко второму файлу:");
        String path2 = scanner.nextLine();

        // Инициализация переменных
        String line1 = null, line2 = null;
        int lineNumber = 1;
        boolean filesAreEqual = true;

        try (BufferedReader reader1 = new BufferedReader(new FileReader(path1));
             BufferedReader reader2 = new BufferedReader(new FileReader(path2))) {

            // Чтение файлов построчно
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    System.out.println("Несовпадение на строке " + lineNumber + ":");
                    System.out.println("Файл 1: " + line1);
                    System.out.println("Файл 2: " + line2);
                    filesAreEqual = false;
                }
                lineNumber++;
            }

            // Проверка, если файлы разной длины
            if (line1 != null || line2 != null) {
                filesAreEqual = false;
                if (line1 != null) {
                    System.out.println("Несовпадающая строка из первого файла на строке " + lineNumber + ": " + line1);
                }
                if (line2 != null) {
                    System.out.println("Несовпадающая строка из второго файла на строке " + lineNumber + ": " + line2);
                }
            }

            if (filesAreEqual) {
                System.out.println("Файлы идентичны.");
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
