package API.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    String id;
    String login;
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
    String email;
    @JsonProperty("restrict_email")
    String restrictEmail;
    @JsonProperty("user_type")
    String userType;
    String timezone;
    String language;
    String status;
    @JsonProperty("deactivation_date")
    String deactivationDate;
    String level;
    String points;
    @JsonProperty("created_on")
    String createdOn;
    @JsonProperty("last_updated")
    String lastUpdated;
    @JsonProperty("last_updated_timestamp")
    String lastUpdatedTimestamp;
    String avatar;
    String bio;
    @JsonProperty("login_key")
    String loginKey;
    boolean online;
    String password;

    public String setStatus(String status) {
       return this.status = status;
    }
}