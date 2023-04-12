package apiTest;

import API.asserts.ApiAsserts;
import API.controllers.UserController;
import API.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static API.endpoints.EndPoints.*;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;

@Slf4j
public class UserApiTest extends BaseApiTest{
    private UserController userController;
    User[] users;

    @BeforeClass
    public void beforeClass(){
        userController = talentController.getUserController();
    }

    @Test
    public void receiveUsersTest(){
        users =  userController.getUsers().as(User[].class);
        ApiAsserts.assertThatResponse(userController.getResponse())
                .isCorrectHttpStatusCode(HTTP_OK);
//                .fieldOfUser("Aidai");
    }

    @Test(dependsOnMethods = "receiveUsersTest")
    public void receiveUserBy(){
        for (User user : users){
            userController.getUserBy(EMAIL, user.getEmail());
        }
        ApiAsserts.assertThatResponse(userController.getResponse())
                .isCorrectHttpStatusCode(HTTP_OK);
    }

    @Test(dependsOnMethods = "receiveUsersTest")
    public void isUserOnlineTest(){
        int countOfUserOnline = 0;
        String name = null;
        for (User user : users){
            userController.isUserOnline(USER_ID, user.getId());
            ApiAsserts.assertThatResponse(userController.getResponse())
                    .isCorrectHttpStatusCode(HTTP_OK);
            User onlineUsers = userController.getResponse().as(User.class);
            if (onlineUsers.isOnline()){
                name = user.getFirstName();
                countOfUserOnline++;
            }
        }
        log.info("Users online: " + countOfUserOnline +  ", online user name : " +name);
    }

    @Test(dependsOnMethods = "receiveUsersTest")
    public void userSetStatus(){
        for (User user : users){
//            if(!user.getId().equals("1")){
//              userController.userSetStatus()
                System.out.println("iddd " + user.getId());
//            }
        }
        log.info("Status: ");
    }
}
