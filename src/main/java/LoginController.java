import DTO.UserDTO;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class LoginController {


    private LoginService loginService;

    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData(){
        return Response.status(200).entity("jsonObject").build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserDTO userDTO) {
        loginService = new LoginService();
        boolean loggedin = loginService.login(userDTO.getEmail(), userDTO.getPassword());
//        TokenDTO token = loginService.login(jsonObject.getString("user"), jsonObject.getString("password"));
        if (loggedin) {//HEEFT MIJ 4 DAGEN GEDUURT VOORDAT IK DOOR HAD "OH JE MOET 'USER' DOEN IPV 'USERNAME'"
//            tokenDAO.setTokenToUser(jsonObject.getString("user"), token.getToken());
            return Response.status(Response.Status.OK).entity(userDTO).build();
        }
        return Response.status(Response.Status.FORBIDDEN).build();
    }

//    @Inject
//    public void setLoginService(LoginService loginService) {
//        this.loginService = loginService;
//    }
}
