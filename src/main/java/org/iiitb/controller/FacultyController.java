package org.iiitb.controller;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.Faculty;
import org.iiitb.service.FacultyService;
import org.iiitb.service.impl.FacultyServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Path("/faculty")
public class FacultyController {
    private FacultyService facultyService = new FacultyServiceImpl();
    @POST
    @Path("/login")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@FormDataParam("username") String username,
                             @FormDataParam("password") String password) throws URISyntaxException{
        boolean valid =  facultyService.validate(username, password);
        if (valid) {
            return Response.seeOther(new URI("/academic_erp_war/courselist.html")).build();
        }
        return Response.status(401, "Wrong username or password").build();
    }

    @POST
    @Path("/updateGrade")
    public void updateGrade(String obj) {
        facultyService.updateGrade(obj);
    }


}
