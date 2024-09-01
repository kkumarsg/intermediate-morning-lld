package generics;

import java.util.ArrayList;
import java.util.List;

public class ClientGeneric {

    public static void main(String[] args) {


        List<FriendGeneric<String,Integer>> list = new ArrayList<>();
        FriendGeneric<String, Integer> frindRelation =
                new FriendGeneric<>("keerthi", "Prem", 12);
        list.add(frindRelation);

//        FriendGeneric.something("keerthi");
//        FriendGeneric.something(128);
//        FriendGeneric.something(102.3);

//        FriendGeneric.somethingElse("keerthi", 128);
//        FriendGeneric.somethingElse(1000, 1000);
//
//        FriendGeneric.somethingElseElse(128, 128.8);
        System.out.println("FriendGeneric.somethingWithReturn(\"Keerhti\") = " + FriendGeneric.somethingWithReturn("Keerhti"));
    }
}
