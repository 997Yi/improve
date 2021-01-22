package com.gfr.improve.service.impl;

import com.gfr.improve.dao.UserDao;
import com.gfr.improve.dao.UserPlanCompleteDateDao;
import com.gfr.improve.entity.UserPlanCompleteDate;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.UserPlanCompleteDateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("userPlanCompleteDateService")
public class UserPlanCompleteDateServiceImpl implements UserPlanCompleteDateService {

    @Resource
    private UserPlanCompleteDateDao userPlanCompleteDateDao;

    @Override
    public ResponseData insert(UserPlanCompleteDate userPlanCompleteDate) {
        userPlanCompleteDate.setPlanCompleteDate(new Date(System.currentTimeMillis()));
        List<UserPlanCompleteDate> list = userPlanCompleteDateDao.queryAll(userPlanCompleteDate);
        if(list.size() == 0){
            return new ResponseData(ResponseCode.SUCCESS, userPlanCompleteDateDao.insert(userPlanCompleteDate) == 1);
        }else{
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    @Override
    public ResponseData delete(String userId) {
        return new ResponseData(ResponseCode.SUCCESS, userPlanCompleteDateDao.delete(userId) == 1);
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
        List<String> dateList = new ArrayList<>();
        for (UserPlanCompleteDate upcd : upcdList){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
            String date = sdf.format(upcd.getPlanCompleteDate());
            if (date.substring(0,4).equals(year.toString()) &&  date.substring(5,7).equals(monthStr)){
                Integer a = Integer.parseInt(date.substring(8,10));
                dateList.add(a.toString());
            }
        }
        dateList.sort((s1,s2) -> (Integer.parseInt(s1) - Integer.parseInt(s2)));
        return new ResponseData(ResponseCode.SUCCESS, dateList, dateList.size());
    }

    @Override
    public ResponseData isAllPlanComplete(UserPlanCompleteDate userPlanCompleteDate) {
        boolean isAllPlanComplete = true;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(userPlanCompleteDate.getPlanCompleteDate());
        calendar.add(Calendar.MONTH, -1);
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        if (Integer.parseInt(month) < 10){
            month = "0" + month;
        }

        List<UserPlanCompleteDate> upcdList = userPlanCompleteDateDao.queryByLike(userPlanCompleteDate.getUserId(), year, month);
        List<String> dateList = new ArrayList<>();
        for (UserPlanCompleteDate upcd : upcdList){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
            String date = sdf.format(upcd.getPlanCompleteDate());
            Integer a = Integer.parseInt(date.substring(8,10));
            dateList.add(a.toString());
        }
        dateList.sort((s1,s2) -> (Integer.parseInt(s1) - Integer.parseInt(s2)));
        if (!dateList.isEmpty()){
            switch (month){
                case "01":
                case "03":
                case "05":
                case "07":
                case "08":
                case "10":
                case "12":
                    for (int i = 0; i < 31; i++) {
                        if (dateList.get(i).compareTo(i+1 + "") != 0){
                            isAllPlanComplete = false;
                            break;
                        }
                    }
                    break;
                case "04":
                case "06":
                case "09":
                case "11":
                    for (int i = 0; i < 30; i++) {
                        if (dateList.get(i).compareTo(i+1<10 ? "0" + i : "" + i) != 0){
                            isAllPlanComplete = false;
                            break;
                        }
                    }
                    break;
                case "02":
                    if (Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0 || Integer.parseInt(year) % 400 == 0){
                        for (int i = 0; i < 29; i++) {
                            if (dateList.get(i).compareTo(i+1<10 ? "0" + i : "" + i) != 0){
                                isAllPlanComplete = false;
                                break;
                            }
                        }
                    }else {
                        for (int i = 0; i < 28; i++) {
                            if (dateList.get(i).compareTo(i+1<10 ? "0" + i : "" + i) != 0){
                                isAllPlanComplete = false;
                                break;
                            }
                        }
                    }
            }
        }

        return new ResponseData(ResponseCode.SUCCESS, isAllPlanComplete);// ? "true" : "false"
    }

    @Override
    public int queryCountById(String userId) {
        return userPlanCompleteDateDao.queryCountById(userId);
    }
}
