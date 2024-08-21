package collections;

public class Student implements Comparable<Student>{

    private String name;
    private int id;
    private double psp;
    private PaymentStatus paymentStatus;

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Student(String name, int id, double psp) {
        this.name = name;
        this.id = id;
        this.psp = psp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    // sort based on name
    @Override
    public int compareTo(Student other) {
        // return 9, the two objects are considered same
        // if you negative value, this object is smaller than the other object
        // if you positive value, this object is bigger than the other object

        if(this.name.equals(other.name)){
            return 0;
        }
        if(this.name.compareTo(other.name)<0){
            return -1;
        }
        return 1;
    }
}
