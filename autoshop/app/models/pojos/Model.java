package models.pojos;

public class Model {

    private String name;
    private Integer yearStart;
    private Integer yearEnd;

    public Model(String name, Integer yearStart, Integer yearEnd) {
        this.name = name;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearStart() {
        return yearStart;
    }

    public void setYearStart(Integer yearStart) {
        this.yearStart = yearStart;
    }

    public Integer getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(Integer yearEnd) {
        this.yearEnd = yearEnd;
    }
}
