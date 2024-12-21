package org.example.springbootresttemplate.repo;

import org.example.springbootresttemplate.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);


}

//    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
//                    3, List.of("HTML", "CSS", "JavaScript", "React")),
//            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//                    List.of("Python", "Machine Learning", "Data Analysis")),
//            new JobPost(4, "Network Engineer",
//                    "Design and implement computer networks for efficient data communication", 5,
//                    List.of("Networking", "Cisco", "Routing", "Switching"))
//    ));
//
//    public List<JobPost> getAllJobs(){
//        return jobs;
//    }
//
//    public void addJob(JobPost job){
//        jobs.add(job);
//    }
//
//    public JobPost getJob(int postId) {
//        for(JobPost job: jobs){
//            if(job.getPostId() == postId){
//                return job;
//            }
//        }
//        return null;
//    }
//
//    public void updateJob(JobPost jobpost) {
//        for(JobPost job : jobs){
//            if(job.getPostId() == jobpost.getPostId()){
////              just updating all fields as an example, without checking if there are new values
//                job.setPostDesc(jobpost.getPostDesc());
//                job.setPostProfile(job.getPostProfile());
//                job.setReqExperience(job.getReqExperience());
//                job.setPostTechStack(jobpost.getPostTechStack());
//            }
//        }
//    }
//
//    public void deletePost(int postId) {
//        for(JobPost job: jobs){
//            if(job.getPostId() == postId){
//                jobs.remove(job);
//            }
//        }
//    }
