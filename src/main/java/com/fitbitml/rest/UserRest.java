package com.fitbitml.rest;


import com.fitbitml.Utils.Utils;
import com.fitbitml.domain.Activity;
import com.fitbitml.domain.User;
import com.fitbitml.service.activity.ActivityService;
import com.fitbitml.service.auth.AuthService;
import com.fitbitml.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRest {

    private UserService userService;
    private ActivityService activityService;
    private AuthService authService;
    Utils utils;

    @Autowired
    public UserRest(UserService userService, ActivityService activityService, AuthService authService, Utils utils) {
        this.userService = userService;
        this.activityService = activityService;
        this.authService = authService;
        this.utils = utils;
    }

    @CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> list() {
        return (List<User>) userService.findAll();
    }

    @CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST, produces = {"application/json"})
    public User createUser(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("dateStart") String dateStart,
                           @RequestParam("dateEnd") String dateEnd,
                           @RequestParam("birthday") String birthday) throws IOException, ParseException {
        System.out.println(firstName+"   " +dateEnd);
        String token = authService.getAccessToken();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Activity> activityList = new ArrayList<>();
        activityList.addAll(activityService.getActivities(new Date(format.parse(dateStart).getTime()),
                new Date(format.parse(dateEnd).getTime()), token));
        User user = new User(firstName, lastName, new Date(format.parse(dateStart).getTime()),
                new Date(format.parse(dateEnd).getTime()),
                new Date(format.parse(birthday).getTime()));
        user.setActivities(activityList);

        userService.save(user);

        return user;
    }

    @CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public User getUser(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName){

        return  userService.getUserByFirstNameAndLastName(firstName, lastName);
    }

    @CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam("id") String id){

        userService.deleteById(Integer.parseInt(id));
    }

    @CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public User updateUser(@RequestParam("id") String id,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("birthday") String birthday) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User user = userService.findById(Integer.parseInt(id)).get();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthday(new Date(format.parse(birthday).getTime()));
        return  userService.save(user);
    }

}
