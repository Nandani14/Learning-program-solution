// FinancialForecast.java - Predict future values using recursion

import java.util.Scanner;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double predictValue(double currentValue, double growthRate, int years) {
        if (years == 0) return currentValue;

        double nextValue = currentValue + (currentValue * growthRate / 100);
        return predictValue(nextValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter current value: ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter growth rate (in %): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double futureValue = predictValue(currentValue, growthRate, years);
        System.out.printf("\nEstimated value after %d years: ₹%.2f\n", years, futureValue);
    }
}

