package service;

import models.dao.StoreDao;
import models.dto.StoreDto;
import javax.inject.Inject;
import java.util.List;


public class StoreService {

    private final StoreDao storeDao;

    @Inject
    public StoreService(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public void create(String brand_name, String model_name, Integer year_created, Integer milage, Integer price) {
        storeDao.create(brand_name, model_name, year_created, milage, price);
    }

    public List<StoreDto> show(String model_name) {
        return storeDao.show(model_name);
    }

    public List<StoreDto> all() {
        return storeDao.all();
    }

    public void update(Integer id, String brand_name, String model_name, Integer year_created, Integer milage, Integer price) {
        storeDao.update(id, brand_name, model_name, year_created, milage, price);
    }

    public void delete(String name) {
        storeDao.delete(name);
    }
}
