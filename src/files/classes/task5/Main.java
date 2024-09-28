package files.classes.task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CorporationSystem.loadEmployees();
        boolean running = true;

        while (running) {
            System.out.println("\n1. Ввод данных сотрудника");
            System.out.println("2. Редактирование данных сотрудника");
            System.out.println("3. Удаление сотрудника");
            System.out.println("4. Поиск сотрудника по фамилии");
            System.out.println("5. Вывод сотрудников указанного возраста или начинающихся на букву");
            System.out.println("6. Сохранить сотрудников в файл");
            System.out.println("7. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чистим буфер

            switch (choice) {
                case 1:
                    CorporationSystem.addEmployee();
                    break;
                case 2:
                    CorporationSystem.editEmployee();
                    break;
                case 3:
                    CorporationSystem.removeEmployee();
                    break;
                case 4:
                    CorporationSystem.searchEmployee();
                    break;
                case 5:
                    CorporationSystem.filterEmployees();
                    break;
                case 6:
                    CorporationSystem.saveEmployees();
                    break;
                case 7:
                    CorporationSystem.saveEmployees(); // Сохранение перед выходом
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
}
