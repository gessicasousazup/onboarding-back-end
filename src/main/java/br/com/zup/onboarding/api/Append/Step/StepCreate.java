package br.com.zup.onboarding.api.Append.Step;

import java.util.List;

import br.com.zup.onboarding.models.Alternative;
import br.com.zup.onboarding.models.Question;
import com.fasterxml.jackson.annotation.*;

public class StepCreate {
    private String stepName;
    private String description;
    private String duration;
    private List<Question> questions;

    @JsonCreator
    public StepCreate(@JsonProperty("name") String stepName,
                      @JsonProperty("description") String description,
                      @JsonProperty("duration") String duration,
                      @JsonProperty("questions") List<Question> questions) {

        this.stepName = stepName;
        this.description = description;
        this.duration = duration;
        this.questions = questions;
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
    public List<Question> getQuestion() {
        return questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public static class QuestionPart {
        private String description;
        private List<Alternative> alternatives;

        @JsonCreator
        public QuestionPart(@JsonProperty("description")String description,
                            @JsonProperty("alternatives") List<Alternative> alternatives) {

            this.description = description;
            this.alternatives = alternatives;
        }

        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public List<Alternative> getAlternatives() {
            return alternatives;
        }
        public void setAlternatives(List<Alternative> alternatives) {
            this.alternatives = alternatives;
        }
    }
}