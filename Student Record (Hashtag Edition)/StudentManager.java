import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class StudentManager {

    private HashMap<Integer, Student> students;
    public StudentManager() {
        students = new HashMap<>();
        loadFromFile();
    }
    public void addStudent(Student student) {
        int roll = student.getRollNumber();
        if (students.containsKey(roll)) {
            System.out.println("Student with this roll number already exists.");
            return;
        }
        students.put(roll, student);
        System.out.println("Student added successfully.");
    }
    public void viewStudent(int roll) {
        Student student = students.get(roll);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println(student);
    }
    public void updateStudent(
            int roll,
            String name,
            int age,
            String department,
            double cgpa
    ) {
        Student student = students.get(roll);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        student.setName(name);
        student.setAge(age);
        student.setDepartment(department);
        student.setCgpa(cgpa);
        System.out.println("Student updated successfully.");
    }
    public void deleteStudent(int roll) {
        if (!students.containsKey(roll)) {
            System.out.println("Student not found.");
            return;
        }
        students.remove(roll);
        System.out.println("Student deleted successfully.");
    }
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        Collection<Student> allStudents =
                students.values();
        System.out.println("\n===== STUDENT RECORDS =====");
        for (Student student : allStudents) {
            System.out.println(student);
            System.out.println("-------------------");
        }
    }

    public void showStatistics() 
    {
        int totalStudents = students.size();
        if (totalStudents == 0) {
            System.out.println("No students available.");
            return;
        }
        double highestCgpa = 0;
        String topper = "";
        for (Student student : students.values()) 
            {
            if (student.getCgpa() > highestCgpa) {
                highestCgpa = student.getCgpa();

                topper = student.getName();
            }
        }
        System.out.println("\n===== STATISTICS =====");

        System.out.println("Total Students: "
                + totalStudents);

        System.out.println("Highest CGPA: "
                + highestCgpa);

        System.out.println("Top Student: "
                + topper);
    }
    public void saveToFile() 
    {
        try {

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter(
                                    "students.txt"
                            )
                    );
            for (Student student :
                    students.values()) 
                    {
                writer.println(
                        student.getRollNumber() + "," +
                        student.getName() + "," +
                        student.getAge() + "," +
                        student.getDepartment() + "," +
                        student.getCgpa()
                );
            }
            writer.close();
            System.out.println(
                    "Students saved successfully."
            );
        } catch (IOException e) 
        {
            System.out.println(
                    "Error saving students."
            );
        }
    }
    public void loadFromFile()
     {
        File file =
                new File("students.txt");
        if (!file.exists()) 
            {
            return;
        }

        try 
        {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            while ((line = reader.readLine())
                    != null) {

                String[] parts =
                        line.split(",");
                if (parts.length == 5) 
                    {

                    int roll =
                            Integer.parseInt(parts[0]);
                    String name =
                            parts[1];

                    int age =
                            Integer.parseInt(parts[2]);

                    String department =
                            parts[3];

                    double cgpa =
                            Double.parseDouble(parts[4]);

                    Student student =
                            new Student(
                                    roll,
                                    name,
                                    age,
                                    department,
                                    cgpa
                            );
                    students.put(
                            roll,
                            student
                    );
                }
            }
            reader.close();
        } catch (Exception e) 
        {
            System.out.println(
                    "Error loading students."
            );
        }
    }
}