import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Manager ===");

        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter grade for " + name + ": ");
            double grade = -1;
            try {
                grade = Double.parseDouble(sc.nextLine());
                if (grade < 0 || grade > 100) {
                    System.out.println("Grade must be between 0 and 100.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade.");
                continue;
            }

            students.add(new Student(name, grade));
        }

        if (students.isEmpty()) {
            System.out.println("No student data entered.");
        } else {
            double total = 0, highest = -1, lowest = 101;
            String topStudent = "", bottomStudent = "";

            for (Student s : students) {
                total += s.grade;

                if (s.grade > highest) {
                    highest = s.grade;
                    topStudent = s.name;
                }
                if (s.grade < lowest) {
                    lowest = s.grade;
                    bottomStudent = s.name;
                }
            }

            double average = total / students.size();

            System.out.println("\n=== Summary Report ===");
            for (Student s : students) {
                System.out.println(s.name + " - Grade: " + s.grade);
            }
            System.out.printf("\nAverage Grade: %.2f\n", average);
            System.out.println("Highest Grade: " + highest + " (" + topStudent + ")");
            System.out.println("Lowest Grade: " + lowest + " (" + bottomStudent + ")");
        }

        sc.close();
    }
}
