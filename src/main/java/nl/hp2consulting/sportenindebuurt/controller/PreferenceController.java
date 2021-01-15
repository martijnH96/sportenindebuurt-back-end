package nl.hp2consulting.sportenindebuurt.controller;

import nl.hp2consulting.sportenindebuurt.dto.SportsListDTO;
import nl.hp2consulting.sportenindebuurt.dto.TimeFrameListDTO;
import nl.hp2consulting.sportenindebuurt.exceptions.ConnectionException;
import nl.hp2consulting.sportenindebuurt.service.PreferenceService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pref")
public class PreferenceController {

    private PreferenceService preferenceService;
    @Inject
    private void setPreferenceService(PreferenceService preferenceService){this.preferenceService = preferenceService;}

    @POST
    @Path("/time")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPreferenceTime(TimeFrameListDTO timeFrameListDTO, int sporterID) throws ConnectionException {
        if(preferenceService.insertTime(timeFrameListDTO, sporterID)){ //exceptions toevoegen
            return Response.status(Response.Status.CREATED).entity(timeFrameListDTO.getTimeFrameDTOList().get(0)).build();
        }
        return null;
    }

    @POST
    @Path("/sports")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPreferenceSports(SportsListDTO sportsListDTO, int sporterID) throws ConnectionException {
        if(preferenceService.insertSports(sportsListDTO, sporterID)){
            return Response.status(Response.Status.CREATED).build();
        }
        return null;
    }

}
