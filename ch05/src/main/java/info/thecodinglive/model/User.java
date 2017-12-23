package info.thecodinglive.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by ysj on 2017-12-06.
 */
public class User {
    private Integer userNo;
    private String userId;
    private String email;
    private String uname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date regDate;

    public User() {
    }

    public User(Integer userNo, String userId, String email, String uname, Date regDate) {
        this.userNo = userNo;
        this.userId = userId;
        this.email = email;
        this.uname = uname;
        this.regDate = regDate;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
