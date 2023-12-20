# Employee Management System

This Java project includes a simple Employee class with functionalities for tax calculation, bonus calculation, and salary raise based on years of service. It also provides a toString method to display employee information.

## Employee Class Features:

- **Tax Calculation:** If the salary is above 1000, a 3% tax is applied.
- **Bonus Calculation:** If the weekly working hours exceed 40, a bonus of 30 TL is applied for each extra hour.
- **Salary Raise:** Based on years of service, with a 5% increase for less than 10 years, 10% for 10 to 19 years, and 15% for 20 or more years.

## Usage Example:

```java
public class Main {
    public static void main(String[] args) {
        // Create an Employee instance
        Employee kemal = new Employee("Kemal", 2000.0, 45, 1985);

        // Display employee information
        System.out.println(kemal.toString());
    }
}
