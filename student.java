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

    public List<Integer> getGrades() {
        return grades;
    }

    // calculations of average grades for students

    public  double calculateAverage() {
        if (grades.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();

    }

    //overide to string method
    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", grades: " + grades+ ", average: " + calculateAverage();
    }
}


