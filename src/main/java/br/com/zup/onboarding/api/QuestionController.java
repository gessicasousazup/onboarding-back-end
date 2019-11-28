package br.com.zup.onboarding.api;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import br.com.zup.onboarding.api.Append.Question.QuestionCreate;
import br.com.zup.onboarding.api.Append.Question.QuestionRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.zup.onboarding.models.Question;
import br.com.zup.onboarding.services.QuestionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@GetMapping("/")
	public ResponseEntity<?> showQuestions(HttpSession session) {
		if (questionService.quantityQuestions() > 0) return ResponseEntity.ok(questionService.showAllQuestions());
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> takeQuestionById(@PathVariable long id) {
		try {
			Question question = questionService.takeQuestionById(id);
			QuestionRepresentation representation = new QuestionRepresentation();
			representation.setId(question.getId());
			return ResponseEntity.ok(representation);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@PostMapping
	public ResponseEntity<QuestionRepresentation> saveQuestion(@Valid @RequestBody QuestionCreate question) {
		try {
			Question newQuestion = questionService.createQuestion(question);
			QuestionRepresentation representation = new QuestionRepresentation();
			representation.setId(newQuestion.getId());

			return ResponseEntity.status(HttpStatus.CREATED).body(representation);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable long id) {
		try {
			questionService.deleteQuestion(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/delete/all")
	public ResponseEntity<?> deleteAllQuestion() {
		if (questionService.quantityQuestions() > 0) {
			questionService.deleteAllQuestion();
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateQuestion(@PathVariable long id, @RequestBody Question question) {
		try {
			return ResponseEntity.ok().body(questionService.updateQuestion(id, question));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/question/{idQuestion}")
	public ResponseEntity<?> getCorrectAlternative(@PathVariable Long idQuestion) {
		try {
			return ResponseEntity.ok().body(questionService.getCorrectAlternative(idQuestion));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/questionAwnser/{idQuestion}/{idAlternative}")
	public ResponseEntity<?> testeMetodo(@PathVariable Long idQuestion, @PathVariable Long idAlternative) {
		try {
			return ResponseEntity.ok().body(questionService.checkCorrectAnswer(idQuestion, idAlternative));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}