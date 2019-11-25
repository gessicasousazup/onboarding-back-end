package br.com.zup.onboarding.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.onboarding.models.Alternative;

@Repository
public interface AlternativeRepository extends CrudRepository<Alternative, Long> {

}
