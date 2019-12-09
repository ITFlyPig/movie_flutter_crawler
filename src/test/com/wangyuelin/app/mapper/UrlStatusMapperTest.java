package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.UrlStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlStatusMapperTest {
    @Autowired
    private UrlStatusMapper urlStatusMapper;

    @Test
    public void insert() throws Exception {
        urlStatusMapper.insert("zuida", 0);

    }


    @Test
    public void select() throws Exception {
//        Integer status = urlStatusMapper.getUrlStatus("zuida2");
//        System.out.println("status:" + status);

//        List<UrlStatus> result = urlStatusMapper.getAllUrlStatus();
//        System.out.println("");

        urlStatusMapper.updateStatus("baidu", 0);


    }


}
