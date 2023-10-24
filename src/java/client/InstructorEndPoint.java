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
import client.InstructorRequest;

/**
 *
 * @author aefilms
 */
public class InstructorEndPoint {

    Gson gson = new Gson();

    private static String endpoint = "http://localhost:8080/StudentTracker3/api/v1";

    public InstructorResponse saveOrUpdateInstructor(InstructorRequest req) {

        System.out.println("Request: " + req);

        InstructorResponse instructorResponse = new InstructorResponse();

        //business logic
        try {

            ClientConfig config = new ClientConfig();
            Client client = ClientBuilder.newClient(config);

            WebTarget target = client.target(endpoint).path("/instructor/saveOrUpdateInstructor");

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .post(Entity.entity(req, MediaType.APPLICATION_JSON));

            if (response.getStatus() == 200) {
                String jsonResult = response.readEntity(String.class);
                instructorResponse = gson.fromJson(jsonResult, InstructorResponse.class);
            } else {
                throw new CustomRuntimeException("Status: " + response.getStatus() + "Exception: " + response.readEntity(String.class));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return instructorResponse;
    }

    public List<InstructorGetResponse> getInstructors() {

        List<InstructorGetResponse> instructorResponses = new ArrayList<>();

        //business logic
        try {

            ClientConfig config = new ClientConfig();
            Client client = ClientBuilder.newClient(config);

            WebTarget target = client.target(endpoint).path("/instructor/instructors");

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .get();

            if (response.getStatus() == 200) {
                String jsonResult = response.readEntity(String.class);

                // Use TypeToken to specify the list type
                Type listType = new TypeToken<List<InstructorGetResponse>>() {
                }.getType();
                instructorResponses = gson.fromJson(jsonResult, listType);

            } else {
                throw new CustomRuntimeException("Status: " + response.getStatus() + "Exception: " + response.readEntity(String.class));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return instructorResponses;
    }

    public InstructorGetResponse getInstructor(String instructorId) {

        InstructorGetResponse instructorResponse = new InstructorGetResponse();

        //business logic
        try {

            ClientConfig config = new ClientConfig();
            Client client = ClientBuilder.newClient(config);

            WebTarget target = client.target(endpoint).path("/instructor/instructor").queryParam("instructorId", instructorId);

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .get();

            if (response.getStatus() == 200) {
                String jsonResult = response.readEntity(String.class);

                instructorResponse = gson.fromJson(jsonResult, InstructorGetResponse.class);

            } else {
                throw new CustomRuntimeException("Status: " + response.getStatus() + "Exception: " + response.readEntity(String.class));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return instructorResponse;
    }

    public InstructorDeleteResponse deleteInstructor(String instructorId) {

        InstructorDeleteResponse instructorResponse = new InstructorDeleteResponse();

        try {

            ClientConfig config = new ClientConfig();
            Client client = ClientBuilder.newClient(config);

            WebTarget target = client.target(endpoint).path("/instructor/deleteInstructor").queryParam("instructorId", instructorId);

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .delete();

            if (response.getStatus() == 200) {
                String jsonResult = response.readEntity(String.class);

                instructorResponse = gson.fromJson(jsonResult, InstructorDeleteResponse.class);

            } else {
                throw new CustomRuntimeException("Status: " + response.getStatus() + "Exception: " + response.readEntity(String.class));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return instructorResponse;
    }

    public static void main(String[] args) {

        InstructorEndPoint endpoint = new InstructorEndPoint();

//        Save or Update Instructor
//        String instructorId = Utility.generateRandomAlphanumeric(5);
//
//        InstructorRequest req = new InstructorRequest("Silver Moon", "silva@go.com", "09082483002");
//
//        InstructorResponse res = endpoint.saveOrUpdateInstructor(req);
//        System.out.println("Response: " + res.toString());

//        Get all Instructors
        List<InstructorGetResponse> responses = endpoint.getInstructors();
        int counter = 1;
        for (InstructorGetResponse res : responses) {
            System.out.println("Response "+counter+" "+res.toString());
            counter++;
        }
//        Get Instructor
//        InstructorGetResponse res = endpoint.getInstructor("KLEU3");
//        System.out.println("res: "+res.toString());
//        Delete Instructor
//        InstructorDeleteResponse res = endpoint.deleteInstructor("KLEU3");
//        System.out.println("res: " + res.toString());
    }

}
