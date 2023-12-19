public class Student {
    Course c1;          // Reference to the first course
    Course c2;          // Reference to the second course
    Course c3;          // Reference to the third course
    String name;        // Name of the student
    String stuNo;       // Student number
    String classes;     // Class information
    double average;     // Average grade of the student
    boolean isPass;     // Pass status of the student

    // Constructor method for the Student class
    Student(String name, String stuNo, String classes, Course c1, Course c2, Course c3) {
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;

        // Average and pass status are initially set to 0.0 and false, respectively
        double average = 0.0;
        boolean isPass = false;
    }

    // Method used to add exam notes for the student
    void addBulkExamNote(double note1, double note2, double note3, double sNote1, double sNote2, double sNote3) {
        // Assign the given notes to the respective courses
        if (note1 >= 0 && note1 <= 100)
            this.c1.note = note1;

        if (note2 >= 0 && note2 <= 100)
            this.c2.note = note2;

        if (note3 >= 0 && note3 <= 100)
            this.c3.note = note3;

        if (sNote1 >= 0 && sNote1 <= 100)
            this.c1.sNote = sNote1;

        if (sNote2 >= 0 && sNote2 <= 100)
            this.c2.sNote = sNote2;

        if (sNote3 >= 0 && sNote3 <= 100)
            this.c3.sNote = sNote3;
    }

    // Method to check the pass status of the student
    void isPass() {
        System.out.println("--------------");
        System.out.println(name);

        // Calculate the weighted average of written and verbal exam notes for each course
        double c1 = (this.c1.sNote * 0.20) + (this.c1.note * 0.80);
        double c2 = (this.c2.sNote * 0.20) + (this.c2.note * 0.80);
        double c3 = (this.c3.sNote * 0.20) + (this.c3.note * 0.80);
        this.average = (c1 + c2 + c3) / 3.0;

        printNote();

        // If the average is greater than 55, the student is considered to have passed the class
        if (this.average > 55) {
            System.out.println("Passed the class. ");
            this.isPass = true;
        } else {
            System.out.println("Failed the class. ");
            this.isPass = false;
        }
    }

    // Method to print the student's exam notes
    void printNote() {
        System.out.println(this.c1.name + " Exam Grade: " + this.c1.note + " Verbal Grade: " + this.c1.sNote);
        System.out.println(this.c2.name + " Exam Grade: " + this.c2.note + " Verbal Grade: " + this.c2.sNote);
        System.out.println(this.c3.name + " Exam Grade: " + this.c3.note + " Verbal Grade: " + this.c3.sNote);
        System.out.println("Your Average: " + this.average);
    }
}
