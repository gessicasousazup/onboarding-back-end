package br.com.zup.onboarding.api.Append.Step;

import java.util.List;

import br.com.zup.onboarding.models.Alternative;
import com.fasterxml.jackson.annotation.*;

public class StepCreate {
	private String stepName;
	private String description;
	private String duration;
	private List<QuestionPart> question;

	@JsonCreator
	public StepCreate(@JsonProperty("name") String stepName, @JsonProperty("description") String description,
			@JsonProperty("duration") String duration, @JsonProperty("question") List<QuestionPart> question) {

		this.stepName = stepName;
		this.description = description;
		this.duration = duration;
		this.question = question;
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

	public List<QuestionPart> getQuestion() {
		return question;
	}

	public void setQuestion(List<QuestionPart> question) {
		this.question = question;
	}

	public static class QuestionPart {
		private String description;
		private List<Alternative> alternative;

		@JsonCreator
		public QuestionPart(@JsonProperty("description") String description,
				@JsonProperty("Alternative") List<Alternative> alternative) {

			this.description = description;
			this.alternative = alternative;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<Alternative> getAlternative() {
			return alternative;
		}

		public void setAlternative(List<Alternative> alternative) {
			this.alternative = alternative;
		}

	}
}