package br.com.zup.onboarding.api.Append;

//Importações necessárias
import java.util.List;
import com.fasterxml.jackson.annotation.*;

//Classe para criação de questões
public class CreateQuestion {
	//Propriedades da questão
	private String description;
	private List<AlternativePart> alternatives;

	//Método para pegar as informações do json da questão
	@JsonCreator
	public CreateQuestion(@JsonProperty("description") String description,
						  @JsonProperty("alternatives") List<AlternativePart> alternatives) {
		this.description = description;
		this.alternatives = alternatives;
	}

	//Getters e Setters da classe
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<AlternativePart> getAlternatives() {
		return alternatives;
	}
	public void setAlternatives(List<AlternativePart> alternatives) {
		this.alternatives = alternatives;
	}

	//??
	public static class AlternativePart {
		private String description;
		private Boolean correct;

		@JsonCreator
		public AlternativePart(@JsonProperty("description") String description,
				@JsonProperty("correct") Boolean correct) {
			this.description = description;
			this.correct = correct;
		}

		public String getDescription() {
			return description;
		}
		public Boolean isCorrect() {
			return correct;
		}
		public Boolean getCorrect() {
			return correct;
		}
		public void setCorrect(Boolean correct) {
			this.correct = correct;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}
}
