package recipe.backend.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import recipe.backend.entity.Folder;

public interface FolderService {
    Integer getFolderSize();
    Page<Folder> getFolder(Integer pageSize, Integer page);
    Folder getFolder(Long id);
    Folder save(Folder folder);
    Page<Folder> getFolder(Long userAccountId, Pageable pageable);
}
