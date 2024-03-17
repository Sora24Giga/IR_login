package recipe.backend.dao;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import recipe.backend.entity.Folder;
import recipe.backend.repository.FolderRepository;
import recipe.backend.repository.UserAccountRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class FolderDaoImpl implements FolderDao{
    final FolderRepository folderRepository;
    final UserAccountRepository userRepository;

    @Override
    public Integer getFolderSize() {
        return Math.toIntExact(folderRepository.count());
    }

    @Override
    public Page<Folder> getFolder(Integer pageSize, Integer page) {
        return folderRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Folder getFolder(Long id) {
        return folderRepository.findById(id).orElse(null);
    }

    @Override
    public Folder save(Folder folder) {
        return folderRepository.save(folder);
    }

    @Override
    public Page<Folder> getFolder(Long userAccountId, Pageable page) {
        try{
            return folderRepository.findByUserAccountId(Long.valueOf(userAccountId), page);
        } catch(NumberFormatException e){
            return folderRepository.findAll(page);
        }
    }

    @Override
    public Optional<Folder> findById(Long id){
        return folderRepository.findById(id);
    }

}
