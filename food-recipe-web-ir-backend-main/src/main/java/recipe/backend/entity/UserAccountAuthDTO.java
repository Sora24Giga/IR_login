package recipe.backend.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import recipe.backend.security.user.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountAuthDTO {
    Long id;
    String username;
    List<FolderDTO> folder;
    @Builder.Default
    List<Role> roles = new ArrayList<>();
}