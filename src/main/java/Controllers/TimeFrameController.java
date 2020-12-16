package Controllers;

import Services.SportService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class TimeFrameController {

    private SportService sportService;

    @Inject
    private void setSportService(SportService sportService){this.sportService = sportService;}

    @GET
    @Path("/sports")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSports(){
        return Response.status(200).entity(sportService.getSports()).build();
    }
}
