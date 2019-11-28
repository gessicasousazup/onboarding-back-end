package br.com.zup.onboarding.repositories;

import br.com.zup.onboarding.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {  }
