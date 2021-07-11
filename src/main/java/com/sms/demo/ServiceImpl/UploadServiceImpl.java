package com.sms.demo.ServiceImpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sms.demo.Service.UploadService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService{

    @Override
    public String singleFileUpload(MultipartFile file, String folder) {
        if(file.isEmpty()){
			return null;
		}

        if(folder == null || folder.isEmpty()){
            folder = "";
        }

		File path = new File("/Users/yanrithy/Desktop/SourceCode/Projects/SMS/src/main/resources/static/image/" + folder);
		if(!path.exists()){
			path.mkdirs();
		}

		String filename = file.getOriginalFilename();
		String extension = filename.substring(filename.lastIndexOf('.'));

		filename = UUID.randomUUID() +  "" + extension;
		try {
			Files.copy(file.getInputStream(), Paths.get("/Users/yanrithy/Desktop/SourceCode/Projects/SMS/src/main/resources/static/image/" + folder, filename));
		} catch (Exception e) {
		
		}

        return folder + filename;
    }

    @Override
    public List<String> multipartfile(List<MultipartFile> files, String folder) {

        List<String> filenames = new ArrayList<>();
        files.forEach(file -> {
            filenames.add(this.singleFileUpload(file, folder));
        });
        return filenames;
    }

    @Override
    public String upload(MultipartFile file, String folder) {
        return this.singleFileUpload(file, folder);
    }

    @Override
    public List<String> upload(List<MultipartFile> files, String folder) {
        return this.multipartfile(files, folder);
    }

    @Override
    public String upload(MultipartFile file) {
        return this.singleFileUpload(file, null);
    }

    @Override
    public List<String> upload(List<MultipartFile> files) {
        return this.multipartfile(files, null);
    }
    
}
