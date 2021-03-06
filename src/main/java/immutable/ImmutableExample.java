package immutable;

import java.util.HashMap;
import java.util.Iterator;

/**
 * To create immutable class in java, you have to do following steps.

 1) Declare the class as final so it can’t be extended.
 2) Make all fields private so that direct access is not allowed.
 3) Don’t provide setter methods for variables
 4) Make all mutable fields final so that it’s value can be assigned only once.
 5) Initialize all the fields via a constructor performing deep copy.
 6) Perform cloning of objects in the getter methods to return a copy
    rather than returning the actual object reference.
 */
public final class ImmutableExample {
    private final int id;

    private final String name;

    private final HashMap testMap;

    /**
     * Constructor performing Shallow Copy
     * @param id
     * @param name
     * @param testMap
     */
    public ImmutableExample(int id, String name, HashMap testMap) {
        this.id = id;
        this.name = name;
        this.testMap = testMap;
    }



    /**
     * Constructor performing Deep Copy
     * @param i
     * @param n
     * @param hm
     */

    /*public ImmutableExample(int i, String n, HashMap<String,String> hm){
        System.out.println("Performing Deep Copy for Object initialization");
        this.id = i;
        this.name = n;

        HashMap<String,String> tempMap = new HashMap<String,String>();
        String key;
        Iterator<String> it = hm.keySet().iterator();
        while(it.hasNext()){
            key=it.next();
            tempMap.put(key, hm.get(key));
        }
        this.testMap=tempMap;
    }*/

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap getTestMap() {
        return testMap;
    }

    /**
     * To test the consequences of Shallow Copy and how to avoid it with Deep Copy for creating immutable classes
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String,String>();
        h1.put("1", "first");
        h1.put("2", "second");

        String str = "original";

        int i = 10;

        ImmutableExample ce = new ImmutableExample(i, str, h1);

        //Lets see whether its copy by field or reference
        System.out.println(str == ce.getName());
        System.out.println(h1 == ce.getTestMap());
        //print the ce values
        System.out.println("ce id:"+ce.getId());
        System.out.println("ce name:"+ce.getName());
        System.out.println("ce testMap:"+ce.getTestMap());
        //change the local variable values
        i = 20;
        str = "modified";
        h1.put("3", "third");
        //print the values again
        System.out.println("ce id after local variable change:"+ce.getId());
        System.out.println("ce name after local variable change:"+ce.getName());
        System.out.println("ce testMap after local variable change:"+ce.getTestMap());

        HashMap<String, String> hmTest = ce.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from accessor methods:"+ce.getTestMap());

    }
}
