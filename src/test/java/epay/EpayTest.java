package epay;

import com.hashcode.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EpayTest extends TestBase {
    private static String activationId;
    private static String appKey;
    private static String uid;
    private static String pin;

    @Test(priority=1, groups = {"user"})
    public void createUser(){
        CreateUserRK createUserRK = new CreateUserRK("38000"+RandomMinMax.Go(1000000,9999999));
        CreateUserRS actualUser = given()
                .header("Content-Type","application/json")
                .header("Accept-Language", "en")
                .header("User-Agent","JetBeepApp/0.5")
                .header("X-App-ID","00000000-0000-0000-0000-000000000000")
                .spec(spec).body(createUserRK)
                .expect().statusCode(200)
                .when()
                .post("https://jetbeeptest.easypay.ua:8195/api/appkey/Create")
                .thenReturn().as(CreateUserRS.class);
        activationId=actualUser.getResult().getActivationId();
        uid=actualUser.getUid();
    }
    @Test(priority=2, groups = {"user"})
    public void activateUser(){
        ActivateUserRK activationUser = new ActivateUserRK(activationId,"0000");
        CreateUserRS actualUser = given()
                .header("Content-Type","application/json")
                .header("Accept-Language", "en")
                .header("User-Agent","JetBeepApp/0.5")
                .header("X-App-ID",uid)
                .spec(spec).body(activationUser)
                .expect().statusCode(200)
                .when()
                .post("https://jetbeeptest.easypay.ua:8195/api/appkey/Activate")
                .thenReturn().as(CreateUserRS.class);
        appKey=actualUser.getResult().getAppKey();
        uid=actualUser.getUid();
    }
    @Test(priority = 3, groups = {"user"})
    public void setPin(){
        pin = "123098";
        PinRK pinRK = new PinRK(appKey, null, pin);
        PinRS setPin = given()
                .header("Content-Type","application/json")
                .header("Accept-Language", "en")
                .header("User-Agent","JetBeepApp/0.5")
                .header("X-App-ID",uid)
                .spec(spec).body(pinRK)
                .expect().statusCode(200)
                .when()
                .post("https://jetbeeptest.easypay.ua:8195/api/AppKey/Pin/Change")
                .thenReturn().as(PinRS.class);
        uid=setPin.getUid();
    }

    @Test (priority = 4, groups = {"token"})
    public void getToken(){
        TokenRK tokenRK = new TokenRK(appKey, pin);
        TokenRS getTokenRS = given()
                .header("Content-Type","application/json")
                .header("Accept-Language", "en")
                .header("User-Agent","JetBeepApp/0.5")
                .header("X-App-ID",uid)
                .spec(spec).body(tokenRK)
                .expect().statusCode(200)
                .when()
                .post("https://jetbeeptest.easypay.ua:8195/api/Token")
                .thenReturn().as(TokenRS.class);
        System.out.println(getTokenRS.getTokenResultFields().getAccessToken());
        System.out.println(getTokenRS.getTokenResultFields().getTokenType());
    }

}
