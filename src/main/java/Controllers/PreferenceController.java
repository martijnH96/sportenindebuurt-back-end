package Controllers;

import DTO.ListDTO.SportsListDTO;
import DTO.ListDTO.TimeFrameListDTO;
import DTO.SportsDTO;
import DTO.TimeFrameDTO;
import Services.PreferenceService;

import javax.inject.Inject;
import javax.json.JsonObject;
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
    public Response insertPreferenceTime(TimeFrameListDTO timeFrameListDTO){
        preferenceService.insertTime(timeFrameListDTO);
        return Response.status(200).entity(timeFrameListDTO.getTimeFrameDTOList().get(0)).build();
    }

    @POST
    @Path("/sports")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPreferenceSports(SportsListDTO sportsListDTO){
        preferenceService.insertSports(sportsListDTO);
        return Response.status(200).entity(sportsListDTO.getSportsDTOList().get(0)).build();
    }

}
