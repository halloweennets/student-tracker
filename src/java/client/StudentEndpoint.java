/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;




import Utils.Utility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exception.CustomRuntimeException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author aefilms
 */
public class StudentEndpoint {
    
Gson gson = new Gson();

    private static String endpoint = "http://localhost:8080/StudentTracker3/api/v1";

    public StudentResponse saveOrUpdateStudent(StudentRequest req) {

        System.out.println("Request: " + req);

        StudentResponse studentResponse = new StudentResponse();

        //business logic
        try {

            ClientConfig config = new ClientConfig();
            Client client = ClientBuilder.newClient(config);

            WebTarget target = client.target(endpoint).path("/student/saveOrUpdateStudent");

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .post(Entity.entity(req, MediaType.APPLICATION_JSON));

            if (response.getStatus() == 200) {
                String jsonResult = response.readEntity(String.class);
                studentResponse = gson.fromJson(jsonResult, StudentResponse.class);
            } else {
                throw new CustomRuntimeException("Status: " + response.getStatus() + "Exception: " + response.readEntity(String.class));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return studentResponse;
    }

    public List<StudentGetResponse> getStudents() {

        List<StudentGetResponse> studentResponses = new ArrayList<>();

        //business logic
        try {

            ClientConfig config = new ClientConfig();
            Client client = ClientBuilder.newClient(config);

            WebTarget target = client.target(endpoint).path("/student/students");

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .get();

            if (response.getStatus() == 200) {
                String jsonResult = response.readEntity(String.class);

                // Use TypeToken to specify the list type
                Type listType = new TypeToken<List<StudentGetResponse>>() {
                }.getType();
                studentResponses = gson.fromJson(jsonResult, listType);

            } else {
                throw new CustomRuntimeException("Status: " + response.getStatus() + "Exception: " + response.readEntity(String.class));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return studentResponses;
    }

    public StudentGetResponse getStudent(String studentId) {

        StudentGetResponse studentResponse = new StudentGetResponse();

        //business logic
        try {

            ClientConfig config = new ClientConfig();
            Client client = ClientBuilder.newClient(config);

            WebTarget target = client.target(endpoint).path("/student/student").queryParam("studentId", studentId);

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .get();

            if (response.getStatus() == 200) {
                String jsonResult = response.readEntity(String.class);

                studentResponse = gson.fromJson(jsonResult, StudentGetResponse.class);

            } else {
                throw new CustomRuntimeException("Status: " + response.getStatus() + "Exception: " + response.readEntity(String.class));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return studentResponse;
    }

    public StudentDeleteResponse deleteStudent(String studentId) {

        StudentDeleteResponse studentResponse = new StudentDeleteResponse();

        try {

            ClientConfig config = new ClientConfig();
            Client client = ClientBuilder.newClient(config);

            WebTarget target = client.target(endpoint).path("/student/deleteStudent").queryParam("studentId", studentId);

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .delete();

            if (response.getStatus() == 200) {
                String jsonResult = response.readEntity(String.class);

                studentResponse = gson.fromJson(jsonResult, StudentDeleteResponse.class);

            } else {
                throw new CustomRuntimeException("Status: " + response.getStatus() + "Exception: " + response.readEntity(String.class));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return studentResponse;
    }

    public static void main(String[] args) {

        StudentEndpoint endpoint = new StudentEndpoint();

//        Save or Update Student
        String studentId = Utility.generateRandomAlphanumeric(5);
        
        StudentRequest req = new StudentRequest("Amadi Lee", 20, "Male", "levi@gmail.com", "08102578666");
        
        StudentResponse res = endpoint.saveOrUpdateStudent(req);
        System.out.println("Response: "+res.toString());


//        Get all Student
//        List<StudentGetResponse> responses = endpoint.getStudents();
//        int counter = 1;
//        for (StudentGetResponse res : responses) {
//            System.out.println("Response "+counter+" "+res.toString());
//            counter++;
//        }


//        Get Student
//        StudentGetResponse res = endpoint.getStudent("EW5EC");
//        System.out.println("res: "+res.toString());


//        Delete Student
//        StudentDeleteResponse res = endpoint.deleteStudent("IasQp");
//        System.out.println("res: "+res.toString());
    }

}

