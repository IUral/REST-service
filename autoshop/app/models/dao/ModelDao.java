package models.dao;

import models.dto.ModelDto;
import java.util.List;

public interface ModelDao {
    public void create(String name, Integer yearStart, Integer yearEnd);
    public ModelDto show(String name);
    public List<ModelDto> all();
    public void update(String name, Integer yearStart, Integer yearEnd);
    public void delete(String name);
}
