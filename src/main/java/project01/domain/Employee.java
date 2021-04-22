package project01.domain;

/**
 * 员工
 */
public class Employee {
    private int id;
    private  String name;
    private int age;
    private double salary;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getDetails(){
        return id +  "\t" +
                name + "\t" +
                age + "\t\t" +
                salary
                ;
    }

    @Override
    public String toString() {
        return id +  "\t" +
                name + "\t" +
                age + "\t\t" +
                salary
                ;
    }
}
