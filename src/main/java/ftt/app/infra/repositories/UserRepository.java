package ftt.app.infra.repositories;

import ftt.app.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNicknameAndPassword(String nickname, String password);
}
