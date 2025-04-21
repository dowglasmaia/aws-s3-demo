package com.dowglasmaia.demoAwsS3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class S3Service {

    @Value("${aws.bucket-name}")
    private String bucketeName;

    private AmazonS3 amazonS3;

    @Autowired
    public S3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public void uploadPdf(String fileName, MultipartFile file){
       try {
           ObjectMetadata  metadata = new ObjectMetadata();
           metadata.setContentType("application/pdf");
           metadata.setContentLength(file.getSize());

           amazonS3.putObject(bucketeName,fileName,file.getInputStream(),metadata);

       } catch (Exception e) {
           throw  new RuntimeException("Failed to upload PDF to s3", e);
       }
    }
}
