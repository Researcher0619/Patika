public class Employee {
    String name; // Name and surname of the employee
    double salary; // Salary of the employee
    int workHours; // Weekly working hours
    int hireYear; // Hiring year of the employee

    // Constructor
    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    // Tax calculation method
    double calculateTax() {
        if (this.salary >= 1000) {
            return this.salary * 0.03; // 3% tax on salary if it's 1000 or more
        } else {
            return 0; // No tax if salary is less than 1000
        }
    }

    // Bonus calculation method
    double bonus() {
        int standardWorkHours = 40;
        if (this.workHours > standardWorkHours) {
            return (this.workHours - standardWorkHours) * 30;
        } else {
            return 0; // No bonus if the employee hasn't worked extra hours
        }
    }

    // Raise salary based on years of service
    double raiseSalary() {
        int currentYear = 2021;
        int yearsOfWork = currentYear - this.hireYear;

        if (yearsOfWork < 10) {
            this.salary *= 1.05; // 5% increase if working for less than 10 years
        } else if (yearsOfWork < 20) {
            this.salary *= 1.10; // 10% increase if working for 10 to 19 years
        } else {
            this.salary *= 1.15; // 15% increase if working for 20 or more years
        }

        return this.salary; // Return the updated salary
    }

    // String representation of Employee details
    public String toString() {
        double tax = calculateTax();
        double bonus = bonus();
        double raisedSalary = raiseSalary();
        double totalSalary = salary + bonus - tax + raisedSalary;

        return "Adı: " + name +
                "\nMaaşı: " + salary +
                "\nÇalışma Saati: " + workHours +
                "\nBaşlangıç Yılı: " + hireYear +
                "\nVergi: " + tax +
                "\nBonus: " + bonus +
                "\nMaaş Artışı: " + raisedSalary +
                "\nVergi ve Bonuslar ile birlikte maaş: " + (salary + bonus - tax) +
                "\nToplam Maaş: " + totalSalary;
    }
}
