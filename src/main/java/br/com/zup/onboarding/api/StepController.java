package br.com.zup.onboarding.api;

import br.com.zup.onboarding.services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/step")
public class StepController {
    @Autowired
    private StepService stepService;

    @GetMapping("/")
    public ResponseEntity<?> showQuestions(HttpSession session) {
        if (stepService.quantitySteps() > 0) return ResponseEntity.ok(stepService.showAllSteps());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
