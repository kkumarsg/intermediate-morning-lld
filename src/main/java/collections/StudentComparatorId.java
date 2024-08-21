package collections;

import java.util.Comparator;

public class StudentComparatorId implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {

        if(s1.getId()==s2.getId()){
            return 0;
        }
        if(s1.getId()<s2.getId()){
            return -1;
        }
        return 1;
    }
}
