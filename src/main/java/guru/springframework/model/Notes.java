package guru.springframework.model;


import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne  // No Cascade because we dont want to delete Recipe when Notes is deleted
    private Recipe recipe;

    //Specifies that a persistent property or field should be persisted as a large object to a database-supported large object type.
    //@javax.persistence.Lob signifies that the annotated field should be represented as BLOB (binary data) in the DataBase.
    //BLOB : Variable-length binary large object string
    //CLOB : Variable-length character large object string
    @Lob
    private String recipeNotes;

}
