package threads.synchronised;

public class Value {

    int value;

     synchronized public void incrementer(int i){
        value = value+i;
    }

     synchronized public void decrementer(int i){
        value = value-i;
    }


}
