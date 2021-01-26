package guru.springframework.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne   // No Cascade because when we delete Ingredients, we dont want to delete Recipe
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMesaure unitOfMesaure;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMesaure getUnitOfMesaure() {
        return unitOfMesaure;
    }

    public void setUnitOfMesaure(UnitOfMesaure unitOfMesaure) {
        this.unitOfMesaure = unitOfMesaure;
    }
}
