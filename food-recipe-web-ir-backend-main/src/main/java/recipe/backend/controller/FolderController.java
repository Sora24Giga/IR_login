package recipe.backend.controller;

import lombok.RequiredArgsConstructor;
import recipe.backend.entity.Folder;
import recipe.backend.service.FolderService;
import recipe.backend.util.LabMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FolderController {
    List<Folder> folderList;
    @Autowired
    final FolderService folderService;
    @GetMapping("folder")
    public ResponseEntity<?> getFolderLists(@RequestParam(value ="_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "uid", required = false) Long userAccountId) {
                                                
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Folder> pageOutput;
        if (userAccountId == null) {
            pageOutput = folderService.getFolder(perPage,page);
        }else{
            pageOutput = folderService.getFolder(userAccountId, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getFolderDTO(pageOutput.getContent()),responseHeader,HttpStatus.OK);

    }

    @GetMapping("folder/{id}")
    public ResponseEntity<?> getFolder(@PathVariable("id") Long id) {
        Folder output = folderService.getFolder(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getFolderDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/folder")
    public ResponseEntity<?> addFolder(@RequestBody Folder CommentHistory){
        Folder output = folderService.save(CommentHistory);
        return ResponseEntity.ok(LabMapper.INSTANCE.getFolderDTO(output));
    }

}
