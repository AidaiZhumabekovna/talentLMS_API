package API.asserts;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.index.qual.PolyUpperBound;

@Slf4j
public class ApiAsserts {
    private Response response;

    public ApiAsserts(Response response) {
        this.response = response;
    }

    public static ApiAsserts assertThatResponse(Response response){
        log.info("Started assert response ..... ");
        return new ApiAsserts(response);
    }

    public ApiAsserts isCorrectHttpStatusCode(Integer expectedStatusCode){
        Assertions.assertThat(this.response.getStatusCode())
                .isEqualTo(expectedStatusCode)
                .withFailMessage("Response code is incorrect, Expected {}, but found {}", this.response.getStatusCode(), expectedStatusCode);
        log.info("Status code is correct: Actual {} Expected {}",this.response.getStatusCode(), expectedStatusCode);
        return this;
    }
    public ApiAsserts fieldOfUser(String value){
        Assertions.assertThat(this.response.body().asPrettyString().contains(value)).isTrue();
        log.info("Response contains {}", value);
        return this;
    }

}
