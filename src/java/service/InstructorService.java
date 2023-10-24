/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author aefilms
 */
import DAO.InstructorDAO;
import DTO.DeleteResponse;
import DTO.InstructorGetResponse;
import DTO.InstructorRequest;
import DTO.InstructorResponse;
import exception.CustomRuntimeException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Utils.Utility;
import beans.InstructorBean;

/**
 *
 * @author t
 */
public class InstructorService {

    InstructorDAO instructorDAO = new InstructorDAO();

    public InstructorResponse saveOrUpdateInstructor(InstructorRequest req) {

        InstructorResponse res = new InstructorResponse();

        InstructorBean bean = new InstructorBean();
        bean.setFullName(req.getFullName());
        bean.setEmail(req.getEmail());
        bean.setMobileNumber(req.getMobileNumber());
        bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        if (req.getInstructorId() == null) {
            //save  Instructor record

            String instructorId = Utility.generateRandomAlphanumeric(5);
            bean.setInstructorId(instructorId);

            int status = instructorDAO.addInstructorData(bean);
            if (status == 0) {
                res.setSuccessful(true);
                res.setInstructorId(instructorId);
                res.setFullName(bean.getFullName());
                res.setEmail(bean.getEmail());
                res.setMobileNumber(bean.getMobileNumber());

            } else {
                throw new RuntimeException("Instructor Record has not been saved ");
            }

        } else {
            //update Instructor record
            bean.setInstructorId(req.getInstructorId());

            int status = instructorDAO.updateInstructorData(bean);
            if (status == 0) {
                res.setSuccessful(true);
                res.setInstructorId(bean.getInstructorId());
                res.setFullName(bean.getFullName());
                res.setEmail(bean.getEmail());
                res.setMobileNumber(bean.getMobileNumber());
            } else {
                throw new RuntimeException("Instructor Record has not been updated");
            }
        }
        return res;
    }

    public InstructorGetResponse getInstructor(String instructorId) {

        InstructorBean instructor = instructorDAO.getInstructorData(instructorId);

        if (instructor != null) {

            return new InstructorGetResponse(instructor.getInstructorId(),
                    instructor.getFullName(),
                    instructor.getEmail(),
                    instructor.getMobileNumber());
           

        } else {
            throw new CustomRuntimeException("Did not find Instructor: " + instructorId);
        }
    }

    public List<InstructorGetResponse> getInstructors() {

        List<InstructorGetResponse> responses = new ArrayList<>();

        List<InstructorBean> instructors = instructorDAO.getInstructorList();

        if (!instructors.isEmpty()) {
            for (InstructorBean instructor : instructors) {

                responses.add(new InstructorGetResponse(instructor.getInstructorId(),
                        instructor.getFullName(),
                        instructor.getEmail(),
                        instructor.getMobileNumber()));

            }
        } else {
            throw new CustomRuntimeException("No Instructor Record Found. Please save Instructor to see list");
        }

        return responses;

    }

    public DeleteResponse deleteInstructor(String instructorId) {

        DeleteResponse res = new DeleteResponse();

        int status = instructorDAO.deleteInstructorData(instructorId);
        if (status == 0) {
            res.setMessage(instructorId + " has been deleted successfully");
            res.setTimeStamp(instructorId);
        } else {
            throw new CustomRuntimeException("Instructor Record has not been deleted");
        }

        return res;

    }

}
