package org.sagar.githubuseractivity.Controller;

import org.sagar.githubuseractivity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/{username}")
    private Object[] display(@PathVariable String username){
        return activityService.fetchUserRecentActivity(username);
    }
}
