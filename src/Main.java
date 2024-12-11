import java.util.Scanner;

/*  Никита, здравствуйте! Не знаю, насколько позволительно отступать от шагов в ФЗ, но я постаралась доработать
    программу по принципу из видеолекции, где говорили все взаимодействие с пользователем выносить в класс main. Также
    попробовала реализовать изменение в количестве дней в зависимости от месяца.

 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        while (true) {
            printMenu();
            int cmd = scanner.nextInt();
            if (cmd == 1) {
                int month;
                int day;
                int steps;
                // добавила бесконечный цикла для каждого ввода, чтобы в случае ошибки не нужно было вызывать заново
                //команду и опять вводить все пункты
                while (true) {
                    System.out.println("Введите номер месяца");
                    month = scanner.nextInt();
                    if (month < 1 || month > 12) {
                        System.out.println("Номер вводтмого месяца должен быть от 1 до 12");
                    } else {
                        break;
                    }
                }
                while (true) {
                    System.out.println("Введите номер дня");
                    day = scanner.nextInt();
                    int maxDay = stepTracker.getDaysInMonth(month);
                    if (day < 1 || day > maxDay) {
                        System.out.println("Номер вводимого дня должен быть от 1 до " + maxDay);
                    } else {
                        break;
                    }
                }
                while (true) {
                    System.out.println("Введите количество шагов");
                    steps = scanner.nextInt();
                    if (steps <= 0) {
                        System.out.println("Число шагов должно быть положительным числом");
                    } else {
                        break;
                    }
                }
                // аргументы передаются в метод только после того, как мы проверили, что они введены верно
                stepTracker.addNewNumberStepsPerDay(month, day, steps);
            } else if (cmd == 2) {
                System.out.println("Введите цель по количеству шагов");
                int steps = scanner.nextInt();
                while (true) {
                    if (steps <= 0) {
                        System.out.println("Число шагов должно быть положительным числом");
                    } else {
                        break;
                    }
                }
                stepTracker.changeStepGoal(steps);
            } else if (cmd == 3) {
                int month;
                while (true) {
                    System.out.println("Введите номер месяца");
                    month = scanner.nextInt();
                    if (month < 1 || month > 12) {
                        System.out.println("Номер вводтмого месяца должен быть от 1 до 12");
                    } else {
                        break;
                    }
                }
                stepTracker.printStatistic(month);
            } else if (cmd == 4) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Такой команды нет");
            }
            System.out.println();
            System.out.println("-".repeat(20));
            System.out.println();
        }
    }

    static void printMenu() {
        System.out.println("Введите команду");
        System.out.println("1. - Ввести количество шагов за определённый день;");
        System.out.println("2. - Изменить цель по количеству шагов в день");
        System.out.println("3. - Напечатать статистику за определённый месяц");
        System.out.println("4. - Выйти из приложения");
    }
}
