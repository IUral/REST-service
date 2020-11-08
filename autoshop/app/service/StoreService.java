package service;

import models.dao.StoreDao;
import models.dto.StoreDto;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


public class StoreService {

    private final DatabaseExecutionContext databaseExecutionContext;

    private final StoreDao storeDao;

    @Inject
    public StoreService(final StoreDao storeDao, final DatabaseExecutionContext datavaseExecutionContext) {
        this.storeDao = storeDao;
        this.databaseExecutionContext = datavaseExecutionContext;
    }

    public CompletionStage<String> create(String brand_name, String model_name, Integer year_created, Integer milage, Integer price) {
        return CompletableFuture.supplyAsync(() -> {
            storeDao.create(brand_name, model_name, year_created, milage, price);
            return "Was created record into Store";
        }, databaseExecutionContext);
    }

    public CompletionStage<List<StoreDto>> show(String country) {
        return CompletableFuture.supplyAsync(() -> storeDao.show(country), databaseExecutionContext);
    }

    public CompletionStage<List<StoreDto>> all() {
        return CompletableFuture.supplyAsync(() -> storeDao.all(), databaseExecutionContext);
    }

    public CompletionStage<String> update(Integer id, String brand_name, String model_name, Integer year_created, Integer milage, Integer price) {
        return CompletableFuture.supplyAsync(() -> {
            storeDao.update(id, brand_name, model_name, year_created, milage, price);
            return "Was update record Store";
        }, databaseExecutionContext);
    }

    public CompletionStage<String> delete(String name) {
        return CompletableFuture.supplyAsync(() -> {
            storeDao.delete(name);
            return "Was delete record Store";
        }, databaseExecutionContext);
    }
}
