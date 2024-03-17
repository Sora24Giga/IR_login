package recipe.backend.service;

import lombok.RequiredArgsConstructor;
import recipe.backend.dao.UserAccountDao;
import recipe.backend.entity.UserAccount;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService{
    final UserAccountDao userAccountDao;
    @Override
    public Integer getUserAccountSize() {
        return userAccountDao.getUserAccountSize();
    }

    @Override
    public Page<UserAccount> getUserAccount(Integer pageSize, Integer page) {
        return userAccountDao.getUserAccount(pageSize, page);
    }

    @Override
    public UserAccount getUserAccount(Long id) {
        return userAccountDao.getUserAccount(id);
    }

    @Override
    @Transactional
    public UserAccount save(UserAccount announcement) {
        return userAccountDao.save(announcement);
    }

}