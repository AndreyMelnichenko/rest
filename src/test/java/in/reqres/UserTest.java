package in.reqres;

import XML.People;
import XML.PersonUtil;
import XML.UserXml;
import com.hashcode.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class UserTest extends TestBase {
    String urlUser = "https://reqres.in/api/users/4";

    @Test
    public void checkUser(){
        SingleUser actualUser = given().spec(spec)
                .expect().statusCode(200)
                .when()
                .get(urlUser)
                .thenReturn().as(SingleUser.class);
        assertEquals(actualUser.getData().getFirstName(), "Eve");
    }

    @Test
    public void postUser(){
        User expectedUser = new User("Andrii", "Melnychenko");
        User actualUser = given().spec(spec)
                .body(expectedUser)
                .expect().statusCode(201)
                .when()
                .post("https://reqres.in/api/users")
                .thenReturn().as(User.class);
        assertEquals(expectedUser, actualUser);
        assertNotNull(actualUser.getId());
        assertNotNull(actualUser.getCreatedAt());
    }

    @Test
    public void putUser(){
        UpdateUser expectedUser = new UpdateUser("Andrii", "Melnychenko");
        UpdateUser actualUser = given().spec(spec)
                .body(expectedUser)
                .expect().statusCode(200)
                .when()
                .put("https://reqres.in/api/users/2")
                .thenReturn().as(UpdateUser.class);
        assertEquals(expectedUser,actualUser);
        assertNotNull(actualUser.getUpdatedAt());
    }

    @Test
    public void getUsers(){
        Users actualUsers = given().spec(spec)
                .expect()
                .statusCode(200)
                .when()
                .get("https://reqres.in/api/users?pages=2")
                .thenReturn().as(Users.class);
        Data dataExpected = DataUtil.getData("2", "Janet", "Weaver",
                "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");

        boolean matched = false;
        for(Data data:actualUsers.getData()){
            matched=data.equals(dataExpected);
            if (matched){
                break;
            }
        }
        assertTrue(matched);
    }

    @Test
    public void patchUser(){
        UpdateUser expectedUser = new UpdateUser("morpheus", "zion resident");
        User actualUser = given().spec(spec)
                .body(expectedUser)
                .expect()
                .statusCode(200)
                .when()
                .patch("https://reqres.in/api/users/2")
                .thenReturn().as(User.class);
    }

    @Test
    public void getUserXml(){
        UserXml expectedUser = given().spec(spec)
                .expect().statusCode(200)
                .when()
                .get("http://localhost:8080/service/single-user/xml/1")
                .thenReturn().as(UserXml.class);
        assertEquals(expectedUser.getEmail_field(), "test@hascode.com");

    }

    @Test
    public void getPerson(){
        People actualPeople = given().spec(spec)
                .expect()
                .statusCode(200)
                .when()
                .get("http://localhost:8080/service/persons/xml")
                .thenReturn().as(People.class);
        UserXml expectedPeople = PersonUtil.getUser("20","Sara","Stevens","dev@hascode.com");
        actualPeople.getPeople().get(0);
        boolean matched = false;
        for(UserXml userXml:actualPeople.getPeople()){
            System.out.println("-----------\n"+userXml+"\n--------------");
            System.out.println(expectedPeople);
            matched=userXml.equals(expectedPeople);
            if (matched){
                break;
            }
        }
        assertTrue(matched);
    }
}
