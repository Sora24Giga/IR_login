package recipe.backend.dao;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import recipe.backend.entity.UserAccount;
import recipe.backend.repository.UserAccountRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class UserAccountDaoImpl implements UserAccountDao{
    final UserAccountRepository userAccountRepository;

    @Override
    public Integer getUserAccountSize() {
        return Math.toIntExact(userAccountRepository.count());
    }

    @Override
    public Page<UserAccount> getUserAccount(Integer pageSize, Integer page) {
        return userAccountRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public UserAccount getUserAccount(Long id) {
        return userAccountRepository.findById(id).orElse(null);
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findById(Long id){
        return userAccountRepository.findById(id);
    }

}
