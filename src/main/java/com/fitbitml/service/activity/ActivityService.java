package com.fitbitml.service.activity;

import com.fitbitml.domain.Activity;
import com.fitbitml.domain.Auth;
import com.fitbitml.service.IService;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public interface ActivityService extends IService<Activity, Integer> {

    List<Activity> getActivities(Date dateStart, Date dateEnd, String accessToken) throws IOException, ParseException;
}
