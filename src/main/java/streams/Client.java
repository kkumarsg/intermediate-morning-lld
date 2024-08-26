package streams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        Integer totalSum = numbers.stream()
                .reduce(0, (sum, ele) -> sum + ele);

        System.out.println("totalSum = " + totalSum);

        // filter out the numbers divisible by 20
        List<Integer> divisibleBy20 = new ArrayList<>();
        for(Integer number: numbers){
            if(number%20==0){
                divisibleBy20.add(number);
            }
        }

        System.out.println("divisibleBy20 = " + divisibleBy20);

        //------------------------------------------------------
        //             WITH STREAMS
        //------------------------------------------------------

        List<Integer> divisibleBy20UsingStream = numbers.stream()
                .filter(ele -> ele % 20 == 0)
                .collect(Collectors.toList());

        List<Student> students = Arrays.asList(
                new Student("Prem", 20),
                new Student("Indu", 30),
                new Student("Akshit", 25),
                new Student("Gaurav", 40)
        );

        // Double the salary of students whose salary is more than 25LPA
        List<Student> topStudents = students.stream()
                .filter(student -> student.salary > 25)
                .map(student -> new Student(student.name, 2* student.salary))
                .collect(Collectors.toList());

        List<Student> topStudents1 = students.stream()
                .filter(student -> student.salary > 25)
                .map(student -> multipleSalaryBy2(student))
                .collect(Collectors.toList());

        System.out.println("topStudents = " + topStudents);
        System.out.println("topStudents1 = " + topStudents1);

        System.out.println("divisibleBy20UsingStream = " + divisibleBy20UsingStream);
    }

    public static Student multipleSalaryBy2(Student student){
        student.salary = 2*student.salary;
        return student;
    }
}

class Student{
    String name;
    int salary;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Student(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
