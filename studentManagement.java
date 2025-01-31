import java.io.*;
import java.util.ArrayList;
import java.util.List;

// add students data into the file
public class studentManagement {
    private static final String FILE_NAME = "students.txt";

    //add student
    public void addStudent(Student student) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            String studentData = student.getId() + "," + student.getName() + "," + student.getGrades().toString();
            studentData = studentData.replaceAll("[\\[\\] ]", "");
            bw.write(studentData);
            bw.newLine();
        }
    }

    // get a list of students
    public List<Student> getAllStudents() throws IOException{
        List<Student> students = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];

                //Put the rest of grades into list
                List<Integer> grades = new ArrayList<>();
                for(int i = 2; i < data.length; i++){
                    grades.add(Integer.parseInt(data[i]));
                }
                 //create  a student object  and add it to list
                students.add(new Student(id, name, grades));
            }
        }
        return students;
    }

// get a student by id

    public Student getStudent(int id) throws IOException{
        List<Student> students = getAllStudents();
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

    // get student by name
    public Student getStudentByName(String name) throws IOException{
        List<Student> students  = getAllStudents();
        for(Student student : students){
            if(student.getName() == name){
                return student;
            }
        }
        return null;
    }

    // delete a student by id
    public Student deleteStudent(int id) throws IOException{
        List<Student> students = getAllStudents();
        for(Student student : students){
            if(student.getId() == id){
                students.remove(student);
            }
        }
        return null;
    }

    // delete  student by id
    public void deleteStudentByName(String name) throws IOException{
        List<Student> students = getAllStudents();
        for(Student student :students){
            if(student.getName() == name){
                students.remove(student);
            }
        }
    }

    // update student by id
    public void updateStudent(Student student) throws IOException{
        List<Student> students = getAllStudents();
        for(Student student1 : students){
            if(student1.getId() == student.getId()){
                student1.setName(student.getName());
                student1.setGrades(student.getGrades());
                break;
            }
        }
    }
}







