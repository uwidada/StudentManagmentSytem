import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        studentManagement sm = new studentManagement();

        while (true) {
            System.out.println("\n Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View all Students");
            System.out.println("3. Search student by ID");
            System.out.println("4. Search students by Name");
            System.out.println("5. Exit Program");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter student name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter student grades (separate them with comma):");
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
                        int searchId = sc.nextInt();
                        sc.nextLine();
                        Student foundStudent = sm.getStudent(searchId);

                        if (foundStudent == null) {
                            System.out.println("No student found with ID " + searchId);
                        } else {
                            System.out.println(foundStudent);
                        }
                        break;

                    case 4:
                        System.out.print("Enter student name: ");
                        String searchName = sc.nextLine();
                        Student foundStudents = sm.getStudentByName(searchName);

                        if (foundStudents == null) {
                            System.out.println("No students found with name " + searchName);
                        } else {
                            System.out.println(foundStudents);
                        }
                        break;

                    case 5:
                        System.out.println("Exiting Program...");
                        return;

                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers only for grades.");
            }
        }
    }
}
