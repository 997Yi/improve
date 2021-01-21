package com.gfr.improve;

import com.gfr.improve.service.UserPlanService;
import com.gfr.improve.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class ImproveApplicationTests {

    @Resource
    UserPlanService userPlanService;



    @Test
    void contextLoads() {
    }

}
