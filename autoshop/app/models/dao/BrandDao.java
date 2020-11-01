package models.dao;

import models.dto.BrandDto;
import java.util.List;

public interface BrandDao {
    public void create(String name, String country);
    public BrandDto show(String name);
    public List<BrandDto> all();
    public void update(String name, String country);
    public void delete(String name);
}
