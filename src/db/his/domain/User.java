package db.his.domain;

/**
 * Created by lwt on 2015/12/17.
 * 通用用户
 */
public class User {
    private String name;
    private String password;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
