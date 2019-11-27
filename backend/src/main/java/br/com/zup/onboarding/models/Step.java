package br.com.zup.onboarding.models;

//Importações necessárias
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Step implements Serializable {
    private static final long serialVersionUID = 1L;

    //Propriedades da classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @NotNull
    private String stepName;
    private String description;
    @NotNull
    private String duration;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Theme> theme;

    //Construtores da classe
    public Step() { }

    //Getters e setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStepName() {
        return stepName;
    }
    public void setStepName(String stepName) {
        this.stepName = stepName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public List<Theme> getTheme() {
        return this.theme;
    }
    public void setTheme(List<Theme> theme) {
        this.theme = theme;
    }
}
