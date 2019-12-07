package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.LinkType;
import com.wangyuelin.app.bean.MovieLink;
import com.wangyuelin.app.bean.SiteType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkMapperTest {
    @Autowired
    private LinkMapper linkMapper;

    @Test
    public void movieLink() throws Exception {
     //记录电影的资源类型
        linkMapper.insertLink(LinkType.M3U8.getValue(), SiteType.ZUIDA.name(), 1);
        Integer movieLInkId = linkMapper.getLinkId(LinkType.M3U8.getValue(), SiteType.ZUIDA.name(), 1);
        System.out.println("电影资源类型的id：" + movieLInkId);
    }

    @Test
    public void linkItem() throws Exception {
        //记录电影的资源类型
        linkMapper.insertLinkItem("m3u8", "链接", 1);
        List<MovieLink.LinkItem> items = linkMapper.getLinkItem(1);
        System.out.println("LinkItem的数量：" + items.size());
    }




}
