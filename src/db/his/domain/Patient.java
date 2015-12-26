package db.his.domain;

/**
 * Created by lwt on 2015/12/6.
 */
public class Patient {

   private String id;
   private String record_id;
    //病历id
   private String file_id;
    //医保
   private String insurance_id;
   private String operation_consent_id;
    //姓名
   private String name;
    //性别
   private String sex;
    //年龄
   private String age;
    //密码
   private String password;

   private String card_id;
   private String case_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(String insurance_id) {
        this.insurance_id = insurance_id;
    }

    public String getOperation_consent_id() {
        return operation_consent_id;
    }

    public void setOperation_consent_id(String operation_consent_id) {
        this.operation_consent_id = operation_consent_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCase_id() {
        return case_id;
    }

    public void setCase_id(String case_id) {
        this.case_id = case_id;
    }

    public Patient() {
    }

    public Patient(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
