package recipe.backend.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import recipe.backend.entity.Folder;
import recipe.backend.entity.FolderDTO;
import recipe.backend.entity.UserAccount;
import recipe.backend.entity.UserAccountAuthDTO;
import recipe.backend.entity.UserAccountDTO;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    
    UserAccountDTO getUserDTO(UserAccount userAccount);
    List<UserAccountDTO> getUserDTO(List<UserAccount> userAccount);
    @Mapping(target = "roles", source = "user.roles")
    UserAccountAuthDTO getUserAuthDTO(UserAccount userAccount);

    FolderDTO getFolderDTO(Folder folder);
    List<FolderDTO> getFolderDTO(List<Folder> folder);

}
