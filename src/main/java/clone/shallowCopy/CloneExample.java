package clone.shallowCopy;

import org.apache.log4j.Logger;
import clone.bean.Rectangle;

/*
    For more info refer below link
    http://javarevisited.blogspot.in/2013/09/how-clone-method-works-in-java.html
    1) The clone() method is used to create a copy of an object in Java. In order to use clone() method, class must implement java.lang.Cloneable interface and override protected clone() method from java.lang.Object.

        A call to clone() method will result in CloneNotSupportedException if that class doesn't implement Cloneable interface.

    2) Default implementation of clone() method in Java provides "shallow copy" of object, because it creates copy of Object by creating new instance and then copying content by assignment

    3) By convention, clone of an instance should be obtained by calling super.clone() method

    4) A shallow copy of an instance is fine, until it only contains primitives and Immutable objects,
        For Mutable and collection it will refer the same object

    This is First part of cloning with primitive and immutable fields in the Rectangle Object (Shallow Copy)
*/
public class CloneExample {
    private static final Logger logger =  Logger.getLogger(CloneExample.class.getName());

    public static void main(String args[]) {

        Rectangle rec = new Rectangle(30, 60);
        logger.info(rec);

        Rectangle copy = null;
        try {
            logger.info("Creating Copy of this object using Clone method");
            copy = rec.clone();
            logger.info("Copy " + copy);

        } catch (CloneNotSupportedException ex) {
            logger.debug("Cloning is not supported for this object");
        }

        //testing properties of object returned by clone method in Java
        logger.info("copy != rec : " + (copy != rec));
        logger.info("copy.getClass() : " + copy.getClass() + " rec.getClass() : " + rec.getClass());
        logger.info("copy.getClass() == rec.getClass() : " + (copy.getClass() == rec.getClass()));
        logger.info("copy.equals(rec) : " + copy.equals(rec));

        //Updating fields in original object
        rec.setHeight(100);
        rec.setWidth(45);

        logger.info("Original object :" + rec);
        logger.info("Clonned object  :" + copy);

        //Updating fields in copy object
        copy.setHeight(25);
        copy.setWidth(52);

        logger.info("Original object :" + rec);
        logger.info("Clonned object  :" + copy);
    }

}

/*
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

*/

    /*import java.io.IOException;
    import java.util.*;
    import java.util.stream.Collectors;
    import java.util.stream.IntStream;
    import java.util.stream.Stream;

    public class Solution {

        public static class City {
            private int clinics;
            private double population;
            private double number_of_vacinated;

            public City(int clinics, int population) {
                this.clinics = clinics;
                this.population = population;
                this.number_of_vacinated = population / clinics;
            }

            public double getNumberOfVacinated() {
                return number_of_vacinated;
            }

            @Override
            public String toString() {
                return String.format("City{clinics='%s', population=%f, number_of_vacinated=%f}", clinics, population, population/clinics);
            }
        }

        public static void main(String[] args) throws IOException {

            int n = 0; // the number of city
            int b = 0; // the number of clinic

            Scanner in = new Scanner(System.in);

            System.out.println("Enter a number of city and clinics");

            while (in.hasNextLine()) {
                String cityAndClinics = in.nextLine();
                if (cityAndClinics.equals("exit")) {
                    System.exit(0);
                }
                List<String> optionStream = Arrays.stream(cityAndClinics.trim().split("\\s+")).map(s -> s.trim()).collect(Collectors.toList());
                if (1 < optionStream.size() && optionStream.size() < 3) {
                    n = Integer.parseInt(optionStream.size() > 0 ? optionStream.get(0) : "0"); // number of city
                    if (1 <= n && n <= 500000) {

                    } else {
                        System.out.println("Enter a number of city and clinics");
                        System.err.println("The number of city should be between 1 and 500000");
                    }

                    b = Integer.parseInt(optionStream.size() > 1 ? optionStream.get(1) : "0"); // number of clinics
                    if (n <= b && b <= 2000000) {

                    } else {
                        System.out.println("Enter a number of city and clinics");
                        System.err.println("The number of clinics should be between the number of city and 2000000");
                    }

                    System.out.println("city => " + n);
                    System.out.println("clinics => " + b);
                    break;
                } else {
                    System.out.println("Enter a number of city and clinics");
                    System.err.println("The format for city and clinic seems to be wrong. For example 3 4, 3 8, 2 4");
                }
            }

            List<City> cities = new ArrayList<>();

            IntStream.range(0, n).forEach(s -> {
                System.out.println("Enter a number for the city's population : ");
                int population = in.nextInt();
                if ( 1 <= population && population <= 5000000) {
                    cities.add(new City(1, population));
                } else {
                    System.err.println("the population should be between 1 and 5000000");
                    System.exit(1);
                }
            });

            Comparator<City> vacineComparator = Comparator.comparing(City::getNumberOfVacinated);

            IntStream.range(n, b).forEach(s -> {

                System.out.println("iterate => " + s);
                Stream t = cities.stream();
                cities.stream().sorted(vacineComparator.reversed()).findFirst().map(c -> {
                    c.clinics++;
                    c.number_of_vacinated = Math.ceil(c.population / c.clinics);
                    return c;
                });

                t.forEach(System.out::println);
                System.out.println("==================================================================");
            });

            Double maxNum = cities.stream().sorted(vacineComparator.reversed()).findFirst().get().getNumberOfVacinated();
            System.out.println(" The maximum number of people to be immunized in the largest clinic is : " + maxNum);
        }
    }*/
