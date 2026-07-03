import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager =
                new StudentManager();
        int choice;
        do 
        {
            System.out.println("\n===== STUDENT RECORD MANAGER =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View All Students");
            System.out.println("6. View Statistics");
            System.out.println("7. Save Data");
            System.out.println("8. Exit");

            System.out.print("\nEnter choice: ");

            while (!scanner.hasNextInt()) {

                System.out.print(
                        "Invalid input. Enter a number: "
                );
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) 
            {
                case 1:

                    System.out.print(
                            "Enter Roll Number: "
                    );
                    int roll =
                            scanner.nextInt();
                    scanner.nextLine();
                    System.out.print(
                            "Enter Name: "
                    );
                    String name =
                            scanner.nextLine();
                    System.out.print(
                            "Enter Age: "
                    );
                    int age =
                            scanner.nextInt();
                    scanner.nextLine();
                    System.out.print(
                            "Enter Department: "
                    );
                    String department =
                            scanner.nextLine();
                    System.out.print(
                            "Enter CGPA: "
                    );
                    double cgpa =
                            scanner.nextDouble();

                    scanner.nextLine();
                    Student student =
                            new Student(
                                    roll,
                                    name,
                                    age,
                                    department,
                                    cgpa
                            );
                    manager.addStudent(student);

                    break;
                case 2:

                    System.out.print(
                            "Enter Roll Number: "
                    );

                    int searchRoll =
                            scanner.nextInt();
                    scanner.nextLine();

                    manager.viewStudent(
                            searchRoll
                    );
                    break;
                case 3:
                    System.out.print(
                            "Enter Roll Number: "
                    );
                    int updateRoll =
                            scanner.nextInt();
                    scanner.nextLine();
                    System.out.print(
                            "Enter New Name: "
                    );
                    String newName =
                            scanner.nextLine();

                    System.out.print(
                            "Enter New Age: "
                    );
                    int newAge =
                            scanner.nextInt();
                    scanner.nextLine();

                    System.out.print(
                            "Enter New Department: "
                    );

                    String newDepartment =
                            scanner.nextLine();

                    System.out.print(
                            "Enter New CGPA: "
                    );

                    double newCgpa =
                            scanner.nextDouble();
                    scanner.nextLine();
                    manager.updateStudent(
                            updateRoll,
                            newName,
                            newAge,
                            newDepartment,
                            newCgpa
                    );
                    break;

                case 4:
                    System.out.print(
                            "Enter Roll Number: "
                    );

                    int deleteRoll =
                            scanner.nextInt();

                    scanner.nextLine();
                    manager.deleteStudent(
                            deleteRoll
                    );
                    break;

                case 5:
                    manager.viewAllStudents();
                    break;
                case 6:
                    manager.showStatistics();
                    break;

                case 7:
                    manager.saveToFile();
                    break;

                case 8:
                    manager.saveToFile();
                    System.out.println(
                            "\nData saved."
                    );
                    System.out.println(
                            "Goodbye!"
                    );

                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while (choice != 8);
        scanner.close();
    }
}