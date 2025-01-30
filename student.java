import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Integer> grades;

    // Constructor (must be inside the class)
    public Student(int id, String name, List<Integer> grades) {
        this.id = id;
        this.name = name;
        this.grades = grades;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() { // Fix method name
        return grades;
    }
}


