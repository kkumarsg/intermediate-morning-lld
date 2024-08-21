package collections;

import java.util.Comparator;

public class StudentComparatorPsp implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if(s1.getPsp()==s2.getPsp()){
            return 0;
        }
        if(s1.getPsp()<s2.getPsp()){
            return -1;
        }
        return 1;
    }
}
