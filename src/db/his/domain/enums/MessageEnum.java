package db.his.domain.enums;

/**
 * Created by lwt on 2015/12/10.
 */
public enum MessageEnum {
    ADD_ERROR("0001","注册失败！"),
    ADD_SUCCESS("0000","注册成功！");

    private String code;
    private String name;

    MessageEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}