package com.gfr.improve;

import com.gfr.improve.service.UserPlanService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ImproveApplicationTests {

    @Resource
    UserPlanService userPlanService;



    @Test
    void contextLoads() {
    }

}
