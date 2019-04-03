package com.fitbitml.service.activity;


import com.fitbitml.api.IApi;
import com.fitbitml.dao.ActivityRepository;
import com.fitbitml.domain.Activity;
import com.fitbitml.service.AbstractService;
import com.fitbitml.service.auth.AuthService;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl extends AbstractService<Activity, Integer> implements ActivityService {

    private ActivityRepository activityRepository;
    private AuthService authService;
    private IApi api;
    static OkHttpClient client = new OkHttpClient();

    @Autowired
    public ActivityServiceImpl(ActivityRepository repository, AuthService authService, IApi api) {
        super(repository);
        this.activityRepository = repository;
        this.authService = authService;
        this.api = api;
    }
    @Override
    public List<Activity> getActivities(Date dateStart, Date dateEnd, String accessToken) throws IOException, ParseException {
        return api.getActivities(dateStart, dateEnd, authService.getAccessToken());
    }

}
