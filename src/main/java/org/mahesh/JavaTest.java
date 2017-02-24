package org.mahesh;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Maheshwar Muttal on 2/24/2017.
 */
public class JavaTest {
    public static void main(String[] args) {

        //Difference b/w java.util.Date and java.sql.Date
        Date currentDate = new Date();
        System.out.println(currentDate);
        System.out.println(new Timestamp(currentDate.getTime()));
        System.out.println(new java.sql.Date(currentDate.getTime()));
        System.out.println(new Time(currentDate.getTime()));

    }
}
