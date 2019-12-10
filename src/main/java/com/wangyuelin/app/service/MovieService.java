package com.wangyuelin.app.service;

import com.wangyuelin.app.bean.Movie;
import com.wangyuelin.app.bean.MovieLink;
import com.wangyuelin.app.bean.MovieType;
import com.wangyuelin.app.mapper.LinkMapper;
import com.wangyuelin.app.mapper.MovieMapper;
import com.wangyuelin.app.mapper.TypeMapper;
import com.wangyuelin.app.service.itf.IMovie;
import com.wangyuelin.app.utils.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @outhor wangyuelin
 * @create 2018-06-25 下午4:21
 */
@Service
public class MovieService implements IMovie {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private LinkMapper linkMapper;

    @Override
    public long save(Movie movie) {
        long id = -1;
        if (movie == null || TextUtil.isEmpty(movie.getName())) {
            return id;
        }
        Movie savedMovie = movieMapper.getByName(movie.getName());
        System.out.println("开始处理电影：" + movie.getName());

        if (savedMovie == null) {
            //记录电影的基本信息
            movieMapper.insert(movie);
            System.out.println("将基本信息插入到表中");
            savedMovie = movieMapper.getByName(movie.getName());
            if (savedMovie != null) {
                id = savedMovie.getId();
            }
            System.out.println("插入的电影的id为：" + id);
            //记录电影的类型
            List<MovieType> types = movie.getTypes();
            if (types != null) {
                System.out.println("开始记录电影的类型关系");
                for (MovieType type : types) {
                    System.out.println("开始处理类型：" + type.getName());
                    Integer typeId = typeMapper.getTypeId(type.getValue());
                    //所属类型不存在，那就插入
                    if (typeId == null) {
                        typeMapper.insertType(type.getName(), type.getValue());
                        typeId = typeMapper.getTypeId(type.getValue());
                        System.out.println("表中还没记录此种类型，插入到类型表，id为：" + typeId);
                    }
                    if (typeId == null) {
                        continue;
                    }
                    //记录类型关系
                    Integer relationshipId = typeMapper.getRelationshipId(id, typeId);
                    if (relationshipId == null) {
                        typeMapper.insertTypeRelationship(id, typeId);
                        System.out.println("将电影对应的类型记录下来");
                    }
                }
            }
            //电影的资源
            List<MovieLink> links = movie.getLinks();
            if (links != null) {
                System.out.println("开始处理电影的资源");
                for (MovieLink link : links) {
                    //此电影的采集自特定网站的此种类型的资源是否存在
                    Integer linkTypeId = linkMapper.getLinkId(link.getType().getValue(), link.getFrom().getHost(), id);
                    System.out.println("电影采集自：" + link.getFrom().getHost() + " 的类型为：" + link.getType().name() + " 资源类型id为：" + linkTypeId);
                    if (linkTypeId == null) {
                        //记录电影的资源类型
                        System.out.println("此种资源类型不存在，记录下来");
                        linkMapper.insertLink(link.getType().getValue(), link.getFrom().getHost(), id);
                        linkTypeId = linkMapper.getLinkId(link.getType().getValue(), link.getFrom().getHost(), id);
                    }

                    if (linkTypeId != null) {
                        //该种类型下的资源数
                        Integer size = linkMapper.getLinkItemSize(linkTypeId);
                        System.out.println("此种资源类型对应的下载和播放资源数：" + size);
                        //还没有资源
                        if (size == null || size == 0) {
                            if (link.getLinks() != null) {
                                for (MovieLink.LinkItem linkItem : link.getLinks()) {
                                    System.out.println("将资源：" + linkItem.getName() + " 记录到表中");
                                    linkMapper.insertLinkItem(linkItem.getName(), linkItem.getLink(), linkTypeId);
                                }
                            }
                        }
                    }

                }
            }


        } else {
            //TODO:对比新的和已存在的，将差别更新进去
            //目前不做处理，因为电影已经存在了
            id = savedMovie.getId();
            System.out.println("电影在表中已存在，不做处理");
        }

        return id;
    }

    @Override
    public void update(Movie movie) {

    }

    @Override
    public Movie getByName(String name) {
        return null;
    }

    @Override
    public Movie getById(long id) {
        return null;
    }
}