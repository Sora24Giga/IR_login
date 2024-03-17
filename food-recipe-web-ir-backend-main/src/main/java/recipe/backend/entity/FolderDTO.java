package recipe.backend.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FolderDTO {
    Long id;
    String name;
    FolderUADTO userAccount;
    @Builder.Default
    List<String> recipeList = new ArrayList<>();
}
