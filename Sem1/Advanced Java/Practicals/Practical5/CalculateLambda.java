// WAP using lambda expressions in Java to calculate the following.
// 1. Convert Fahrenheit to Celsius.
// 2. Convert Kilometers to Miles.
package Practicals.Practical5;

interface FahrenheitToCelsiusConverter {
    double convert(double fahrenheit);
}

interface KilometersToMilesConverter {
    double convert(double kilometers);
}

public class CalculateLambda {
    public static void main(String[] args) {
        // 1. Convert Fahrenheit to Celsius.
        FahrenheitToCelsiusConverter fahrenheitToCelsius = (fahrenheit) -> (fahrenheit - 32) * 5 / 9;
        System.out.println("Fahrenheit to Celsius: " + fahrenheitToCelsius.convert(98.6));

        // 2. Convert Kilometers to Miles.
        KilometersToMilesConverter kilometersToMiles = (kilometers) -> kilometers * 0.621371;
        System.out.println("Kilometers to Miles: " + kilometersToMiles.convert(100));
    }
}
