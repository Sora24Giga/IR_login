package recipe.backend.service;

import lombok.RequiredArgsConstructor;
import recipe.backend.dao.FolderDao;
import recipe.backend.dao.UserAccountDao;
import recipe.backend.entity.Folder;
import recipe.backend.entity.UserAccount;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService{
    final FolderDao folderDao;
    final UserAccountDao userAccountDao;

    @Override
    public Integer getFolderSize() {
        return folderDao.getFolderSize();
    }

    @Override
    public Page<Folder> getFolder(Integer pageSize, Integer page) {
        return folderDao.getFolder(pageSize, page);
    }

    @Override
    public Folder getFolder(Long id) {
        return folderDao.getFolder(id);
    }

    @Override
    @Transactional
    public Folder save(Folder folder) {
        if(folder.getUserAccount() != null && folder.getUserAccount().getId() != null && folder.getUserAccount().getId() != 0){
            UserAccount user = userAccountDao.findById(folder.getUserAccount().getId()).orElse(null);
            user.getFolder().add(folder);
            folder.setUserAccount(user);
        }
        return folderDao.save(folder);
    }

    @Override
    public Page<Folder> getFolder(Long userAccountId, Pageable pageable) {
        return folderDao.getFolder(userAccountId, pageable);
    }

}