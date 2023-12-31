package manyToMany.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bId")
    private int bId;
    @Column(name = "bName")
    private String bName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Book_Author",
            joinColumns = @JoinColumn(name = "bId"),
            inverseJoinColumns = @JoinColumn(name = "aId")
    )
    private List<AuthorVo> author;

}
