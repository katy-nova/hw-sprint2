public class Converter {
    private static final int stepsToCentimetres = 75;
    private static final int stepsToCalories = 50;
    private static final int caloriesToKilocalories = 1000;

    int convertStepsToKm(int steps) {
        int metresToKm = 1000;
        int kilometres = steps * stepsToCentimetres / metresToKm;
        return kilometres;
    }

    int convertStepsToKilocalories(int steps){
        int kilocalories = steps * stepsToCalories / caloriesToKilocalories;
        return kilocalories;
    }

}
