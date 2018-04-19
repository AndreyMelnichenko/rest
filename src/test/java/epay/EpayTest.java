package epay;

import com.hashcode.TestBase;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EpayTest extends TestBase {
    private static String activationId, appKey, uid, pin, accessToken, tokenType, accountNumber;
    private WebDriver driver;
    //private String browser = System.getProperty(CHROME);
    private By acceptKye = By.xpath("//button[@class='btn-green']");


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
        accessToken=getTokenRS.getTokenResultFields().getAccessToken();
        tokenType=getTokenRS.getTokenResultFields().getTokenType();
    }

    @Test(priority = 5, groups = {"token"})
    public void getAccounts(){
        Accounts accounts=given()
                .header("Content-Type","application/json")
                .header("Accept-Language", "en")
                .header("User-Agent","JetBeepApp/0.5")
                .header("X-App-ID",uid)
                .header("Authorization",tokenType+" "+accessToken)
                .spec(spec)
                .expect().statusCode(200)
                .when()
                .get("https://jetbeeptest.easypay.ua:8195/api/Accounts")
                .thenReturn().as(Accounts.class);
        accountNumber=accounts.getResult().get(0).getAccountNumber();
    }

    @Test(priority = 6, groups = {"token"})
    public void getSasMoney() {
        String url ="https://sastest.easypay.ua:8193/payment/card?wallet="+accountNumber+"&amount=1.00";
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(acceptKye).click();
        driver.quit();
        Movements movements = given()
                .header("Content-Type","application/json")
                .header("Accept-Language", "en")
                .header("User-Agent","JetBeepApp/0.5")
                .header("X-App-ID",uid)
                .header("Authorization",tokenType+" "+accessToken)
                .spec(spec)
                .expect().statusCode(200)
                .when()
                .get("https://jetbeeptest.easypay.ua:8195/api/Accounts/"+accountNumber+"/Movements")
                .as(Movements.class);
    }

}
