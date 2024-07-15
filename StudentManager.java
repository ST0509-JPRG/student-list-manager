import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StudentManager {
    private ArrayList<Student> students;

    public static final String filepath = "students.out";

    public StudentManager() {
        this.students = new ArrayList<>();

        Student[] deserializedStudents = Serializer.deserialize(filepath);
        if (deserializedStudents == null)
            this.mockData();
        else
            this.students = new ArrayList<Student>(Arrays.asList(deserializedStudents));
    }

    private void mockData() {
        // Create 8 modules
        List<Module> modules = new ArrayList<>();
        modules.add(new Module("CS101", "Introduction to Computer Science", 4));
        modules.add(new Module("MA101", "Calculus I", 3));
        modules.add(new Module("PH101", "Physics I", 3));
        modules.add(new Module("CH101", "Chemistry I", 3));
        modules.add(new Module("EE101", "Electrical Engineering I", 3));
        modules.add(new Module("HS101", "History I", 3));
        modules.add(new Module("EC101", "Economics I", 3));
        modules.add(new Module("BI101", "Biology I", 3));

        // Create 15 students
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            String studentId = "P" + String.format("%03d", i);
            students.add(new Student("Student" + i, studentId, "DIT/FT/2B/02"));
        }

        // Randomly assign 5 modules with scores to each student
        Random random = new Random();
        for (Student student : students) {
            for (int i = 0; i < 5; i++) {
                Module module = modules.get(random.nextInt(modules.size()));
                double score = random.nextInt(101);
                student.addScoredModule(new ScoredModule(score, module));
            }
        }

        // Print out the mock data
        for (Student student : students) {
            System.out.println(student);
        }

        this.students = students;
    }

    public void addStudent(String id, String name, String className) {
        Student newStudent = new Student(name, id, className);
        this.students.add(newStudent);
    }

    public Student[] getStudents() {
        return students.toArray(new Student[0]);
    }
}
