package manyToMany.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aId")
    private int id;
    @Column(name = "aName")
    private String authorName;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "author")
//    @JoinColumn(name = "bId")
    private List<BookVo> books ;

}
