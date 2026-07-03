import java.util.PriorityQueue;
import java.util.ArrayList;
import java.io.*;
public class HospitalQueue
 {
    private PriorityQueue<Patient> patients;
    public HospitalQueue() 
    {
        patients = new PriorityQueue<>();
        loadFromFile();
    }
    public void addPatient(Patient patient) 
    {
        patients.offer(patient);
        System.out.println("Patient added successfully.");
    }
    public void treatPatient() 
    {
        if (patients.isEmpty()) 
            {
            System.out.println("No patients in queue.");
            return;
        }
        Patient treated = patients.poll();
        System.out.println("\nTreating Patient:");
        System.out.println(treated);
    }
    public void viewNextPatient() 
    {
        if (patients.isEmpty()) {
            System.out.println("No patients waiting.");
            return;
        }
        System.out.println("\nNext Patient:");
        System.out.println(patients.peek());
    }
    public void viewAllPatients() 
    {
        if (patients.isEmpty()) 
            {
            System.out.println("No patients in queue.");
            return;
        }
        ArrayList<Patient> list =
                new ArrayList<>(patients);
        list.sort(null);
        System.out.println("\n===== WAITING PATIENTS =====");
        for (Patient patient : list) 
            {
            System.out.println(patient);
            System.out.println("----------------------");
        }
    }
    public void searchPatient(String name) 
    {
        for (Patient patient : patients) 
            {
            if (patient.getName()
                    .equalsIgnoreCase(name)) 
                {
                System.out.println("\nPatient Found:");
                System.out.println(patient);
                return;
            }
        }
        System.out.println("Patient not found.");
    }
    public void showStatistics() 
    {
        int critical = 0;
        int serious = 0;
        int normal = 0;
        for (Patient patient : patients) 
            {
            switch (patient.getPriority()) 
            {
                case 1:
                    critical++;
                    break;

                case 2:
                    serious++;
                    break;

                case 3:
                    normal++;
                    break;
            }
        }

        System.out.println("\n===== STATISTICS =====");
        System.out.println("Total Patients: " + patients.size());
        System.out.println("Critical: " + critical);
        System.out.println("Serious: " + serious);
        System.out.println("Normal: " + normal);
    }
    public void saveToFile() 
    {
        try {
            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter("patients.txt")
                    );
            for (Patient patient : patients) {
                writer.println(
                        patient.getName() + "," +
                        patient.getAge() + "," +
                        patient.getProblem() + "," +
                        patient.getPriority()
                );
            }
            writer.close();
            System.out.println("Patients saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving file."
            );
        }
    }
    public void loadFromFile() {
        File file = new File("patients.txt");
        if (!file.exists()) 
            {
            return;
        }
        try {
            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;
            while ((line = reader.readLine()) != null) 
                {
                String[] parts =
                        line.split(",");
                if (parts.length == 4) 
                    {
                    String name = parts[0];
                    int age =
                            Integer.parseInt(parts[1]);
                    String problem = parts[2];
                    int priority =
                            Integer.parseInt(parts[3]);
                    Patient patient =
                            new Patient(
                                    name,
                                    age,
                                    problem,
                                    priority
                            );

                    patients.offer(patient);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(
                    "Error loading patients."
            );
        }
    }
}