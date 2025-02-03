import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();

        while (true) {
            System.out.println("\n Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View all Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Delete Student by ID");
            System.out.println("6. Delete Student by Name");
            System.out.println("7. Update Student by ID");
            System.out.println("8. Exit Program");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student grades (comma-separated): ");
                    String gradesInput = sc.nextLine();
                    List<Integer> grades = new ArrayList<>();

                    for (String gradeStr : gradesInput.split(",")) {
                        grades.add(Integer.parseInt(gradeStr.trim()));
                    }

                    sm.addStudent(new Student(id, name, grades));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    List<Student> students = sm.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        students.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    Student student = sm.getStudent(sc.nextInt());
                    System.out.println(student != null ? student : "No student found.");
                    break;

                case 4:
                    System.out.print("Enter student name: ");
                    Student studentByName = sm.getStudentByName(sc.nextLine());
                    System.out.println(studentByName != null ? studentByName : "No student found.");
                    break;

                case 5:
                    System.out.print("Enter student ID to delete: ");
                    System.out.println(sm.deleteStudent(sc.nextInt()) ? "Student deleted." : "Student not found.");
                    break;

                case 6:
                    System.out.print("Enter student name to delete: ");
                    System.out.println(sm.deleteStudentByName(sc.nextLine()) ? "Student deleted." : "Student not found.");
                    break;

                case 7:
                    System.out.print("Enter student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new grades (comma-separated): ");
                    String newGrades = sc.nextLine();
                    List<Integer> updatedGrades = new ArrayList<>();
                    for (String grade : newGrades.split(",")) {
                        updatedGrades.add(Integer.parseInt(grade.trim()));
                    }
                    System.out.println(sm.updateStudent(new Student(updateId, newName, updatedGrades)) ? "Student updated." : "Student not found.");
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
