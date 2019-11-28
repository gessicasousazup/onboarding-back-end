package br.com.zup.onboarding.api.Append.Step;

import java.util.List;
import br.com.zup.onboarding.models.Question;
import com.fasterxml.jackson.annotation.*;

public class StepCreate {
    private String stepName;
    private String description;
    private String duration;
    private List<ThemePart> themes;

    @JsonCreator
    public StepCreate(@JsonProperty("name") String stepName,
                      @JsonProperty("description") String description,
                      @JsonProperty("duration") String duration,
                      @JsonProperty("theme") List<ThemePart> theme) {

        this.stepName = stepName;
        this.description = description;
        this.duration = duration;
        this.themes = theme;
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
    public List<ThemePart> getThemes() {
        return themes;
    }
    public void setThemes(List<ThemePart> themes) {
        this.themes = themes;
    }

    public static class ThemePart {
        private String nameTheme;
        private String description;
        private List<Question> questions;

        @JsonCreator
        public ThemePart(@JsonProperty("name") String nameTheme,
                         @JsonProperty("description")String description,
                         @JsonProperty("questions") List<Question> questions) {

            this.nameTheme = nameTheme;
            this.description = description;
            this.questions = questions;
        }

        public String getNameTheme() {
            return nameTheme;
        }
        public void setNameTheme(String nameTheme) {
            this.nameTheme = nameTheme;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public List<Question> getQuestions() {
            return questions;
        }
        public void setQuestions(List<Question> questions) {
            this.questions = questions;
        }
    }
}