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
            System.out.println("5. delete a single student by ID");
            System.out.println("7. Delete student by name");
            System.out.println("8. Update student by ID");
            System.out.println("9. Exit Program");
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
                        System.out.println("Enter student ID: ");
                        int studentId = sc.nextInt();
                        Student deleteStudentById = sm.deleteStudent(studentId);
                        if (deleteStudentById == null) {
                            System.out.println("No student with ID " + studentId);
                        } else {
                            System.out.println(deleteStudentById);
                        }

                        break;
                    case 7:
                        System.out.print("delete student by name: ");
                        String studentName = sc.nextLine();

                        Student deleteStudentByName = sm.getStudentByName(studentName);

                        if (deleteStudentByName == null) {
                            System.out.println("No student with name " + studentName);
                        }else {
                            System.out.println(deleteStudentByName);
                        }
                        break;
                    case 8:
                        System.out.print("update student by by id: ");
                        int sstudentId = sc.nextInt();

                        Student updateStudent = sm.getStudent(sstudentId);
                        if (updateStudent == null) {
                            System.out.println("No student with ID " + sstudentId);
                        }else {
                            System.out.println(updateStudent);
                        }
                        break;

                    case 9:
                        System.out.println("Exit Program");
                        break;

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
