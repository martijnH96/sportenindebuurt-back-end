package Controllers;

import DTO.SportsDTO;
import DTO.TimeFrameDTO;
import Services.PreferenceService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pref")
public class PreferenceController {

    private PreferenceService preferenceService;
    @Inject
    private void setPreferenceService(PreferenceService preferenceService){this.preferenceService = preferenceService;}

    @GET
    @Path("/sports")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSports(){
        return Response.status(200).entity("jsonObject").build();
    }


    @POST
    @Path("/time")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPreferenceTime(double locationX, double locationY, List<TimeFrameDTO> timeFrameDTOS){
        preferenceService.insertTime(locationX, locationY, timeFrameDTOS);
        return Response.status(200).entity("jsonObject").build();
    }

    @POST
    @Path("/sports")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPreferenceSports(List<SportsDTO> sportsDTOS){
        preferenceService.insertSports(sportsDTOS);
        return Response.status(200).entity("jsonObject").build();
    }

}
