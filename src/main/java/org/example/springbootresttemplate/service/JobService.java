package org.example.springbootresttemplate.service;

import org.example.springbootresttemplate.model.JobPost;
import org.example.springbootresttemplate.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost job){
        repo.addJob(job);
    }

    public List<JobPost> getAllJobs(){
        return  repo.getAllJobs();
    }

    public JobPost getJob(int postId) {

        return repo.getJob(postId);
    }

    public void updateJob(JobPost jobpost) {
        repo.updateJob(jobpost);
    }

    public void deletePost(int postId) {
        repo.deletePost(postId);
    }
}
