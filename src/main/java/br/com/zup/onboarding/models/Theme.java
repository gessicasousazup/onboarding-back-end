package br.com.zup.onboarding.models;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Theme implements Serializable {
    private static final long serialVersionUID = 1L;

    //Propriedades da classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String stepName;
    private String description;

    @ManyToOne
    private Step step;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> question;

    //Construtores da classe
    public Theme() { }

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
    public List<Question> getQuestions() {
        return question;
    }
    public void setQuestions(List<Question> question) { this.question = question; }
}
