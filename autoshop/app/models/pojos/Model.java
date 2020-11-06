package models.pojos;

public class Model {

    private Integer id;
    private String name;
    private Integer yearStart;
    private Integer yearEnd;

    public Model(Integer id, String name, Integer yearStart, Integer yearEnd) {
        this.id = id;
        this.name = name;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
