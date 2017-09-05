package entity;

/**
 * Created by CodingTest on 2017/7/31.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;

    public User(){}

    public User(String username,String password,String email,String phone) {
        this.username = username;
        this.password=password;
        this.email=email;
        this.phone=phone;
    }

    public User(int id,String username,String password,String email,String phone) {
        this.id=id;
        this.username = username;
        this.password=password;
        this.email=email;
        this.phone=phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
