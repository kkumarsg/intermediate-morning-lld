package collections1;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {

        /*
            -ve, o1 should come before the o2
            +ve, o1 should come after the o2
            0, both o1 and o2 are same
         */

        if (o1.getAge() < o2.getAge()) {
            return -1;
        }
        if (o1.getAge() > o2.getAge()) {
            return 1;
        }
        return 0;
    }
}
