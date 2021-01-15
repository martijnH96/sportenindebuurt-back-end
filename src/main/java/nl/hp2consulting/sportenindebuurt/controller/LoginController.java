package nl.hp2consulting.sportenindebuurt.controller;

import nl.hp2consulting.sportenindebuurt.dto.UserDTO;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;
import nl.hp2consulting.sportenindebuurt.service.LoginService;

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

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserDTO userDTO) throws ConnectionException {
        var sporterID = loginService.login(userDTO.getUser(), userDTO.getPassword());
        if (sporterID != 0) {
            return Response.status(Response.Status.OK).entity(sporterID).build();
        }
        return Response.status(Response.Status.FORBIDDEN).build();
    }


}
