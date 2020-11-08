package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.BrandService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


public class BrandController extends Controller {

    // получения исполнителя для текущего контекста HTTP
    private final HttpExecutionContext httpExecutionContext;

    private final BrandService brandService;

    @Inject
    public BrandController(HttpExecutionContext httpExecutionContext, BrandService brandService) {
        this.httpExecutionContext = httpExecutionContext;
        this.brandService = brandService;
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            String name = json.get("name").asText().toLowerCase();
            String country = json.get("country").asText().toLowerCase();
            return brandService.create(name, country)
                    .thenApplyAsync(brand -> ok(brand), httpExecutionContext.current());
        }
        return CompletableFuture.completedFuture(badRequest("Was NOT created record into Brand"));
    }

    public CompletionStage<Result> show(String name) {
        return brandService.show(name.toLowerCase())
                .thenApplyAsync(brand -> ok(Json.toJson(brand)), httpExecutionContext.current());
    }

    public CompletionStage<Result> all() {
        return brandService.all().thenApplyAsync(brandDtos -> ok(Json.toJson(brandDtos)), httpExecutionContext.current());
    }

    public CompletionStage<Result> update(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            String name = json.get("name").asText().toLowerCase();
            String country = json.get("country").asText().toLowerCase();
            return brandService.update(name, country)
                    .thenApplyAsync(brand -> ok(brand), httpExecutionContext.current());
        }
        return CompletableFuture.completedFuture(badRequest("Was NOT updated record into Brand"));
    }

    public CompletionStage<Result> delete(String name) {
        return brandService.delete(name.toLowerCase())
                .thenApplyAsync(brand -> ok(brand), httpExecutionContext.current());
    }



}
