import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class main {
  public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
       studentManagement sm = new studentManagement();

       while (true){
           System.out.print("\n Student management System ");
           System.out.print("1. Add Student");
           System.out.print("2. View all Students");
           System.out.print("3. Search student by ID");
           System.out.print("4. Search students by name");
           System.out.print("5. Exit Program");
           System.out.print("Enter your choice: ");


           //selecting an option by swichting them

           int choice = sc.nextInt();
           sc.nextLine();

           try {
               switch (choice){
                   case 1:
                       System.out.print("enter student id:");
                       int id = sc.nextInt();
                       sc.nextLine();
                       System.out.print("enter student name:");
                       String name = sc.nextLine();
                       sc.nextLine();
                       System.out.print("enter student grades");
                       String grades = sc.nextLine();
                       List<Integer> grades =  new ArrayList<>();

                       for (String grade :grades.split(",")){
                           grades.add(Integer.parseInt(grade));
                       }
                       sm.addStudent(new Student(id,name,grades));
                       System.out.println("Student added successfully");
                       break;

                       case 2:
                           List<student> students = sm.getAllStudents();
                           if (students.isEmpty()){
                               System.out.println("No students found");
                           } else {
                               students.forEach(System.out::println);
                           }
                           break;

                           case 3:
                               System.out.print("enter student id:");
                               int id = sc.nextLine();
                               Student  student = sm.getStudent(id);

                               if(student == null){
                                   System.out.println("no student found  with id " + id);
                               } else {
                                   System.out.println(student);
                               }
                               break;

                               case 4:
                                   System.out.print("enter student name:");
                                   String name = sc.nextLine();
                                   Student students = sm.getStudentByName(name);

                                   if(students == null){
                                       System.out.println("no student found with name " + name);
                                   } else {
                                       students.forEach(System.out::println);
                                   }
                                   break;

                                   case 5:

                                       System.out.println("Exit Program");
                                       break;

                                       default:
                                           System.out.println("Invalid choice");
               }
           } catch (IOException e){
               System.out.println("error got is:" + e.getMessage());
           }
       }
  }
}
