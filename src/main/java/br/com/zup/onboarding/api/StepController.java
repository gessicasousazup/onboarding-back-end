package br.com.zup.onboarding.api;

import br.com.zup.onboarding.services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/step")
public class StepController {
    @Autowired
    private StepService stepService;


}
