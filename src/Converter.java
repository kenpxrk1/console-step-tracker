public class Converter {
    int convertToKm(int steps){
        // один шаг = 75 см ->
        // один шаг = 0,75м = 0,00075
        return (steps * 75) / 100000;
    }

    int convertStepsToKilocalories(int steps){
        return (steps * 50) / 1000;
    }
}
