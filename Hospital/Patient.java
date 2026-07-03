public class Patient implements Comparable<Patient> {

    private String name;
    private int age;
    private String problem;
    private int priority;
    public Patient(String name, int age, String problem, int priority) {
        this.name = name;
        this.age = age;
        this.problem = problem;
        this.priority = priority;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getProblem() {
        return problem;
    }
    public int getPriority() {
        return priority;
    }
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.priority, other.priority);
    }
    @Override
    public String toString() {
        String priorityLevel;
        switch (priority) 
        {
            case 1:
                priorityLevel = "Critical";
                break;
            case 2:
                priorityLevel = "Serious";
                break;
            case 3:
                priorityLevel = "Normal";
                break;
            default:
                priorityLevel = "Unknown";
        }
        return "\nName: " + name +
               "\nAge: " + age +
               "\nProblem: " + problem +
               "\nPriority: " + priorityLevel;
    }
}