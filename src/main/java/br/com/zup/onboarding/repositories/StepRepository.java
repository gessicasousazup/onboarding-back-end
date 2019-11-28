package br.com.zup.onboarding.repositories;

import br.com.zup.onboarding.models.Step;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends CrudRepository<Step,Long> {  }
