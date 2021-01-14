package co.soft.anonsms.entity;

import javax.persistence.*;

@Entity
@Table(name = "sms_data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phoneNumber;
    private String message;
    private String key;

    public Data() {
    }

    public Data(String phoneNumber, String message, String key) {
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
