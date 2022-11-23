package io.ptoj3ct.telegrambotspring.data;

import io.ptoj3ct.telegrambotspring.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
}
