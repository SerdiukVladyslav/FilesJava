package files.classes.task5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CorporationSystem {

    private static final List<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH = "C:\\Users\\mrser\\Documents\\employees.txt"; // Путь к файлу для сохранения данных

    public static void loadEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String lastName = parts[0].trim();
                int age = Integer.parseInt(parts[1].trim());
                employees.add(new Employee(lastName, age));
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке сотрудников: " + e.getMessage());
        }
    }

    public static void addEmployee() {
        System.out.print("Введите фамилию сотрудника: ");
        String lastName = scanner.nextLine();
        System.out.print("Введите возраст сотрудника: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Чистим буфер
        employees.add(new Employee(lastName, age));
        System.out.println("Сотрудник добавлен.");
    }

    public static void editEmployee() {
        System.out.print("Введите фамилию сотрудника для редактирования: ");
        String lastName = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                System.out.print("Введите новую фамилию: ");
                employee.setLastName(scanner.nextLine());
                System.out.print("Введите новый возраст: ");
                employee.setAge(scanner.nextInt());
                scanner.nextLine(); // Чистим буфер
                System.out.println("Данные сотрудника обновлены.");
                return;
            }
        }
        System.out.println("Сотрудник не найден.");
    }

    public static void removeEmployee() {
        System.out.print("Введите фамилию сотрудника для удаления: ");
        String lastName = scanner.nextLine();
        employees.removeIf(employee -> employee.getLastName().equalsIgnoreCase(lastName));
        System.out.println("Сотрудник удален.");
    }

    public static void searchEmployee() {
        System.out.print("Введите фамилию для поиска: ");
        String lastName = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Сотрудник не найден.");
    }

    public static void filterEmployees() {
        System.out.print("Введите возраст для фильтрации или первую букву фамилии: ");
        String input = scanner.nextLine();

        try {
            int age = Integer.parseInt(input);
            for (Employee employee : employees) {
                if (employee.getAge() == age) {
                    System.out.println(employee);
                }
            }
        } catch (NumberFormatException e) {
            for (Employee employee : employees) {
                if (employee.getLastName().toUpperCase().startsWith(input.toUpperCase())) {
                    System.out.println(employee);
                }
            }
        }
    }

    public static void saveEmployees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee employee : employees) {
                writer.write(employee.getLastName() + ", " + employee.getAge());
                writer.newLine();
            }
            System.out.println("Сотрудники успешно сохранены в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении сотрудников: " + e.getMessage());
        }
    }
}
