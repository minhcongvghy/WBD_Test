package com.codegym.test.controller;

import com.codegym.test.message.request.FileForm;
import com.codegym.test.message.response.ResponseMessage;
import com.codegym.test.model.Diary;
import com.codegym.test.service.IDiaryService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class FileRestAPI {
    @Autowired
    private IDiaryService diaryService;

    @Autowired
    Environment env;

    @PostMapping(value = "/file/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<?> uploadFile(@ModelAttribute FileForm fileForm, BindingResult result, @PathVariable Long id) throws IOException {
        if(result.hasErrors()) {
            return new ResponseEntity<>(new ResponseMessage("Upload File Fail!"),HttpStatus.BAD_REQUEST);
        }

        MultipartFile multipartFile = fileForm.getFile();
        String typeFile = getExtensionByApacheCommonLib(multipartFile.getOriginalFilename());
        File convFile = convert(multipartFile);
        byte[] fileContent = FileUtils.readFileToByteArray(convFile);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
//        String fileName = multipartFile.getOriginalFilename();
//        String fileUpload = env.getProperty("file_upload").toString();
//
//        try {
//            FileCopyUtils.copy(fileForm.getFile().getBytes(), new File(fileUpload + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
        Optional<Diary> diary = diaryService.findById(id);
        if(!diary.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        diary.get().setFile(encodedString);
        diary.get().setTypeFile("data:image/" + typeFile + ";base64");
        diaryService.save(diary.get());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public File convert(MultipartFile file) throws IOException {

        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public String getExtensionByApacheCommonLib(String filename) {
        return FilenameUtils.getExtension(filename);
    }
}
