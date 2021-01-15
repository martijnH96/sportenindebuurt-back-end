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
    @Path("/time/{sporterID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPreferenceTime(TimeFrameListDTO timeFrameListDTO, @PathParam("sporterID") int sporterID) throws ConnectionException {
        if(preferenceService.insertTime(timeFrameListDTO, sporterID)){ //exceptions toevoegen
            return Response.status(Response.Status.CREATED).build();
        }
        return null;
    }

    @POST
    @Path("/sports/{sporterID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPreferenceSports(SportsListDTO sportsListDTO, @PathParam("sporterID") int sporterID) throws ConnectionException {
        if(preferenceService.insertSports(sportsListDTO, sporterID)){
            return Response.status(Response.Status.CREATED).build();
        }
        return null;
    }

}
