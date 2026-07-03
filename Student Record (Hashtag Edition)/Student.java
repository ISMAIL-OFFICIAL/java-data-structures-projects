public class Student {

    private int rollNumber;
    private String name;
    private int age;
    private String department;
    private double cgpa;

    public Student(int rollNumber,
                   String name,
                   int age,
                   String department,
                   double cgpa) 
                   {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.department = department;
        this.cgpa = cgpa;
    }

    public int getRollNumber() 
    {
        return rollNumber;
    }

    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public String getDepartment() 
    {
        return department;
    }

    public double getCgpa() 
    {
        return cgpa;
    }

    public void setName(String name)
     {
    this.name = name;
    }
    public void setAge(int age) 
    {
        this.age = age;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }
    public void setCgpa(double cgpa) 
    {
        this.cgpa = cgpa;
    }
    @Override
    public String toString() {
        return "\nRoll Number: " + rollNumber +
               "\nName: " + name +
               "\nAge: " + age +
               "\nDepartment: " + department +
               "\nCGPA: " + cgpa;
    }
}