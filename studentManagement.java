import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentManagement {
    private static final String FILE_NAME = "students.txt";

    // Add student
    public void addStudent(Student student) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            String studentData = student.getId() + "," + student.getName() + "," + student.getGrades().toString();
            studentData = studentData.replaceAll("[\\[\\] ]", "");
            bw.write(studentData);
            bw.newLine();
        }
    }

    // Get a list of all students
    public List<Student> getAllStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];

                List<Integer> grades = new ArrayList<>();
                for (int i = 2; i < data.length; i++) {
                    grades.add(Integer.parseInt(data[i]));
                }
                students.add(new Student(id, name, grades));
            }
        }
        return students;
    }

    // Get student by ID
    public Student getStudent(int id) throws IOException {
        for (Student student : getAllStudents()) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Get student by name
    public Student getStudentByName(String name) throws IOException {
        for (Student student : getAllStudents()) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    // Delete student by ID
    public boolean deleteStudent(int id) throws IOException {
        List<Student> students = getAllStudents();
        boolean removed = students.removeIf(student -> student.getId() == id);
        writeStudentsToFile(students);
        return removed;
    }

    // Delete student by Name
    public boolean deleteStudentByName(String name) throws IOException {
        List<Student> students = getAllStudents();
        boolean removed = students.removeIf(student -> student.getName().equalsIgnoreCase(name));
        writeStudentsToFile(students);
        return removed;
    }

    // Update student
    public boolean updateStudent(Student updatedStudent) throws IOException {
        List<Student> students = getAllStudents();
        boolean updated = false;

        for (Student student : students) {
            if (student.getId() == updatedStudent.getId()) {
                student.setName(updatedStudent.getName());
                student.setGrades(updatedStudent.getGrades());
                updated = true;
                break;
            }
        }
        writeStudentsToFile(students);
        return updated;
    }

    // Helper method to write students back to file
    private void writeStudentsToFile(List<Student> students) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                String studentData = student.getId() + "," + student.getName() + "," + student.getGrades().toString();
                studentData = studentData.replaceAll("[\\[\\] ]", "");
                bw.write(studentData);
                bw.newLine();
            }
        }
    }
}
