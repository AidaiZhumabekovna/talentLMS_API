package API.controllers;

import API.request.ApiRequest;
import io.restassured.response.Response;

import java.util.HashMap;

import static API.endpoints.EndPoints.*;

public class UserController extends ApiRequest {

    public UserController(String url){
        super(url, BASE_HEADER);
    }

    public Response getUsers(){
        return this.response = super.get(getEndpoint(API, V1, USERS));
    }

    public Response getUserBy(String by, String value){
        HashMap<String, String> entry = new HashMap<>();
        entry.put(by, value);
        return this.response = super.get(getEndpoint(API, V1, USERS, queryFormatParameters(entry)));
    }

    public Response isUserOnline(String key, String value){
        HashMap<String, String> entry = new HashMap<>();
        entry.put(key,value);
        return this.response = super.get(getEndpoint(API, V1, IS_USER_ONLINE,queryFormatParameters(entry)));
    }

    public Response userSetStatus(String value, String value1){
        HashMap<String, String> entry = new HashMap<>();
        entry.put(USER_ID,value);
        entry.put(STATUS, value1);
//        entry.put(status, userStatus);
//        HashMap<String,String> st = new HashMap<>();
//        st.put(key1,value1);
        return this.response = super.get(getEndpoint(API, V1, USER_SET_STATUS,queryFormatParameters(entry)));
    }

}
