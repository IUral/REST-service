package models.pojos;


public class Store {

    private Integer id;
    private String brand_name;
    private String model_name;
    private Integer year_created;
    private Integer milage;
    private Integer price;

    public Store(Integer id, String brand_name, String model_name, Integer year_created, Integer milage, Integer price) {
        this.id = id;
        this.brand_name = brand_name;
        this.model_name = model_name;
        this.year_created = year_created;
        this.milage = milage;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public Integer getYear_created() {
        return year_created;
    }

    public void setYear_created(Integer year_created) {
        this.year_created = year_created;
    }

    public Integer getMilage() {
        return milage;
    }

    public void setMilage(Integer milage) {
        this.milage = milage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
