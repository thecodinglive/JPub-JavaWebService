package info.thecodinglive.model;

import java.io.Serializable;


/**
 * Created by yun_dev1 on 2016-07-28.
 */

public class UserVO implements Serializable{
    private String id;
    private String userName;
    private String passWord;

    public UserVO() {
    }

    public UserVO(String id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String passWord) {
        this.passWord = passWord;
    }
}
