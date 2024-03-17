package recipe.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import recipe.backend.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    List<UserAccount> findAll();
    List<UserAccount> findById(long id);
}