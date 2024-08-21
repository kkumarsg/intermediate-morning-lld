package generics;

import constructorChaining.A;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        // Place 1
        List<Friend> friends = new ArrayList<>();
        List<FriendObject> friendObjects1 = new ArrayList<>();

        friendObjects1.add(new FriendObject("Keerthi", "Prem", 5));
        friendObjects1.add(new FriendObject("Keerthi1", "Prem1", 5));
        friendObjects1.add(new FriendObject("Keerthi2", "Prem2", 5));

        friendObjects1.add(new FriendObject(12.3, "SomethingElse", 90000));

        // Place 2
        List<NewFriend> friendsNew = new ArrayList<>();
        friendObjects1.add(new FriendObject(100, 101, "CLOSE"));
        friendObjects1.add(new FriendObject(103, 104, "STRANGERS"));

        // Problems with object type
        friendObjects1.add(new FriendObject(12.3, "SomethingElse", 90000));

        Integer name = (Integer) friendObjects1.get(0).p1;
        System.out.println("name = " + name);

        // This is allowed only for backward compatibility.
        List names = new ArrayList();
        names.add("Keerthi");
        names.add(13.4);


        // primitives with generics not allowed.
         List<Integer> numbers = new ArrayList<>();
    }
}
