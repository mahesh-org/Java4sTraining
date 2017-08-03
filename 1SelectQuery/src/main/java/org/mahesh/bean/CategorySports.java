package org.mahesh.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORY_SPORTS")
public class CategorySports implements Serializable {

    @Id
    @Column(name = "SPORT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sportId;

    @Column(name = "SPORT_NAME", length = 50)
    private String sportName;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
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
        if (!(o instanceof CategorySports)) return false;

        CategorySports that = (CategorySports) o;

        if (getSportId() != null ? !getSportId().equals(that.getSportId()) : that.getSportId() != null) return false;
        if (getSportName() != null ? !getSportName().equals(that.getSportName()) : that.getSportName() != null)
            return false;
        return getCategory() != null ? getCategory().equals(that.getCategory()) : that.getCategory() == null;
    }

    @Override
    public int hashCode() {
        int result = getSportId() != null ? getSportId().hashCode() : 0;
        result = 31 * result + (getSportName() != null ? getSportName().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        return result;
    }
}
