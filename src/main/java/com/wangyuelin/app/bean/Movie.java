package com.wangyuelin.app.bean;

import java.util.List;

public class Movie {
    private long id;
    private String name;
    private List<String> otherNames;
    private String quality;//影片的质量 HD BD 720  1080等
    private List<String> directors;//导演
    private List<String> actors;//演员
    private List<MovieType> types;//类型：动作片  惊悚片
    private List<String> locations;//国家和地区
    private String language;//语言
    private List<String> showTimes;//上映时间
    private int duration;//电影时长，分钟为单位
    private String intro;//简介
    private float doubanRank;//豆瓣评分
    private List<MovieLink> links;//电影的资源链接
    private List<String> covers;//封面

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<MovieType> getTypes() {
        return types;
    }

    public void setTypes(List<MovieType> types) {
        this.types = types;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<String> showTimes) {
        this.showTimes = showTimes;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public float getDoubanRank() {
        return doubanRank;
    }

    public void setDoubanRank(float doubanRank) {
        this.doubanRank = doubanRank;
    }

    public List<MovieLink> getLinks() {
        return links;
    }

    public void setLinks(List<MovieLink> links) {
        this.links = links;
    }

    public List<String> getCovers() {
        return covers;
    }

    public void setCovers(List<String> covers) {
        this.covers = covers;
    }

    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append("名称：").append(name).append("\n")
               .append("id:").append(id).append("\n")
               .append("封面:").append(getStr(covers)).append("\n")
               .append("评分:").append(doubanRank).append("\n")
               .append("别名:").append(getStr(otherNames)).append("\n")
               .append("质量:").append(quality).append("\n")
               .append("导演:").append(getStr(directors)).append("\n")
               .append("演员:").append(getStr(actors)).append("\n")
               .append("类型:").append(getMovieTypeStr(types)).append("\n")
               .append("地区:").append(getStr(locations)).append("\n")
               .append("语言:").append(language).append("\n")
               .append("上映时间:").append(showTimes).append("\n")
               .append("时长:").append(duration).append("\n")
               .append("资源:").append(getMovieLinkStr(links)).append("\n")
               .append("简介:").append(intro).append("\n").append("\n").append("\n").append("\n");
       return builder.toString();
    }

    StringBuilder getStr(List<String> list) {
        StringBuilder builder = new StringBuilder();
        if (list == null) {
            return builder;
        }
        for (String s : list) {
            builder.append(s).append(",");
        }
        return builder;
    }

    StringBuilder getMovieTypeStr(List<MovieType> list) {
        StringBuilder builder = new StringBuilder();
        if (list == null) {
            return builder;
        }
        for (MovieType movieType : list) {
            builder.append(movieType.getName()).append(",");
        }
        return builder;
    }

    StringBuilder getMovieLinkStr(List<MovieLink> list) {
        StringBuilder builder = new StringBuilder();
        if (list == null) {
            return builder;
        }
        builder.append("\n");
        for (MovieLink movieLink : list) {
            builder.append(movieLink.getType()).append(" ").append("\n").append("链接：");
            List<MovieLink.LinkItem> links = movieLink.getLinks();
            if (links != null) {
                for (MovieLink.LinkItem link : links) {
                    builder.append(link.getName()).append(" ").append(link.getLink()).append(",");
                }
            }
            builder.append("\n");

        }
        return builder;
    }
}
