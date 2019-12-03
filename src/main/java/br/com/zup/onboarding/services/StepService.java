package br.com.zup.onboarding.services;

import br.com.zup.onboarding.api.Append.Step.StepCreate;
import br.com.zup.onboarding.models.Alternative;
import br.com.zup.onboarding.models.Question;
import br.com.zup.onboarding.models.Step;
import br.com.zup.onboarding.repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StepService {
    @Autowired
    private StepRepository stepRepository;

    public Iterable<Step> showAllSteps() { return stepRepository.findAll(); }
    public long quantitySteps() { return stepRepository.count(); }
    public Step takeStepById(long id) { return stepRepository.findById(id).get(); }

    public Step createStep(StepCreate stepInput) {
        Step step = new Step();

        step.setStepName(stepInput.getStepName());
        step.setDescription(stepInput.getDescription());
        step.setDuration(stepInput.getDuration());
        step.setQuestion(stepInput.getQuestion().stream().map(questionPart -> {
            Question question = new Question();

            question.setDescription(questionPart.getDescription());
            question.setAlternatives(questionPart.getAlternatives().stream().map(alternativePart -> {
                Alternative alternative = new Alternative();

                alternative.setDescription(alternativePart.getDescription());
                alternative.setCorrect(alternativePart.isCorrect());

                return alternative;
            }).collect(Collectors.toList()));

            return question;
        }).collect(Collectors.toList()));

        stepRepository.save(step);
        return step;
    }

    public void deleteStep(long id) { stepRepository.deleteById(id); }

    public Step updateStep(long id, Step step) {
        Step stepIntern;
        stepIntern = stepRepository.findById(id).get();

        if (stepIntern != null) {
            step.setId(id);
            return stepRepository.save(step);
        }
        return null;
    }
}
