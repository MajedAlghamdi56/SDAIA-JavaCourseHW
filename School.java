package Day3HW;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class School {
    private List<Student> students;

    public School() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == studentId) {
                students.remove(i);
                break;
            }
        }
    }


    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student.getDetails());
        }
    }


    // Part 3.2
    public void sortByName() {
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
    }

    public Student findByStudentId(int studentId) {
        Student tempStudent = new Student(null, 0, null, studentId, null);

        int index = Collections.binarySearch(students, tempStudent, (s1, s2) -> Integer.compare(s1.getStudentId(), s2.getStudentId()));
        if (index >= 0) {
            return students.get(index);
        } else {
            return null;
        }
    }

    //Part4.1
    public void writeStudentsToFile() {
        try {
            File file = new File("C:\\Users\\dev\\Desktop\\students.txt");
            FileWriter writer = new FileWriter(file);

            for (Student student : students) {
                String line = student.getName() +  "," + student.getAddress() + "," + student.getStudentId();
                writer.write(line + "\n");
            }

            writer.close();

            System.out.println("Students written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    //Part 4.2
    public void readStudentsFromFile() {
        try (FileReader reader = new FileReader("C:\\Users\\dev\\Desktop\\students.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            students.clear();

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] studentDetails = line.split(",");

                // Create a new Student object with the read details
                String name = studentDetails[0];
                int grade = Integer.parseInt(studentDetails[1]);
                String address = studentDetails[2];
                int studentId = Integer.parseInt(studentDetails[3]);
                String email = studentDetails[4];
                Student student = new Student(name, grade, address, studentId, email);

                // Add the student to the list
                students.add(student);
            }

            System.out.println("Students read from the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
