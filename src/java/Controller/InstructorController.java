/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author aefilms
 */
import com.google.gson.reflect.TypeToken; 
import DTO.DeleteResponse;
import DTO.InstructorGetResponse;
import DTO.InstructorRequest;
import DTO.InstructorResponse;
import java.lang.reflect.Type;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.InstructorService;

/**
 *
 * @author t
 */
@Path("/instructor")
public class InstructorController {
    
    InstructorService instructorService = new InstructorService();
    
    @POST
    @Path("/saveOrUpdateInstructor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveOrUpdateInstructor(InstructorRequest req){
        
        InstructorResponse res = instructorService.saveOrUpdateInstructor(req);
        
        GenericEntity<InstructorResponse> entity = new GenericEntity<>(res, InstructorResponse.class);
        return Response.ok().entity(entity).build();
    }
    
    @GET
    @Path("/instructor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getInstructor(@QueryParam("instructorId") String instructorId){
        
        InstructorGetResponse res = instructorService.getInstructor(instructorId);
        
        GenericEntity<InstructorGetResponse> entity = new GenericEntity<>(res, InstructorGetResponse.class);
        return Response.ok().entity(entity).build();
    }
    
    
    @GET
    @Path("/instructors")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getInstructors(){
        
        List<InstructorGetResponse> res = instructorService.getInstructors();
        
        
        // Use TypeToken to specify the list type
        Type listType = new TypeToken<List<InstructorGetResponse>>() {}.getType();
        
        GenericEntity<List<InstructorGetResponse>> entity = new GenericEntity<>(res, listType);

        return Response.ok().entity(entity).build();
    }
    
    
    @DELETE
    @Path("/deleteInstructor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteInstructor(@QueryParam("instructorId") String instructorId){
        
        DeleteResponse res = instructorService.deleteInstructor(instructorId);
        
        GenericEntity<DeleteResponse> entity = new GenericEntity<>(res, DeleteResponse.class);
        return Response.ok().entity(entity).build();
    }
}

