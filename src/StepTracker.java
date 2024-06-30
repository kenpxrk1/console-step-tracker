import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;



    StepTracker(Scanner sc){
        scanner = sc;

        for (int i = 0; i < monthToData.length; i++ ){
            monthToData[i] = new MonthData();
        }
    }

    boolean validateMonthNumber(int monthNumber){
        if (monthNumber <= 12 && monthNumber >= 1){
            return true;
        }
        else{
            System.out.println("Вы ввели некорректный номер месяца.");
            return false;
        }
    }

    boolean validateDayNumber(int dayNumber){
        if (dayNumber <= 30 && dayNumber >= 1){
            return true;
        }
        else {
            System.out.println("Вы ввели некорректный день.");
            return false;
        }
    }

    boolean validateNumberOfSteps(int numberOfSteps){
        if (numberOfSteps > 0){
            return true;
        }
        else{
            System.out.println("Количество шагов не может быть отрицательным");
            return false;
        }
    }

    boolean validateStepsGoal(int stepsGoal){
        if (stepsGoal > 0){
            return true;
        }
        else{
            System.out.println("Цель по количеству шагов должна быть положительным" +
                    "числом больше нуля.");
            return false;
        }
    }

    void addNewNumberStepsPerDay(){
        System.out.println("Введите номер месяца:");
        int monthNumber = scanner.nextInt();
        if (!validateMonthNumber(monthNumber)){
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int dayNumber = scanner.nextInt();
        if (!validateDayNumber(dayNumber)){
            return;
        }

        System.out.println("Введите количество шагов");
        int numberOfSteps = scanner.nextInt();
        if (!validateNumberOfSteps(numberOfSteps)){
            return;
        }

        int dayNumberIndex = dayNumber - 1;
        int monthNumberIndex = monthNumber - 1;
        MonthData monthData = monthToData[monthNumberIndex];
        monthData.days[dayNumberIndex] = numberOfSteps;

    }

    void changeStepGoal(){
        System.out.println("Введите новую цель по шагам за день:");
        int newGoalBySteps = scanner.nextInt();
        boolean newGoalByStepsValidator = validateStepsGoal(newGoalBySteps);
        if (!newGoalByStepsValidator){
            return;
        }
        goalByStepsPerDay = newGoalBySteps;
    }

    void printStatistic(){
        System.out.println("Введите число месяца:");
        int monthNumber = scanner.nextInt();
        if (!validateMonthNumber(monthNumber)){
            return;
        }
        System.out.printf("Вывод статистики за %d месяц.... \n", monthNumber);
        MonthData monthData = monthToData[monthNumber - 1];
        monthData.printDaysAndStepsFromMonth();
        int sumSteps = monthData.sumStepsFromMonth();
        System.out.printf("Сумма шагов за месяц: %d \n", sumSteps);
        System.out.printf("Максимальное количество шагов за месяц: %d \n", monthData.maxSteps());
        System.out.printf("Среднее количество шагов за месяц: %d \n", sumSteps/30);
        System.out.printf("Пройденная дистанция за месяц: %d км. \n",
                converter.convertToKm(sumSteps));
        System.out.printf("Количество сожжённых килокалорий: %d \n",
                converter.convertStepsToKilocalories(sumSteps));
        System.out.printf("Ваша лучшая серия: %d дней \n",
                monthData.bestSeries(goalByStepsPerDay));
    }




}
