package Login;

import DTO.UserDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class LoginController {


    private LoginService loginService;

    @Inject
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

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
        boolean loggedin = loginService.login(userDTO.getUser(), userDTO.getPassword());
        if (loggedin) {
            return Response.status(Response.Status.OK).entity(userDTO).build();
        }
        return Response.status(Response.Status.FORBIDDEN).build();
    }

//
}
