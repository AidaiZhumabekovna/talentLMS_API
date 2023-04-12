package API.endpoints;

import API.dataProviders.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class EndPoints {
    public static final String USERS = "users";
    public static final String BRANCHES = "branches";
    public static final String CATEGORIES = "categories";
    public static final String COURSES = "courses";
    public static final String GROUPS = "groups";
    public static final String SYSTEM = "system";
    public static final String EMAIL = "email";
    public static final String IS_USER_ONLINE = "isuseronline";
    public static final String USER_ID = "user_id";
    public static final String USER_SET_STATUS = "usersetstatus";
    public static final String STATUS = "status";
    public static final String API = "api";
    public static final String V1 = "v1";
    public static Map<String, String> BASE_HEADER = new HashMap<>(){
        {
            put("Content-Type", "application/json");
            put("Accept", "*/*");
            put("Host", "nomad.talentlms.com");
            put("Accept-Encoding", "gzip, deflate, br");
            put("Connection", "keep-alive");
        }
    };
}
