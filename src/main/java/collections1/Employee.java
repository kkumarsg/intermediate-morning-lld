package collections1;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

    private String id;
    private int salary;
    private int age;

    public Employee(String id, int salary, int age) {
        this.id = id;
        this.salary = salary;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee other) {
        /*
            -ve, this object should come before the other object
            +ve, this object should come after the other object
            0, both this and other object are same
         */

        if(this.salary< other.salary){
            return -1;
        }
        if(this.salary> other.salary){
            return 1;
        }
        return 0;
    }
}
