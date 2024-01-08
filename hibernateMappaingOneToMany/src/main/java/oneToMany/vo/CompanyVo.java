package oneToMany.vo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comData")
public class CompanyVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coId")
    private int id;
    @Column(name = "coDepartment")
    private String department;
    @Column(name = "coPost")
    private String post;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EmpVo> employee;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
