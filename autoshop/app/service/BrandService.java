package service;

import models.dao.BrandDao;
import models.dto.BrandDto;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


public class BrandService {

    private final DatabaseExecutionContext databaseExecutionContext;

    private final BrandDao brandDao;

    @Inject
    public BrandService(DatabaseExecutionContext databaseExecutionContext, BrandDao brandDao) {
        this.databaseExecutionContext = databaseExecutionContext;
        this.brandDao = brandDao;
    }

    public CompletionStage<String> create(String name, String country) {
        return CompletableFuture.supplyAsync(() -> {
            brandDao.create(name, country);
            return "Was created Brand";
        }, databaseExecutionContext);
    }

    public CompletionStage<BrandDto> show(String name) {
        return CompletableFuture.supplyAsync(() -> brandDao.show(name), databaseExecutionContext);
    }

    public CompletionStage<List<BrandDto>> all() {
        return CompletableFuture.supplyAsync(() -> brandDao.all(), databaseExecutionContext);
    }

    public CompletionStage<String> update(String name, String country) {
        return CompletableFuture.supplyAsync(() -> {
            brandDao.update(name, country);
            return "Was update record Brand";
        }, databaseExecutionContext);
    }

    public CompletionStage<String> delete(String name) {
        return CompletableFuture.supplyAsync(() -> {
            brandDao.delete(name);
            return "Was delete record Brand";
        }, databaseExecutionContext);
    }
}
