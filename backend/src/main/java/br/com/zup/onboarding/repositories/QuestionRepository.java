package br.com.zup.onboarding.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.onboarding.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long>  {

}
