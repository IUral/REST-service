package models.dao;

import models.dto.StoreDto;
import java.util.List;


public interface StoreDao {
    public void create(String brand_name, String model_name, Integer year_created, Integer milage, Integer price);
    public List<StoreDto> show(String model_name);
    public List<StoreDto> all();
    public void update(String brand_name, String model_name, Integer year_created, Integer milage, Integer price);
    public void delete(String name);
}
