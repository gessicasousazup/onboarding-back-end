package br.com.zup.onboarding.api;

import br.com.zup.onboarding.api.Append.Question.QuestionCreate;
import br.com.zup.onboarding.api.Append.Question.QuestionRepresentation;
import br.com.zup.onboarding.api.Append.Step.StepCreate;
import br.com.zup.onboarding.api.Append.Step.StepRepresentation;
import br.com.zup.onboarding.models.Question;
import br.com.zup.onboarding.models.Step;
import br.com.zup.onboarding.services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/step")
public class StepController {
    @Autowired
    private StepService stepService;

    @GetMapping("/")
    public ResponseEntity<?> showSteps(HttpSession session) {
        if (stepService.quantitySteps() > 0) return ResponseEntity.ok(stepService.showAllSteps());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showStepsById(@PathVariable long id) {
        try {
            Step step = stepService.takeStepById(id);

            StepRepresentation representation = new StepRepresentation();
            representation.setId(step.getId());

            return ResponseEntity.ok(representation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<StepRepresentation> saveStep(@Valid @RequestBody StepCreate step) {
        try {
            Step newStep = stepService.createStep(step);
            StepRepresentation representation = new StepRepresentation();
            representation.setId(newStep.getId());

            return ResponseEntity.status(HttpStatus.CREATED).body(representation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStep(@PathVariable long id) {
        try {
            stepService.deleteStep(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
