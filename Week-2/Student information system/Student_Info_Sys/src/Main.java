public class Main {
    public static void main(String[] args) {
        // Creating teachers
        Teacher t1 = new Teacher("Mahmut", "HIS", "555");
        Teacher t2 = new Teacher("Ayşe", "PHY", "0000");
        Teacher t3 = new Teacher("Fatma", "BIO", "1111");

        // Creating courses and assigning teachers to each course
        Course history = new Course("History", "101", "HIS");
        history.addTeacher(t1);
        Course physics = new Course("Physics", "102", "PHY");
        physics.addTeacher(t2);
        Course biology = new Course("Biology", "103", "BIO");
        biology.addTeacher(t3);

        // Creating students, assigning three courses to each student, and entering grades
        Student s1 = new Student("Alex", "001", "4", history, physics, biology);
        s1.addBulkExamNote(85, 90, 78, 92, 88, 95); // Entering exam and verbal grades
        s1.isPass(); // Checking pass status

        Student s2 = new Student("Emily", "002", "4", history, physics, biology);
        s2.addBulkExamNote(72, 88, 95, 60, 75, 82); // Entering exam and verbal grades
        s2.isPass(); // Checking pass status
    }
}
