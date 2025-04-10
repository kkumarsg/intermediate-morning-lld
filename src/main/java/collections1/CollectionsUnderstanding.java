package collections1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsUnderstanding {

    public static void main(String[] args) {

        /*

            Collections

            List, Set, Queue -> Are having some common use cases
            We need a common place to store these common methods.
            => Collections
                All the methods are 'static'
         */

        List<Integer> integers = new ArrayList<>();
        integers.add(4);
        integers.add(2);
        integers.add(0);
        integers.add(8);

        Collections.sort(integers);

        System.out.println(integers);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", 100, 30));
        employees.add(new Employee("2", 200, 31));
        employees.add(new Employee("3", 50, 29));

        Collections.sort(employees);

        System.out.println("employees = " + employees);

        //--------------------------------------------------------------------------------------------------------------


        /*
        Comparator
         */

        List<Employee> employeesNew = new ArrayList<>();
        employeesNew.add(new Employee("1", 100, 29));
        employeesNew.add(new Employee("2", 200, 31));
        employeesNew.add(new Employee("3", 50, 30));

        Collections.sort(employeesNew, new EmployeeAgeComparator());

        System.out.println("employeesNew = " + employeesNew);

        /*
           WHY DO WE NEED TO KNOW BOTH OF THIS ? ...


           Scaler website -> Students
           At one page, we want to sort students based on their age.   -> StudentAgeComparator
                                                          their salary.-> StudentSalaryComparator
                                                          their psp.   -> StudentPspComparator

            1. Place 1
            Collections.sort(students, new StudentAgeComparator());

            2. Place 2
            Collections.sort(students, new StudentSalaryComparator());

            3. Place 4
            Collections.sort(students, new StudentPspComparator());


            4. Place 4
            Collections.sort(students, new StudentXComparator());
         */


        /*

        Place 4
        Collections.sort(students);

                Natural ordering
                Whatever logic you write inside the 'Student' class -> This logic is called as natural order

         */

    }
}
