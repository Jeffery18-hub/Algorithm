/*
test iteration
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class It {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("bob");
        list.add("alice");
        list.add("tom");

//        for (String s : list) {
//            System.out.println(s);
//        }

        Iterator<String> it = list.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
        it.next();
        it.remove();
        System.out.println(it.next());
    }
}


