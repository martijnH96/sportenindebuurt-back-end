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
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPreference(double locationX, double locationY, List<TimeFrameDTO> timeFrameDTOS, List<SportsDTO> sportsDTOS){
        preferenceService.insertSports(locationX, locationY, timeFrameDTOS, sportsDTOS);
        return Response.status(200).entity("jsonObject").build();
    }
}
