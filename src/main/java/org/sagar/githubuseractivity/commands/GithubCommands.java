package org.sagar.githubuseractivity.commands;

import org.sagar.githubuseractivity.model.Activity;
import org.sagar.githubuseractivity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.CommandGroup;
import org.springframework.shell.core.command.annotation.Option;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
@CommandGroup(name = "GitHub User Activity")
public class GithubCommands {

    @Autowired
    private ActivityService activityService;
    @Command(name = "github-activity")
    private String userFetch(@Option String username){
        StringBuilder output = new StringBuilder();
        Object[] recentActivity = activityService.fetchUserRecentActivity(username);
        int activitiesLength = recentActivity.length;
        for (Object activity : recentActivity){
            Map<String,Object> singleActivity = (Map<String, Object>) activity;
            String type = singleActivity.get("type").toString();
            String repo = singleActivity.get("repo").toString();
            Map<String,Object> payload = (Map<String, Object>) singleActivity.get("payload");
            String branch = payload.get("ref").toString();
            String created_at = singleActivity.get("created_at").toString();
            output.append("Event --> ").append(type).append(" ").append(created_at, 0, 9).append(" (").append(created_at,11,16).append(")\n");
            output.append("Repo --> ").append(repo).append("\n");
            output.append("Branch --> ").append(branch).append("\n");
            output.append("\n\n");
        }
        return "Total Recent Activities: "+ activitiesLength + "\n" + output;
    }
}
