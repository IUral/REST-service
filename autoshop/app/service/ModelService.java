package service;

import models.dao.ModelDao;
import models.dto.ModelDto;
import javax.inject.Inject;
import java.util.List;


public class ModelService {

    @Inject
    private ModelDao modelDao;

    public void create(String name, Integer yearStart, Integer yearEnd) {
        modelDao.create(name, yearStart, yearEnd);
    }

    public ModelDto show(String name) {
        return modelDao.show(name);
    }

    public List<ModelDto> all() {
        return modelDao.all();
    }

    public void update(String name, Integer yearStart, Integer yearEnd) {
        modelDao.update(name, yearStart, yearEnd);
    }

    public void delete(String name) {
        modelDao.delete(name);
    }
}