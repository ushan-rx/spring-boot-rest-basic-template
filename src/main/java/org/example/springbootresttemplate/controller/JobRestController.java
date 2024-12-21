package org.example.springbootresttemplate.controller;

import org.example.springbootresttemplate.model.JobPost;
import org.example.springbootresttemplate.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "${allowed.origin}")
public class JobRestController {

    @Autowired
    private JobService service;

//    @ResponseBody     -    when using normal controller
    @GetMapping(path = "jobPosts", produces = {"application/json"})
    public ResponseEntity<List<JobPost>> getAllJobs(){
        List<JobPost> jobs = service.getAllJobs();
        return jobs.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("jobPost/{postId}")
    public ResponseEntity<JobPost> getJob(@PathVariable("postId") int postId){
        JobPost job = service.getJob(postId);
        return job.getPostId() < 0 ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(job, HttpStatus.OK);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public ResponseEntity<List<JobPost>> searchByKeyword(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(service.search(keyword), HttpStatus.OK);
    }

    @PostMapping(path ="jobPost", consumes = {"application/json"})
    public JobPost addPost(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updatePost(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deletePost(postId);
        return "post deleted";
    }

    @GetMapping("load")
    public String loadData(){
        service.load();
        return "success";
    }
}
