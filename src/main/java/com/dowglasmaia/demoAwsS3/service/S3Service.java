package com.dowglasmaia.demoAwsS3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

    @Value("${aws.bucket-name}")
    private String bucketeName;

    private S3Client s3Client;

    @Autowired
    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public void uploadPdf(String fileName, MultipartFile file){
       try {
           PutObjectRequest request = PutObjectRequest.builder()
                           .bucket(bucketeName)
                           .key(fileName)
                           .contentType("application/pdf")
                           .build();

           s3Client.putObject(request, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
       } catch (Exception e) {
           throw  new RuntimeException("Failed to upload PDF to s3", e);
       }
    }
}
