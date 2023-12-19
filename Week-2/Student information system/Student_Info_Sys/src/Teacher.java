public class Teacher {
    String name;    // Name of the teacher
    String branch;  // Branch (subject) the teacher is responsible for
    String mpno;    // Phone number of the teacher

    // Constructor method for the Teacher class
    Teacher(String name, String branch, String mpno) {
        this.name = name;
        this.branch = branch;
        this.mpno = mpno;
    }

    // Method to print the teacher's information
    void print() {
        System.out.println("Name: " + this.name);
        System.out.println("Branch: " + this.branch);
        System.out.println("Phone: " + this.mpno);
    }
}
