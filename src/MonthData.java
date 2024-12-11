public class MonthData {
    int[] days;
    MonthData(int day) {
        days = new int[day];
    }

    void printDaysAndStepsFromMonth(){
        for (int i = 0; i < days.length; i++) {
            if (days[i] != 0) {
                System.out.println((i + 1) + " день: " + days[i]);
            }
        }
    }

    int sumStepsFromMonth(){
        int sum = 0;
        for (int i = 0; i < days.length; i++) {
            sum += days[i];
        }
        return sum;
    }

    int maxSteps(){
        int max = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > max) {
                max = days[i];
            }
        }
        return max;
    }

    int bestSeries(int goalByStepsPerDay){
        int count = 0;
        int bestSerie = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                count++;
                if (count > bestSerie) {
                    bestSerie = count;
                }
            } else {
                count = 0;
            }
        }
        return bestSerie;
    }
}
