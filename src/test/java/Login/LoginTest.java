package Login;

import DTO.UserDTO;
import org.apache.catalina.User;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.mock;


public class LoginTest {

    UserDTO userDTO;

    @BeforeEach
    void setUp() {
        userDTO = new UserDTO();
        userDTO.setUser("martijn");
    }
    @Test
    void loginTestgood() {
        var sut = new LoginController();
        userDTO.setPassword("martijn");
        var loginService = Mockito.mock(LoginService.class);
        Mockito.when(loginService.login(userDTO.getUser(), userDTO.getPassword())).thenReturn(true);
        sut.setLoginService(loginService);
        Response response = sut.login(userDTO);

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    void loginTestbad() {
        var sut = new LoginController();
        userDTO.setPassword("dingen");
        var loginService = Mockito.mock(LoginService.class);
        sut.setLoginService(loginService);
        Response response = sut.login(userDTO);

        Assert.assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus());
    }

    @AfterEach
    void tearDown() {

    }

}
