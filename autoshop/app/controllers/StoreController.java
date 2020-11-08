package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.StoreService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


public class StoreController extends Controller {

    // получения исполнителя для текущего контекста HTTP
    private final HttpExecutionContext httpExecutionContext;

    private final StoreService storeService;

    @Inject
    public StoreController(StoreService storeService, HttpExecutionContext httpExecutionContext) {
        this.storeService = storeService;
        this.httpExecutionContext = httpExecutionContext;
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            String brandName = json.get("brand_name").asText().toLowerCase();
            String modelName = json.get("model_name").asText().toLowerCase();
            Integer yearCreated = Integer.parseInt(json.get("year_created").asText());
            Integer milage = Integer.parseInt(json.get("milage").asText());
            Integer price = Integer.parseInt(json.get("price").asText());
            return storeService.create(brandName, modelName, yearCreated, milage, price)
                    .thenApplyAsync(store -> ok(store), httpExecutionContext.current());
        }
        return CompletableFuture.completedFuture(badRequest("Was NOT created record into Store"));
    }

    public CompletionStage<Result> show(String country) {
        return storeService.show(country.toLowerCase())
                .thenApplyAsync(store -> ok(Json.toJson(store)), httpExecutionContext.current());
    }

    public CompletionStage<Result> all() {
        return storeService.all()
                .thenApplyAsync(store -> ok(Json.toJson(store)), httpExecutionContext.current());
    }

    public CompletionStage<Result> update(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            Integer id = json.get("id").asInt();
            String brandName = json.get("brand_name").asText().toLowerCase();
            String modelName = json.get("model_name").asText().toLowerCase();
            Integer yearCreated = Integer.parseInt(json.get("year_created").asText());
            Integer milage = Integer.parseInt(json.get("milage").asText());
            Integer price = Integer.parseInt(json.get("price").asText());
            return storeService.update(id, brandName, modelName, yearCreated, milage, price)
                    .thenApplyAsync(store -> ok(store), httpExecutionContext.current());
        }
        return CompletableFuture.completedFuture(badRequest("Was NOT updated record into Store"));
    }

    public CompletionStage<Result> delete(String name) {
        return storeService.delete(name.toLowerCase())
                .thenApplyAsync(store -> ok(store), httpExecutionContext.current());
    }

}
