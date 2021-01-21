package com.gfr.improve.service.impl;

import com.gfr.improve.dao.UserDao;
import com.gfr.improve.dao.UserPlanCompleteDateDao;
import com.gfr.improve.entity.UserPlanCompleteDate;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.UserPlanCompleteDateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("userPlanCompleteDateService")
public class UserPlanCompleteDateServiceImpl implements UserPlanCompleteDateService {

    @Resource
    private UserPlanCompleteDateDao userPlanCompleteDateDao;

    @Override
    public int insert(UserPlanCompleteDate userPlanCompleteDate) {
        return userPlanCompleteDateDao.insert(userPlanCompleteDate);
    }

    @Override
    public int delete(String userId) {
        return userPlanCompleteDateDao.delete(userId);
    }

    @Override
    public ResponseData queryDate(String userId, Integer year, Integer month) {
        String monthStr = "";
        if (month < 10){
            monthStr = "0" + month;
        }else {
            monthStr +=  month;
        }
        List<UserPlanCompleteDate> upcdList = userPlanCompleteDateDao.queryDate(userId);
        List<Integer> dateList = new ArrayList<>();
        for (UserPlanCompleteDate upcd : upcdList){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
            String date = sdf.format(upcd.getPlanCompleteDate());
            if (date.substring(0,4).equals(year.toString()) &&  date.substring(5,7).equals(monthStr)){
                dateList.add(Integer.parseInt(date.substring(8,10)));
            }
        }
        System.out.println(dateList);
        return new ResponseData(ResponseCode.SUCCESS, dateList, dateList.size());
    }
}
