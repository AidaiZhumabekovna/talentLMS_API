package API.controllers;

import API.dataProviders.ConfigReader;
import lombok.Getter;

public class BaseTalentController {
    @Getter
    private final UserController userController;
    public BaseTalentController(){
        this.userController = new UserController(ConfigReader.getProperty("url"));
    }
}
