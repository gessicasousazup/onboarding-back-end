package br.com.zup.onboarding.api.Append.Theme;

import br.com.zup.onboarding.api.Append.Question.QuestionCreate;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ThemeCreate {
        private String nameTheme;
        private String description;
        private List<QuestionPart> questions;

        @JsonCreator
        public ThemeCreate(@JsonProperty("name") String nameTheme,
                           @JsonProperty("description")String description,
                           @JsonProperty("questions") List<QuestionPart> questions) {

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
        public List<QuestionPart> getQuestions() {
            return questions;
        }
        public void setQuestions(List<QuestionPart> questions) {
            this.questions = questions;
        }

        public static class QuestionPart {
            private String description;
            private List<QuestionCreate.AlternativePart> alternatives;

            @JsonCreator
            public QuestionPart(@JsonProperty("description") String description,
                                @JsonProperty("alternatives") List<QuestionCreate.AlternativePart> alternatives) {

                this.description = description;
                this.alternatives = alternatives;
            }

            public String getDescription() {
                return description;
            }
            public void setDescription(String description) {
                this.description = description;
            }
            public List<QuestionCreate.AlternativePart> getAlternatives() {
                return alternatives;
            }
            public void setAlternatives(List<QuestionCreate.AlternativePart> alternatives) {
                this.alternatives = alternatives;
            }
        }
}
