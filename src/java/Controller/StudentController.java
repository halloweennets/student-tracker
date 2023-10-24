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
import DTO.StudentGetResponse;
import DTO.StudentRequest;
import DTO.StudentResponse;
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
import service.StudentService;

/**
 *
 * @author t
 */
@Path("/student")
public class StudentController {
    
    StudentService studentService = new StudentService();
    
    @POST
    @Path("/saveOrUpdateStudent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveOrUpdateStudent(StudentRequest req){
        
        StudentResponse res = studentService.saveOrUpdateStudent(req);
        
        GenericEntity<StudentResponse> entity = new GenericEntity<>(res, StudentResponse.class);
        return Response.ok().entity(entity).build();
    }
    
    @GET
    @Path("/student")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getStudent(@QueryParam("studentId") String studentId){
        
        StudentGetResponse res = studentService.getStudent(studentId);
        
        GenericEntity<StudentGetResponse> entity = new GenericEntity<>(res, StudentGetResponse.class);
        return Response.ok().entity(entity).build();
    }
    
    
    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getStudents(){
        
        List<StudentGetResponse> res = studentService.getStudents();
        
        
        // Use TypeToken to specify the list type
        Type listType = new TypeToken<List<StudentGetResponse>>() {}.getType();
        
        GenericEntity<List<StudentGetResponse>> entity = new GenericEntity<>(res, listType);

        return Response.ok().entity(entity).build();
    }
    
    
    @DELETE
    @Path("/deleteStudent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteStudent(@QueryParam("studentId") String studentId){
        
        DeleteResponse res = studentService.deleteStudent(studentId);
        
        GenericEntity<DeleteResponse> entity = new GenericEntity<>(res, DeleteResponse.class);
        return Response.ok().entity(entity).build();
    }
}

