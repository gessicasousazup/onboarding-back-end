package br.com.zup.onboarding.services;

import br.com.zup.onboarding.api.Append.Question.QuestionCreate;
import br.com.zup.onboarding.api.Append.Step.StepCreate;
import br.com.zup.onboarding.api.Append.Theme.ThemeCreate;
import br.com.zup.onboarding.models.Alternative;
import br.com.zup.onboarding.models.Question;
import br.com.zup.onboarding.models.Step;
import br.com.zup.onboarding.models.Theme;
import br.com.zup.onboarding.repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StepService {
    @Autowired
    private StepRepository stepRepository;

    @Autowired
    public Iterable<Step> showAllSteps() { return stepRepository.findAll(); }
    public long quantitySteps() { return stepRepository.count(); }
    public Step takeStepById(long id) { return stepRepository.findById(id).get(); }

    public Step createStep(StepCreate stepInput) {
        Step step = new Step();

        step.setStepName(stepInput.getStepName());
        step.setDescription(stepInput.getDescription());
        step.setDuration(stepInput.getDuration());
        step.setTheme(stepInput.getThemes().stream().map(themePart -> {
            Theme theme = new Theme();

            theme.setThemeName(themePart.getNameTheme());
            theme.setDescription(themePart.getDescription());
            theme.setQuestions(themePart.getQuestions());
            theme.setQuestions(themePart.getQuestions().stream().map(questionPart -> {
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

            return theme;
        }).collect(Collectors.toList()));

        stepRepository.save(step);
        return step;
    }


}
