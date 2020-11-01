package service;

import models.dao.BrandDao;
import models.dto.BrandDto;
import javax.inject.Inject;
import java.util.List;


public class BrandService {

    @Inject
    private BrandDao brandDao;

    public void create(String name, String country) {
        brandDao.create(name, country);
    }

    public BrandDto show(String name) {
        return brandDao.show(name);
    }

    public List<BrandDto> all() {
        return brandDao.all();
    }

    public void update(String name, String country) {
        brandDao.update(name, country);
    }

    public void delete(String name) {
        brandDao.delete(name);
    }
}
