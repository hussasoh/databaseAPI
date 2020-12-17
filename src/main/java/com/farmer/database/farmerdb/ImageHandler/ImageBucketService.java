package com.farmer.database.farmerdb.ImageHandler;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sohaib Hussain
 * Date Modified: December 14th, 2020
 **/
@Service
public class ImageBucketService {

//    private AmazonS3 amazonS3;
//
//    @Value("${amazonProperties.endpointUrl}")
//    private String endpointUrl;
//
//    @Value("${amazonProperties.bucketName}")
//    private String bucketName;
//
//    @Value("${amazonProperties.accessKey}")
//    private String accessKey;
//
//    @Value("${amazonProperties.secretKey}")
//    private String secretKey;
//
//    @PostConstruct
//    private void InitializeS3(){
//        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey,this.secretKey);
//        this.amazonS3 = AmazonS3ClientBuilder
//                        .standard()
//                        .withCredentials(new AWSStaticCredentialsProvider(credentials))
//                        .withRegion(Regions.US_EAST_2)
//                        .build();
//    }
//
//    private File convertMultiPartToFile(MultipartFile file) throws IOException {
//        File convFile = new File(file.getOriginalFilename());
//        FileOutputStream fos = new FileOutputStream(convFile);
//        fos.write(file.getBytes());
//        fos.close();
//        return convFile;
//    }
//
//    private String generateFileName(MultipartFile multiPart, String dir) {
//        return dir + "/" + multiPart.getOriginalFilename().replace(" ", "_");
//    }
//
//    private void uploadFileToS3bucket(String fileName,File file){
//        amazonS3.putObject(new PutObjectRequest(bucketName ,fileName,file).withCannedAcl(CannedAccessControlList.PublicRead));
//    }
//
//    public String uploadCustomerFile(MultipartFile multipartFile,int CustomerID) {
//        String fileUrl = "";
//        try {
//            File file = convertMultiPartToFile(multipartFile);
//            String fileName = generateFileName(multipartFile,"Customer" + CustomerID);
//            fileUrl = endpointUrl + fileName;
//            uploadFileToS3bucket(fileName, file);
//            file.delete();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fileUrl;
//    }
//    public String uploadFarmFile(MultipartFile multipartFile,int FarmID) {
//        String fileUrl = "";
//        try {
//            File file = convertMultiPartToFile(multipartFile);
//            String fileName = generateFileName(multipartFile,"Farm" + FarmID);
//            fileUrl = endpointUrl + fileName;
//            uploadFileToS3bucket(fileName, file);
//            file.delete();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return fileUrl;
//    }
//
//    public String deleteFileFromS3Bucket(String file) {
//        amazonS3.deleteObject(new DeleteObjectRequest(bucketName,file));
//        return "Successfully deleted";
//    }
//
//    public ByteArrayOutputStream downloadFile(String keyName){
//        try{
//            S3Object s3Object = amazonS3.getObject(new GetObjectRequest(bucketName,keyName));
//            InputStream is = s3Object.getObjectContent();
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            int len;
//            byte[] buffer = new byte[4096];
//            while((len = is.read(buffer,0,buffer.length)) != -1){
//                byteArrayOutputStream.write(buffer,0,len);
//            }
//
//            return byteArrayOutputStream;
//        }catch (Exception ex){
//            System.out.println(ex);
//        }
//
//        throw null;
//    }
//
//    public List<String> GetCustomerFolderImages(int CustomerID){
//        List<String> images = new ArrayList();
//        ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
//                .withBucketName(bucketName)
//                .withPrefix("Customer"+CustomerID)
//                .withMarker("Customer"+CustomerID);
//
//        ObjectListing objectListing = amazonS3.listObjects(listObjectsRequest);
//
//        for(S3ObjectSummary summary: objectListing.getObjectSummaries()){
//            images.add(summary.getKey());
//        }
//
//        return images;
//    }
//
//    public List<String> GetFarmFolderImages(int FarmID){
//        List<String> images = new ArrayList();
//        ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
//                .withBucketName(bucketName)
//                .withPrefix("Farm"+FarmID)
//                .withMarker("Farm"+FarmID);
//
//        ObjectListing objectListing = amazonS3.listObjects(listObjectsRequest);
//
//        for(S3ObjectSummary summary: objectListing.getObjectSummaries()){
//            images.add(summary.getKey());
//        }
//
//        return images;
//    }
}
