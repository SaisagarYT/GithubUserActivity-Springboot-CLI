package org.sagar.githubuseractivity.service;

import org.sagar.githubuseractivity.repository.ActivityRespoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActivityService {

    @Autowired
    private ActivityRespoitory activityRespoitory;

    public Object[] fetchUserRecentActivity(String username){
        String url = "https://api.github.com/users/"+username+"/received_events/public";
        try{
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url,Object[].class);
        }
        catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
