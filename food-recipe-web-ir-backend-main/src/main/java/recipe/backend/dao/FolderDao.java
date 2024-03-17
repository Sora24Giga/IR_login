package recipe.backend.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import recipe.backend.entity.Folder;

public interface FolderDao {
    Integer getFolderSize();
    Page<Folder> getFolder(Integer pageSize, Integer page);
    Folder getFolder(Long id);
    Folder save(Folder Folder);
    Page<Folder> getFolder(Long userAccountId, Pageable page);
    Optional<Folder> findById(Long id);
}
