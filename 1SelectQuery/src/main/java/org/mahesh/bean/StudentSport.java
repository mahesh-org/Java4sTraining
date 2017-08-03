package org.mahesh.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT_SPORT")
public class StudentSport implements Serializable{

    @Id
    @OneToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @OneToOne
    @JoinColumn(name = "SPORT_ID", nullable = false)
    private CategorySports sportId;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CategorySports getSportId() {
        return sportId;
    }

    public void setSportId(CategorySports sportId) {
        this.sportId = sportId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentSport)) return false;

        StudentSport that = (StudentSport) o;

        if (getStudent() != null ? !getStudent().equals(that.getStudent()) : that.getStudent() != null) return false;
        if (getSportId() != null ? !getSportId().equals(that.getSportId()) : that.getSportId() != null) return false;
        return getCategory() != null ? getCategory().equals(that.getCategory()) : that.getCategory() == null;
    }

    @Override
    public int hashCode() {
        int result = getStudent() != null ? getStudent().hashCode() : 0;
        result = 31 * result + (getSportId() != null ? getSportId().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        return result;
    }
}
