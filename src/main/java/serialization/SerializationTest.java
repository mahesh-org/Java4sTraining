package serialization;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
If you want a class object to be serializable, all you need to do it implement the java.io.Serializable interface. Serializable in java is a marker interface and has no fields or methods to implement. It’s like an Opt-In process through which we make our classes serializable.

Serialization in java is implemented by ObjectInputStream and ObjectOutputStream, so all we need is a wrapper over them to either save it to file or send it over the network.
*/
public class SerializationTest {

    public static void main(String[] args) {
        String fileName="employee.ser";
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("Pankaj");
        emp.setSalary(5000);

        Map<Employee, String> myMap = new HashMap<Employee, String>();

        myMap.put(emp, "1");
        //serialize to file
        try {
            SerializationUtil.serialize(emp, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Employee empNew = null;
        try {
            empNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("emp Object::"+emp);
        System.out.println("empNew Object::"+empNew);
    }
}