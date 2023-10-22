package com.bitc.mvc_board.model;

public class MVCBoardDTO {
    private int postIdx;
    private String postWriter;
    private String postTitle;
    private String postContent;
    private String postDate;
    private String postOfile;
    private String postSfile;
    private String postDnCount;
    private String postPass;
    private int postVisit;

    public int getPostIdx() {
        return postIdx;
    }

    public void setPostIdx(int postIdx) {
        this.postIdx = postIdx;
    }

    public String getPostWriter() {
        return postWriter;
    }

    public void setPostWriter(String postWriter) {
        this.postWriter = postWriter;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getPostOfile() {
        return postOfile;
    }

    public void setPostOfile(String postOfile) {
        this.postOfile = postOfile;
    }

    public String getPostSfile() {
        return postSfile;
    }

    public void setPostSfile(String postSfile) {
        this.postSfile = postSfile;
    }

    public String getPostDnCount() {
        return postDnCount;
    }

    public void setPostDnCount(String postDnCount) {
        this.postDnCount = postDnCount;
    }

    public String getPostPass() {
        return postPass;
    }

    public void setPostPass(String postPass) {
        this.postPass = postPass;
    }

    public int getPostVisit() {
        return postVisit;
    }

    public void setPostVisit(int postVisit) {
        this.postVisit = postVisit;
    }
}
