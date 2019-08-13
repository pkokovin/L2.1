package dbService.dataSets;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
public class UsersDataSet implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true, updatable = false)
    private String login;

    @Column(name = "password")
    private String password;

    public UsersDataSet() {
    }

    public UsersDataSet(long id, String login, String password) {
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);

    }

    public UsersDataSet(String login, String password) {
        this.setId(-1);
        this.setLogin(login);
        this.setPassword(password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
