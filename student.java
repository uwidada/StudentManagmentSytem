import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Integer> grades;

    // Constructor
    public Student(int id, String name, List<Integer> grades) {
        this.id = id;
        this.name = name;
        this.grades = grades;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public void addGrade(int grade) {
        if (grades != null) {
            this.grades.add(grade);
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    // Calculate average grade
    public double calculateAverage() {
        if (grades == null || grades.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Override toString method
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grades: " + grades + ", Average: " + calculateAverage();
    }
}
