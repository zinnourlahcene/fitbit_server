package com.fitbitml.rest;


import com.fitbitml.service.activity.ActivityService;
import com.fitbitml.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.sql.Date;

@RestController
@RequestMapping("/api/activity")
public class ActivityRest {

    ActivityService activityService;
    UserService userService;

    @Autowired
    public ActivityRest(ActivityService activityService, UserService userService){
        this.activityService = activityService;
        this.userService = userService;
    }

}
