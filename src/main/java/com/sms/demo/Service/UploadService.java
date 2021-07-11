package com.sms.demo.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String singleFileUpload(MultipartFile file,String folder);
    List<String> multipartfile(List<MultipartFile> files, String folder);

    String upload(MultipartFile file,String folder);
    List<String> upload(List<MultipartFile> files, String folder);
    String upload(MultipartFile file);
    List<String> upload(List<MultipartFile> files);
}