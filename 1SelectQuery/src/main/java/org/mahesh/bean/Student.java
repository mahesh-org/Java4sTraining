package org.mahesh.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "CLASS", length = 100)
    private String className;

    @Column(name = "SECTION", length = 100)
    private String section;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getId() != null ? !getId().equals(student.getId()) : student.getId() != null) return false;
        if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) return false;
        if (getClassName() != null ? !getClassName().equals(student.getClassName()) : student.getClassName() != null)
            return false;
        return getSection() != null ? getSection().equals(student.getSection()) : student.getSection() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getClassName() != null ? getClassName().hashCode() : 0);
        result = 31 * result + (getSection() != null ? getSection().hashCode() : 0);
        return result;
    }
}
