package guru.springframework.model;

import guru.springframework.enums.DifficultyEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

    //Internally JVM generates id for Recipe object.
    //But for Persistence layer, we have to explicitly add id value to Recipe class, now persistence/database will also have id for Recipe class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity generation type will generated ID using persistence framework
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;

    //Specifies that a persistent property or field should be persisted as a large object to a database-supported large object type.
    //@javax.persistence.Lob signifies that the annotated field should be represented as BLOB (binary data) in the DataBase.
    //BLOB : Variable-length binary large object string
    //CLOB : Variable-length character large object string
    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL) // Recipe Owns Notes
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") // Cascading Ingredients because we want to delete Ingredient when we delete Recipe
    private Set<Ingredient> ingredients;

    // EnumType.ORDINAL will save  1, 2 ,3 value for DifficultyEnum constants in DB.
    // EnumType.STRING will save difficultyEnum constants as it as String in DB.
    @Enumerated(value = EnumType.STRING)
    DifficultyEnum difficultyEnum;

    //@JoinTable will create new table based on mappings/relationship
    @ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "category"))
    private Set<Category> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


    public DifficultyEnum getDifficultyEnum() {
        return difficultyEnum;
    }

    public void setDifficultyEnum(DifficultyEnum difficultyEnum) {
        this.difficultyEnum = difficultyEnum;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
