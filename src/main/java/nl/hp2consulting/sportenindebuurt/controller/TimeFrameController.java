package nl.hp2consulting.sportenindebuurt.controller;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;
import nl.hp2consulting.sportenindebuurt.service.TimeFrameService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class TimeFrameController {

    private TimeFrameService timeFrameService;

    @Inject
    public void setTimeService(TimeFrameService timeFrameService){this.timeFrameService = timeFrameService;}

    @GET
    @Path("/time/{sporterID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimeFrameFromUser(@PathParam("sporterID") int sporterID) throws ConnectionException {
        return Response.status(200).entity(timeFrameService.getTimeFrameFromUser(sporterID)).build();
    }
}
