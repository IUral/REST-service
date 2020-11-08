package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.ModelService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


public class ModelController extends Controller {

    // получения исполнителя для текущего контекста HTTP
    private final HttpExecutionContext httpExecutionContext;

    private final ModelService modelService;

    @Inject
    public ModelController(HttpExecutionContext httpExecutionContext, ModelService modelService) {
        this.httpExecutionContext = httpExecutionContext;
        this.modelService = modelService;
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            String name = json.get("name").asText().toLowerCase();
            Integer yearStart = Integer.parseInt(json.get("yearStart").asText());
            Integer yearEnd = Integer.parseInt(json.get("yearEnd").asText());
            return modelService.create(name, yearStart, yearEnd)
                    .thenApplyAsync(model -> ok(model), httpExecutionContext.current());
        }
        return CompletableFuture.completedFuture(badRequest("Was NOT created record into Model"));
    }

    public CompletionStage<Result> show(String name) {
        return modelService.show(name.toLowerCase())
                .thenApplyAsync(model -> ok(Json.toJson(model)), httpExecutionContext.current());
    }

    public CompletionStage<Result> all() {
        return modelService.all().thenApplyAsync(modelDtos -> ok(Json.toJson(modelDtos)), httpExecutionContext.current());
    }

    public CompletionStage<Result> update(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            String name = json.get("name").asText().toLowerCase();
            Integer yearStart = Integer.parseInt(json.get("yearStart").asText());
            Integer yearEnd = Integer.parseInt(json.get("yearEnd").asText());
            return modelService.update(name, yearStart, yearEnd)
                    .thenApplyAsync(model -> ok(model), httpExecutionContext.current());
        }
        return CompletableFuture.completedFuture(badRequest("Was NOT updated record into Model"));
    }

    public CompletionStage<Result> delete(String name) {
        return modelService.delete(name.toLowerCase())
                .thenApplyAsync(model -> ok(model), httpExecutionContext.current());
    }

}
