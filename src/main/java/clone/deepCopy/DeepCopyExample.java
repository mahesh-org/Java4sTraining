package clone.deepCopy;

import clone.bean.Programmer;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * First part we have seen how clone method works in Java with a simple example of cloning object, with primitives and Immutable.
 * <p>
 * Now, Clone for mutable (Collection)
 * <p>
 * Use deep copy, if your class contains any mutable field.

 */
public class DeepCopyExample {
    private static final Logger logger = Logger.getLogger(DeepCopyExample.class.getName());

    public static void main(String args[]) throws InterruptedException {
        Programmer javaguru = new Programmer("John", 31);

        javaguru.addCertificates("OCPJP");
        javaguru.addCertificates("OCMJD");
        javaguru.addCertificates("PMP");
        javaguru.addCertificates("CISM");
        javaguru.setCurrentDate(new Date());

        Thread.sleep(2000); //sleep for 1 seconds
        logger.info("Real Java Guru : " + javaguru);
        Programmer clone = javaguru.clone();

        logger.info("Clone of Java Guru : " +  clone);
        //let's add another certification to java guru
        javaguru.addCertificates("Oracle DBA");
        javaguru.setCurrentDate(new Date());
        logger.info("Real Java Guru : " + javaguru);
        logger.info("Clone of Java Guru : " + clone);
    }
}