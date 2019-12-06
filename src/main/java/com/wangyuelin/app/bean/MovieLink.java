package com.wangyuelin.app.bean;

import java.util.List;

public class MovieLink {
    private long id;
    private LinkType type;
    private List<LinkItem> links;

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

    public static class LinkItem {
        private String name;
        private String link;

        public LinkItem(String name, String link) {
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
