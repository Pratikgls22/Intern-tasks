package oneToOne.vo;

import javax.persistence.*;

@Entity
@Table(name = "loginVoData")
public class LoginVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loginId")
    private int id;
    @Column(name = "loginEmail")
    private String email;
    @Column(name = "loginPass")
    private String pass;

    @ManyToOne(cascade = CascadeType.ALL)
    private RegVo regVo;

    public RegVo getRegVo() {
        return regVo;
    }

    public void setRegVo(RegVo regVo) {
        this.regVo = regVo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
