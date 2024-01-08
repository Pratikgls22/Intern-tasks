package oneToMany.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "empData")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    private int id;
    @Column(name = "empFn")
    private String firstname;
    @Column(name = "empLn")
    private String lastname;
    @Column(name = "empEmail")
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comId")
    private CompanyVo company;
}
