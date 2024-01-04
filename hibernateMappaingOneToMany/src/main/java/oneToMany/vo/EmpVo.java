package oneToMany.vo;

import javax.persistence.*;

@Entity
@Table(name = "empData")
public class EmpVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    private int id;
    @Column(name = "empFn")
    private String fristname;
    @Column(name = "empLn")
    private String lastname;
    @Column(name = "empEmail")
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comId")
    private CompanyVo company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFristname() {
        return fristname;
    }

    public void setFristname(String fristname) {
        this.fristname = fristname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
