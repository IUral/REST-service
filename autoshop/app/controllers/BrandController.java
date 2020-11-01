package controllers;

import akka.NotUsed;
import akka.stream.javadsl.Source;
import akka.util.ByteString;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.dto.BrandDto;
import org.mybatis.guice.transactional.Transactional;
import play.core.j.HttpExecutionContext;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.BrandService;

import javax.inject.Inject;
import java.util.List;


public class BrandController extends Controller {

    @Inject
    private BrandService brandService;

    public Result create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            String name = json.get("name").asText();
            String country = json.get("country").asText();
            brandService.create(name, country);
            return ok(  "CREATE OK");
        }
        return ok("NO CREATE");
    }

    public Result show(String name) {
        return ok(Json.toJson(brandService.show(name)));
    }

    public Result all() {
        List<BrandDto> result = brandService.all();
        return ok(Json.toJson(result));
    }

    public Result update(Http.Request request) {
        JsonNode json = request.body().asJson();
        if(json != null) {
            String name = json.get("name").asText();
            String country = json.get("country").asText();
            brandService.update(name, country);
            return ok(  "UPDATE OK");
        }
        return ok("NO");
    }

    public Result delete(String name) {
        brandService.delete(name);
        return ok("DELETE OK");
    }



//    @Transactional
//    public Result all() {
//        Source<ByteString,NotUsed> brands = Source.from(
//                brandService.all()
//        ).fold(ByteString.emptyByteString(),
//            (userByteStringJsonConcatenation, nextBrand) -> userByteStringJsonConcatenation.isEmpty() ?
//                    //First user json
//                    ByteString.fromString(Json.toJson(nextBrand).toString()) :
//                    userByteStringJsonConcatenation.concat(
//                            //Every concatenation has to be separated by comma
//                            ByteString.fromString(", " + Json.toJson(nextBrand).toString())
//                    )
//            ).intersperse(
//                    //Close the concatenation with parentheses to indicate an array of json
//                    ByteString.fromString("["), ByteString.emptyByteString(), ByteString.fromString("]")
//            );
//        return ok().chunked(brands);
//    }


}
