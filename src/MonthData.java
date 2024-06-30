public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth(){
        for (int i = 0; i < days.length; i++){
            System.out.printf("%d день: %d \n", i+1, days[i]);
        }
    }

    int sumStepsFromMonth(){
        int sumSteps = 0;
        for (int day : days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    int maxSteps(){
        int maxElement = -1;
        for (int day : days){
            if (day > maxElement){
                maxElement = day;
            }
        }
        return maxElement;
    }

    int bestSeries(int goalByStepsPerDay){
        int counter = 0;
        int maxSeries = 0;
        for (int day : days){
            if (day >= goalByStepsPerDay){
                counter++;
            }
            else{
                if (counter > maxSeries){
                    maxSeries = counter;
                }
            }
        }
        return maxSeries;
    }
}

