import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command == 0){
                break;
            }
            else if (command == 1){
                System.out.println("Выполняется команда 1.....");
                stepTracker.addNewNumberStepsPerDay();
            }
            else if (command == 2){
                System.out.println("Выполняется команда 1.....");
                stepTracker.changeStepGoal();
            }
            else if (command == 3){
                System.out.println("Выполняется команда 3.....");
                stepTracker.printStatistic();
            }
            else{
                System.out.println("Вы ввели некорректную команду!");
            }

        }
    }
    static void printMenu(){
        System.out.println("Выберите команду: " +
                "1 - Ввести количество шагов за определенный день. " +
                "2 - Изменить цель по количеству шагов за день" +
                "3 - Напечатать статистику за определенный месяц" +
                "0 - Выйти из приложения");

    }
}