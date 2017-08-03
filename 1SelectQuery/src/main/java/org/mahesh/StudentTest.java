package org.mahesh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.mahesh.bean.Category;
import org.mahesh.bean.CategorySports;
import org.mahesh.bean.Student;
import org.mahesh.bean.StudentSport;

/**
 * Created by Maheshwar Muttal on 7/7/2017.
 */
public class StudentTest {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student mahesh = createStudent("Mahesh Muttal");
        Student manju = createStudent("Manju Bangalore");
        Student veeresh = createStudent("Veeresh Adoor");

        Category indoor = createCategory("Indoor");
        Category outdoor = createCategory("Outdoor");

        CategorySports indoorSports = createCategorySports(indoor, "Tennis");
        CategorySports outdoorSports = createCategorySports(outdoor, "Cricket");


        StudentSport maheshSports = createStudentSports(mahesh, indoor, indoorSports);
        StudentSport mahesh2Sports = createStudentSports(mahesh, outdoor, outdoorSports);
        StudentSport manjuSports = createStudentSports(manju, indoor, indoorSports);
        StudentSport veereshSports = createStudentSports(veeresh, outdoor, outdoorSports);

        session.save(mahesh);
        session.save(manju);
        session.save(veeresh);

        session.save(indoor);
        session.save(outdoor);

        session.save(indoorSports);
        session.save(outdoorSports);
        session.getTransaction().commit();

        session.beginTransaction();
        session.save(maheshSports);
        session.getTransaction().commit();

        session.beginTransaction();
        session.save(manjuSports);
        session.getTransaction().commit();

        session.beginTransaction();
        session.save(veereshSports);
        session.getTransaction().commit();

        session.beginTransaction();
        session.save(mahesh2Sports);
        session.getTransaction().commit();

        session.close();

    }

    private static StudentSport createStudentSports(Student student, Category category, CategorySports categorySports) {

        StudentSport studentSport = new StudentSport();
        studentSport.setStudent(student);
        studentSport.setCategory(category);
        studentSport.setSportId(categorySports);

        return studentSport;
    }

    private static CategorySports createCategorySports(Category category, String sportsName) {
        CategorySports cs = new CategorySports();
        cs.setCategory(category);
        cs.setSportName(sportsName);

        return cs;
    }

    private static Category createCategory(String name) {

        Category category = new Category();
        category.setName(name);

        return category;
    }

    private static Student createStudent(String name) {
        Student student = new Student();

        student.setName(name);
        student.setClassName("10th");
        student.setSection("A");

        return student;

    }
}
