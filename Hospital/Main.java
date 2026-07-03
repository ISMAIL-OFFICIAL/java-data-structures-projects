import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalQueue hospital =
                new HospitalQueue();
        int choice;
        do {

            System.out.println("\n===== HOSPITAL EMERGENCY QUEUE SYSTEM =====");

            System.out.println("1. Add Patient");
            System.out.println("2. Treat Next Patient");
            System.out.println("3. View Next Patient");
            System.out.println("4. View All Patients");
            System.out.println("5. Search Patient");
            System.out.println("6. View Statistics");
            System.out.println("7. Save Patients");
            System.out.println("8. Exit");

            System.out.print("\nEnter choice: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name =
                            scanner.nextLine();
                    int age;
                    while (true) {

                        System.out.print("Enter Age: ");
                        if (scanner.hasNextInt()) 
                                {
                            age =
                                    scanner.nextInt();

                            scanner.nextLine();
                            if (age > 0)
                                break;
                        } else {
                            scanner.next();
                        }
                        System.out.println(
                                "Invalid age."
                        );
                    }

                    System.out.print(
                            "Enter Problem: "
                    );

                    String problem =
                            scanner.nextLine();
                    int priority;

                    while (true) 
                        {
                        System.out.println(
                                "\nPriority Levels:"
                        );
                        System.out.println(
                                "1 = Critical"
                        );
                        System.out.println(
                                "2 = Serious"
                        );
                        System.out.println(
                                "3 = Normal"
                        );
                        System.out.print(
                                "Enter Priority: "
                        );
                        if (scanner.hasNextInt()) {
                            priority =
                                    scanner.nextInt();
                            scanner.nextLine();

                            if (priority >= 1
                                    && priority <= 3) 
                                    {
                                break;
                            }
                        } else {
                            scanner.next();
                        }

                        System.out.println(
                                "Priority must be 1, 2, or 3."
                        );
                    }

                    Patient patient =
                            new Patient(
                                    name,
                                    age,
                                    problem,
                                    priority
                            );

                    hospital.addPatient(patient);
                    break;

                case 2:
                    hospital.treatPatient();

                    break;
                case 3:

                    hospital.viewNextPatient();
                    break;
                case 4:

                    hospital.viewAllPatients();

                    break;
                case 5:

                    System.out.print(
                            "Enter patient name: "
                    );

                    String searchName =
                            scanner.nextLine();
                    hospital.searchPatient(
                            searchName
                    );
                    break;

                case 6:

                    hospital.showStatistics();
                    break;
                case 7:

                    hospital.saveToFile();

                    break;

                case 8:
                    hospital.saveToFile();

                    System.out.println(
                            "\nPatients saved."
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