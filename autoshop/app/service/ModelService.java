package service;

import models.dao.ModelDao;
import models.dto.ModelDto;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


public class ModelService {

    private final DatabaseExecutionContext databaseExecutionContext;

    private final ModelDao modelDao;

    @Inject
    public ModelService(DatabaseExecutionContext databaseExecutionContext, ModelDao modelDao) {
        this.databaseExecutionContext = databaseExecutionContext;
        this.modelDao = modelDao;
    }

    public CompletionStage<String> create(String name, Integer yearStart, Integer yearEnd) {
        return CompletableFuture.supplyAsync(() -> {
            modelDao.create(name, yearStart, yearEnd);
            return "Was created record into Model";
        }, databaseExecutionContext);
    }

    public CompletionStage<ModelDto> show(String name) {
        return CompletableFuture.supplyAsync(() -> modelDao.show(name), databaseExecutionContext);
    }

    public CompletionStage<List<ModelDto>> all() {
        return CompletableFuture.supplyAsync(() -> modelDao.all(), databaseExecutionContext);
    }

    public CompletionStage<String> update(String name, Integer yearStart, Integer yearEnd) {
        return CompletableFuture.supplyAsync(() -> {
            modelDao.update(name, yearStart, yearEnd);
            return "Was update record Model";
        }, databaseExecutionContext);
    }

    public CompletionStage<String> delete(String name) {
        return CompletableFuture.supplyAsync(() -> {
            modelDao.delete(name);
            return "Was delete record Model";
        }, databaseExecutionContext);
    }
}