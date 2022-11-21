package io.ptoj3ct.telegrambotspring.data;

import io.ptoj3ct.telegrambotspring.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
