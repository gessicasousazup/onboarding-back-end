package br.com.zup.onboarding.repositories;

import br.com.zup.onboarding.models.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends CrudRepository<Theme,Long> {  }