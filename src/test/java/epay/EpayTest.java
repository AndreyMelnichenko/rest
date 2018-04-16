package epay;

import com.hashcode.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EpayTest extends TestBase {
    private static String activationId;
    private static String appKey;

    @Test(priority=1, groups = {"user"})
    public void createUser(){
        CreateUserRK createUserRK = new CreateUserRK("38000"+RandomMinMax.Go(1000000,9999999));
        CreateUserRS actualUser = given()
                .header("Content-Type","application/json")
                .header("Accept-Language", "en")
                .header("User-Agent","JetBeepApp/0.5")
                .header("X-App-ID","35009a79-1a05-49d7-b876-2b884d0f825b")
                .spec(spec).body(createUserRK)
                .expect().statusCode(200)
                .when()
                .post("https://jetbeeptest.easypay.ua:8195/api/appkey/Create")
                .thenReturn().as(CreateUserRS.class);
        activationId=actualUser.getResult().getActivationId();
    }
    @Test(priority=2, groups = {"user"})
    public void activateUser(){
        ActivateUserRK activationUser = new ActivateUserRK(activationId,"0000");
        CreateUserRS actualUser = given()
                .header("Content-Type","application/json")
                .header("Accept-Language", "en")
                .header("User-Agent","JetBeepApp/0.5")
                .header("X-App-ID","35009a79-1a05-49d7-b876-2b884d0f825b")
                .spec(spec).body(activationUser)
                .expect().statusCode(200)
                .when()
                .post("https://jetbeeptest.easypay.ua:8195/api/appkey/Activate")
                .thenReturn().as(CreateUserRS.class);
        appKey=actualUser.getResult().getAppKey();
    }
    @Test(priority = 3, groups = {"user"})
    public void setPin(){
        PinRK pinRK = new PinRK(appKey, "null","123098");
        PinRS setPin = given()
                .header("Content-Type","application/json")
                .header("Accept-Language", "en")
                .header("User-Agent","JetBeepApp/0.5")
                .header("X-App-ID","35009a79-1a05-49d7-b876-2b884d0f825b")
                .spec(spec).body(pinRK)
                .expect().statusCode(200)
                .when()
                .post("https://jetbeeptest.easypay.ua:8195/api/AppKey/Pin/Change")
                .thenReturn().as(PinRS.class);
        System.out.println(setPin.getResult());
    }

    @Test (priority = 4, groups = {"token"})
    public void getToken(){
        
    }

}
