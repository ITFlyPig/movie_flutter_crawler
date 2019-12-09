package com.wangyuelin.app.crawler.sites.zuida;

import com.wangyuelin.app.bean.*;
import com.wangyuelin.app.crawler.SiteConf;
import com.wangyuelin.app.utils.ArrayUtil;
import com.wangyuelin.app.utils.TextUtil;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解析电影的详情页
 */
@Component
public class ZuidaMovieDetailPageProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        if (page == null) {
            return;
        }
        Html html = page.getHtml();
        Movie movie = parseHtml(html);
        if (movie != null) {
            List<String> froms = movie.getFroms();
            if (froms == null) {
                froms = new ArrayList<String>();
                movie.setFroms(froms);
            }
            froms.add(page.getUrl().get());
            System.out.println("解析得到的电影");
            System.out.println(movie.toString());
        }

    }


    /**
     * 从html中解析得到电影的基本信息
     * @param html
     * @return
     */
    private Movie parseHtml(Html html) {
        if (html == null) {
            return null;
        }
        //获取电影的名称
        String name = html.xpath("//div[@class='vodh']/h2/text()").toString();
        System.out.println(name);
        if (TextUtil.isEmpty(name)) {
            return null;
        }
        Movie movie = new Movie();
        movie.setName(name);

        //获取电影的封面
        String cover = html.xpath("div[@class='vodImg']/img/@src").get();
        movie.setCovers(ArrayUtil.toList(cover));

        //获取电影的评分
        String rankStr = html.xpath("div[@class='vodh']/label/text()").get();
        Float rank = TextUtil.toFloat(rankStr);
        if (rank != null) {
            movie.setDoubanRank(rank);
        }

        //获取电影的质量
        String quality = html.xpath("//div[@class='vodh']/span/text()").toString();
        movie.setQuality(quality);
        System.out.println(quality);

        //获取电影的资源
        List<Selectable> resources = html.xpath("div[@class='vodplayinfo']/div/div").nodes();
        ArrayList<MovieLink> movieLinks = new ArrayList<MovieLink>();
        if (resources != null) {
            for (Selectable resource : resources) {
                String typeName = resource.xpath("h3/span/text()").get();
                MovieLink movieLink = new MovieLink();
                movieLink.setFrom(SiteType.ZUIDA);
                movieLinks.add(movieLink);
                //资源类型
                if (!TextUtil.isEmpty(typeName)) {
                    if (typeName.contains("m3u8")) {
                        movieLink.setType(LinkType.M3U8);
                    } else if (typeName.contains("zuidall")) {
                        movieLink.setType(LinkType.HTML_PLAY);
                    } else if (typeName.contains("下载")) {
                        movieLink.setType(LinkType.DOWNLOAD_LINK);
                    } else  {
                        movieLink.setType(LinkType.UNKNOW);
                    }
                }

                List<MovieLink.LinkItem> linkItems = new ArrayList<MovieLink.LinkItem>();
                List<Selectable> lis = resource.xpath("ul/li").nodes();
                if (lis != null) {
                    for (Selectable li : lis) {
                        String link = li.xpath("li/text()").get();
                        //分割得到名称和连接
                        if (!TextUtil.isEmpty(link)) {
                            String[] array = link.split("\\$");
                            if (array.length > 1) {
                                MovieLink.LinkItem linkItem = new MovieLink.LinkItem(array[0], array[1]);
                                linkItems.add(linkItem);
                            }
                        }
                    }
                }
                movieLink.setLinks(linkItems);
            }
        }
        movie.setLinks(movieLinks);


        List<Selectable> infos = html.xpath("div[@class='vodinfobox']/ul/*").nodes();
        for (Selectable info : infos) {
            //获取简介
            String intro = info.xpath("li//span[@class='more']/text()").get();
            if (!TextUtil.isEmpty(intro)) {
                movie.setIntro(intro);
                continue;
            }

           String textName = info.xpath("li/text()").toString();
           if (TextUtil.isEmpty(textName)) {
               continue;
           }
            String value = info.xpath("span/text()").get();
            if (textName.contains("别名")) {
                movie.setOtherNames(ArrayUtil.toList(value));
            } else if (textName.contains("导演")) {
                movie.setDirectors(ArrayUtil.toList(value));
            } else if (textName.contains("主演")) {
                String[] actors = value.split(",");
                movie.setActors(Arrays.asList(actors));
            } else if (textName.contains("类型")) {
               List<String> types = TextUtil.splitWithSpace(value);
                List<MovieType> movieTypes = new ArrayList<MovieType>();
                for (String type : types) {
                    MovieType movieType = MovieType.getType(type);
                    if (movieType != null && !movieTypes.contains(movieType)) {
                        movieTypes.add(movieType);
                    }
                }
                movie.setTypes(movieTypes);
            } else if(textName.contains("地区")) {
                movie.setLocations(ArrayUtil.toList(value));
            } else if(textName.contains("语言")) {
                movie.setLanguage(value);
            } else if(textName.contains("上映")) {
                movie.setShowTimes(ArrayUtil.toList(value));
            } else if(textName.contains("片长")) {
                Integer duration = TextUtil.toInteger(value);
                movie.setDuration(duration == null ? 0 : duration);
            }
        }
        return movie;
    }



    @Override
    public Site getSite() {
        return SiteConf.zuidaSite;
    }
}
