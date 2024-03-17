package recipe.backend.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;

import recipe.backend.entity.UserAccount;

public interface UserAccountDao {
    Integer getUserAccountSize();
    Page<UserAccount> getUserAccount(Integer pageSize, Integer page);
    UserAccount getUserAccount(Long id);
    UserAccount save(UserAccount UserAccount);
    Optional<UserAccount> findById(Long id);
}
