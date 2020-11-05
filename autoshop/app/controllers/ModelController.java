package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.ModelService;
import models.dto.ModelDto;

import javax.inject.Inject;
import java.util.List;


public class ModelController extends Controller {

    @Inject
    private ModelService modelService;

    public Result create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            String name = json.get("name").asText().toLowerCase();
            Integer yearStart = Integer.parseInt(json.get("yearStart").asText());
            Integer yearEnd = Integer.parseInt(json.get("yearEnd").asText());
            modelService.create(name, yearStart, yearEnd);
            return ok(  "CREATE Model OK");
        }
        return ok("NO CREATE");
    }

    public Result show(String name) {
        return ok(Json.toJson(modelService.show(name.toLowerCase())));
    }

    public Result all() {
        List<ModelDto> result = modelService.all();
        return ok(Json.toJson(result));
    }

    public Result update(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            String name = json.get("name").asText().toLowerCase();
            Integer yearStart = Integer.parseInt(json.get("yearStart").asText());
            Integer yearEnd = Integer.parseInt(json.get("yearEnd").asText());
            modelService.update(name, yearStart, yearEnd);
            return ok(  "UPDATE Model - OK");
        }
        return ok("NO");
    }

    public Result delete(String name) {
        modelService.delete(name.toLowerCase());
        return ok("DELETE Model - OK");
    }

}
