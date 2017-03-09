package clone.bean;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Programmer implements Cloneable {
    private static final Logger logger = Logger.getLogger(Programmer.class.getName());
    private String name;
    private int age;
    private List certifications;

    private Date currentDate;

    public Programmer(String name, int age) {
        this.name = name;
        this.age = age;
        this.certifications = new ArrayList();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCertificates(String certs) {
        certifications.add(certs);
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, Certifications: %s, %s",
                name, age, certifications.toString(), currentDate);
    }

    @Override
    public Programmer clone() {
        Programmer clone = null;
        try {
            clone = (Programmer) super.clone();

            /****deep copying ****/
            //Comment this part and check o/p, you can see clone object will have the latest changes for mutable class (certification)
            clone.certifications = new ArrayList(certifications);
        } catch (CloneNotSupportedException cns) {
            logger.error("Error while cloning programmer", cns);
        }
        return clone;
    }


}
