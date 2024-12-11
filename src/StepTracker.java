import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();
    StepTracker() {
        for (int i = 0; i < monthToData.length; i++){
            monthToData[i] = new MonthData(getDaysInMonth(i)); // массив месяцев
        }
    }

    void addNewNumberStepsPerDay(int month, int day, int steps) {
        MonthData monthData = monthToData[month - 1]; // ссылаемся на существующий объект
        monthData.days[day - 1] = steps; // записываем в день по индексу кол-во шагов
    }

    void changeStepGoal(int steps){
        goalByStepsPerDay = steps;
    }

    int getDaysInMonth(int month){ // не нужно проверять месяц на правильность ввода, тк это происходит в main
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            return 28;
        } else {
            return 31;
        }
    }

    void printStatistic(int month) {
        MonthData monthData = monthToData[month - 1];
        final int sumSteps = monthData.sumStepsFromMonth();
        final int days = getDaysInMonth(month);
        System.out.println("Количество пройденных шагов по дням:");
        monthData.printDaysAndStepsFromMonth();
        System.out.println();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        System.out.println();
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println();
        System.out.println("Среднее количество шагов: " + sumSteps / days);
        System.out.println();
        System.out.println("Пройденная дистанция: " + converter.convertStepsToKm(sumSteps));
        System.out.println();
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println();
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));


    }
}
