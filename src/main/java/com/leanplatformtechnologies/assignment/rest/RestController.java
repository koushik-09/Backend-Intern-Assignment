package com.leanplatformtechnologies.assignment.rest;

import com.leanplatformtechnologies.assignment.entity.Mentor;
import com.leanplatformtechnologies.assignment.entity.MentorRequest;
import com.leanplatformtechnologies.assignment.entity.Statistics;
import com.leanplatformtechnologies.assignment.entity.User;
import com.leanplatformtechnologies.assignment.exceptionhandling.GlobalException;
import com.leanplatformtechnologies.assignment.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@RestController annotation is a convenience annotation that is itself annotated with
    -@Controller and @ResponseBody
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    //inject the service layer(constructor injection)
    private Service service;
    public RestController(Service theService){
        service = theService;
    }


    //expose the endpoints

    //admin endpoints
    @GetMapping(value={"admin/consultants","user/consultants"})
    public List<Mentor> findAll(){
        List<Mentor> list = service.findAll();
        if(list.isEmpty()){
            throw new GlobalException("No Mentors to fetch");
        }
        return service.findAll();
    }
    @GetMapping(value={"admin/consultant-id/{consultantId}","user/consultant-id/{consultantId}"})
    public Mentor findById(@PathVariable int consultantId){
        Mentor mentor = service.findById(consultantId);
        if(mentor == null){
            throw new GlobalException("Consultant not found with id-"+consultantId);
        }
        return mentor;
    }
    @GetMapping(value={"admin/consultant-role/{role}","user/consultant-role/{role}"})
    public List<Mentor> findByRole(@PathVariable String role){
        List<Mentor> list = service.findByRole(role);
        if(list.isEmpty()){
            throw new GlobalException("No Mentors found with role -" +role);
        }
        return list;
    }
    @GetMapping("/admin/consultant-requests")
    public List<MentorRequest> findAllRequest(){
        List<MentorRequest> list = service.findAllRequests();
        if(list.isEmpty()){
            throw new GlobalException("No Mentor Requests to fetch");
        }
        return list;
    }
    @GetMapping("/admin/approve/{requestId}")
    public Mentor approve(@PathVariable int requestId){
        Mentor temp =service.save(requestId);
        service.deleteRequest(requestId);
        return temp;
    }

    @DeleteMapping("/admin/reject/{requestId}")
    public String reject(@PathVariable int requestId){
        MentorRequest temp = service.findByRequestId(requestId);
        service.deleteRequest(requestId);
        return "Request Deleted "+requestId;
    }

    @PostMapping("/admin/add-consultant")
    public Mentor addConsultant(@RequestBody Mentor mentor){
        mentor.setId(0);
        Mentor temp = service.save(mentor);
        return temp;
    }


    @PutMapping("/consultant/update-details")
    public Mentor updateDetails(@RequestBody Mentor mentor){
        Mentor temp = service.updateMentorDetails(mentor);
        return temp;
    }

    @GetMapping("/admin/web-statistics")
    public Statistics webStatistics(){
        return service.statistics();
    }

    @PostMapping("/user/become-consultant")
    public MentorRequest sendRequest(@RequestBody MentorRequest mentorRequest){
        return service.sendRequest(mentorRequest);
    }

    @PostMapping("/user/register")
    public User newUser(@RequestBody User user){
        return service.save(user);
    }

    @PutMapping("/user/book-session/{phoneNum}")
    public String bookSession(@PathVariable long phoneNum){
        return service.bookSession(phoneNum);
    }

    @GetMapping("/admin/get-users")
    public List<User> findAllUser(){
        List<User> list = service.findAllUser();
        if(list.isEmpty()){
            throw new GlobalException("No Clients to fetch");
        }
        return list;
    }



}
