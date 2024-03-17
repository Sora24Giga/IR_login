package recipe.backend.service;


import org.springframework.data.domain.Page;
import recipe.backend.entity.UserAccount;

public interface UserAccountService {
    Integer getUserAccountSize();
    Page<UserAccount> getUserAccount(Integer pageSize, Integer page);
    UserAccount getUserAccount(Long id);
    UserAccount save(UserAccount userAccount);
}
