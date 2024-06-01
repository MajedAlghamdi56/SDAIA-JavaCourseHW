package Day3HW;

public class Student extends Person implements ComparableById{
    private int studentId;
    private String course;

    public Student(String name, int age, String address, int studentId, String course) {
        super(name, age, address);
        setStudentId(studentId);
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId < 0) {
            throw new IllegalArgumentException("Student ID must be a positive integer.");
        }
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId + ", Course: " + course;
    }
//part 2.1
    @Override
    public String getDetails() {
        return super.getDetails() + ", Student ID: " + getStudentId() + ", Course: " + getCourse();
    }
//part 2.2
    @Override
    public boolean compareById(int id) {
        return getStudentId() == id;
    }
}