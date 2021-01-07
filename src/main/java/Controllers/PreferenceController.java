package Controllers;

import DTO.ListDTO.SportsListDTO;
import DTO.ListDTO.TimeFrameListDTO;
import DTO.SportsDTO;
import Services.PreferenceService;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

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
        if(preferenceService.insertTime(timeFrameListDTO)){
            return Response.status(Response.Status.CREATED).entity(timeFrameListDTO.getTimeFrameDTOList().get(0)).build();
        }
        return null;
    }

    @POST
    @Path("/sports")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPreferenceSports(SportsListDTO sportsListDTO){
        if(preferenceService.insertSports(sportsListDTO)){
            return Response.status(Response.Status.CREATED).build();
        }
        return null;
    }

}
