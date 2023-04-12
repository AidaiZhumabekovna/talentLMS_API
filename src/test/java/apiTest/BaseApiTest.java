package apiTest;

import API.controllers.BaseTalentController;
import API.controllers.UserController;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

@Slf4j
public class BaseApiTest {

 @BeforeSuite
 public void beforeSuite(){
  log.warn("================== START API TEST===============");
 }

 @AfterSuite
 public void afterSuite(){
  log.warn("================== END API TEST===============");
 }

 protected BaseTalentController talentController = new BaseTalentController();
}
