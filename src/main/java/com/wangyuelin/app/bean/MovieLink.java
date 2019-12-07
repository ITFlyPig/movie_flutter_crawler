package com.wangyuelin.app.bean;

import java.io.Serializable;
import java.util.List;

public class MovieLink {
    private long id;
    private LinkType type;
    private List<LinkItem> links;
    private SiteType from;//从哪个网站采集的

    public SiteType getFrom() {
        return from;
    }

    public void setFrom(SiteType from) {
        this.from = from;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public LinkType getType() {
        return type;
    }

    public void setType(LinkType type) {
        this.type = type;
    }

    public List<LinkItem> getLinks() {
        return links;
    }

    public void setLinks(List<LinkItem> links) {
        this.links = links;
    }

    public static class LinkItem implements Serializable {
        private long id;
        private String name;
        private String link;



        public LinkItem(String name, String link) {
            this.name = name;
            this.link = link;
        }

        public LinkItem(Integer id, String name, String link) {
            if (id == null) {
                id = -1;
            }
            this.id = id;
            this.name = name;
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
