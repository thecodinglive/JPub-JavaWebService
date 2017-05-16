package info.thecodinglive.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * Created by yun_dev1 on 2016-07-28.
 */

public class UserVO implements Serializable{
    private String id;

    @NotNull(message = "userName필드가 null입니다.")
    private String userName;
    private String pwd;

    public UserVO() {
    }

    public UserVO(String id, String userName, String pwd) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

}
