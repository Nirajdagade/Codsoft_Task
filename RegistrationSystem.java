import java.util.ArrayList;
import java.util.List;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int availableSlots;

    public Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.availableSlots = capacity;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public boolean registerStudent() {
        if (availableSlots > 0) {
            availableSlots--;
            return true;
        }
        return false;
    }

    public void removeStudent() {
        if (availableSlots < capacity) {
            availableSlots++;
        }
    }
}

class Student {
    private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.registerStudent()) {
            registeredCourses.add(course);
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            course.removeStudent();
            registeredCourses.remove(course);
        }
    }
}

public class RegistrationSystem {
    public static void main(String[] args) {
        Course course1 = new Course("CSE101", "Introduction to Computer Science", "Basic programming and CS concepts", 30);
        Course course2 = new Course("MATH201", "Calculus I", "Limits, derivatives, and integrals", 25);

        Student student1 = new Student("S12345", "Alice");
        Student student2 = new Student("S67890", "Bob");

        student1.registerCourse(course1);
        student1.registerCourse(course2);

        student2.registerCourse(course1);

        student1.dropCourse(course2);

        System.out.println("Student 1's registered courses:");
        for (Course course : student1.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }

        System.out.println("Student 2's registered courses:");
        for (Course course : student2.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
    }
}
