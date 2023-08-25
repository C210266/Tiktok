package ra.projectmodule4.model;

import org.springframework.web.multipart.MultipartFile;

public class Video {
    private int id;
    private int like;
    private String cmt;
    private Long userId;
    private String videoUrl;
    private String title;
    private String description;

    public Video(int id, int like, String cmt, Long userId, String videoUrl, String title, String description) {
        this.id = id;
        this.like = like;
        this.cmt = cmt;
        this.userId = userId;
        this.videoUrl = videoUrl;
        this.title = title;
        this.description = description;
    }

    public Video() {
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public int getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
