public class Course {
    Teacher teacher;  // Reference to the Teacher object associated with the course
    String name;       // Name of the course
    String code;       // Code of the course
    String prefix;     // Prefix representing the field of the course
    double note;       // General note for the course
    double sNote;      // Special note for the course

    // Constructor method for the Course class
    Course(String name, String code, String prefix) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        double note = 0;  // Initialize general note to 0
        double sNote = 0; // Initialize special note to 0
    }

    // Method to assign a teacher to the course
    void addTeacher(Teacher teacher) {
        this.teacher = teacher;
        // If the teacher's branch matches the course's prefix, assign the teacher to the course
        if (teacher.branch.equals(this.prefix)) {
            this.teacher = teacher;
        } else {
            System.out.println("Teacher and course branches do not match!");
        }
    }

    // Method to print teacher information
    void printTeacher() {
        this.teacher.print();
    }
}
