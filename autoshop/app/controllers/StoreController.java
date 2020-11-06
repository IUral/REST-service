package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.dto.BrandDto;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.StoreService;
import models.dto.StoreDto;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;


public class StoreController extends Controller {

    @Inject
    private StoreService storeService;

    public Result create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            String brandName = json.get("brand_name").asText().toLowerCase();
            String modelName = json.get("model_name").asText().toLowerCase();
            Integer yearCreated = Integer.parseInt(json.get("year_created").asText());
            Integer milage = Integer.parseInt(json.get("milage").asText());
            Integer price = Integer.parseInt(json.get("price").asText());
            storeService.create(brandName, modelName, yearCreated, milage, price);
            return ok(  "CREATE Model OK");
        }
        return badRequest("Oopsss! record was not created ");
    }

    public Result show(String brandName) {
        List<StoreDto> result = storeService.show(brandName.toLowerCase());
        return ok(Json.toJson(result));
    }

    public Result all() {
        List<StoreDto> result = storeService.all();
        return ok(Json.toJson(result));
    }

    public Result update(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            Integer id = json.get("id").asInt();
            String brandName = json.get("brand_name").asText().toLowerCase();
            String modelName = json.get("model_name").asText().toLowerCase();
            Integer yearCreated = Integer.parseInt(json.get("year_created").asText());
            Integer milage = Integer.parseInt(json.get("milage").asText());
            Integer price = Integer.parseInt(json.get("price").asText());
            storeService.update(id, brandName, modelName, yearCreated, milage, price);
            return ok(  "UPDATE Model - OK");
        }
        return ok("NO");
    }

    public Result delete(String name) {
        storeService.delete(name.toLowerCase());
        return ok("DELETE Model - OK");
    }

}
