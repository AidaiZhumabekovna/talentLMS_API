package API.request;

import API.dataProviders.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
public abstract class ApiRequest {
    protected String URL;
    public Response response;
    protected RequestSpecification requestSpecification;
    protected Map<String, String> headers;
    public static final String SLASH = "/";

    public ApiRequest(String url, Map<String, String> headers){
        this.headers = headers;
        this.URL = url;
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(ConfigReader.getProperty("apiKey"));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(this.URL)
                .setAuth(authScheme)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeaders(this.headers)
                .build();
        requestSpecification.log().all();
    }

    public String getEndpoint(String ...args){
        StringBuilder endPoint = new StringBuilder();
        for(String arg : args){
            endPoint.append(arg).append(SLASH);
        }
        return endPoint.substring(0, endPoint.length() - 1);
    }

    public static String queryFormatParameters(HashMap<String, String> parameters){
        StringBuilder query = new StringBuilder("?");
        for(Map.Entry<String, String> entry : parameters.entrySet()){
            query.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        return query.deleteCharAt(query.length() - 1).toString();
    }

    public static String pathFormatParameters(HashMap<String, String> parameters){
        StringBuilder path = new StringBuilder();
        for (Map.Entry<String, String> entry : parameters.entrySet()){
            path.append(entry.getKey() + ":" + entry.getValue() + ",");
        }
        return path.deleteCharAt(path.length() - 1).toString();
    }

    public ApiRequest logResponse(){
        log.warn("Response is: ");
        log.warn(getResponse().getBody().asString());
        log.warn(String.valueOf(getResponse().getStatusCode()));
        return this;
    }


    public Response get(String endPoint){
        log.info("Perform get response {}", endPoint);
        this.response = RestAssured.given()
                .spec(this.requestSpecification)
                .get(endPoint);
        logResponse();
        return this.response;
    }

    public Response post(String endPoint, String body){
        log.info("Perform post request {}", endPoint);
        this.response = RestAssured.given()
                .spec(this.requestSpecification)
                .post(endPoint);
        logResponse();
        return this.response;
    }
}
