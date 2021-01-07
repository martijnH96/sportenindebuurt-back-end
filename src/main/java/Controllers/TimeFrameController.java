package Controllers;
import Services.TimeFrameService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class TimeFrameController {

    private TimeFrameService timeFrameService;

    @Inject
    public void setTimeService(TimeFrameService timeFrameService){this.timeFrameService = timeFrameService;}

    @GET
    @Path("/times")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimes(){
        return null;
    }
}
