package com.farmer.database.farmerdb.Controllers;

import com.farmer.database.farmerdb.Services.ImageBucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping("/storage/")
public class ImageBucketController {

    private ImageBucketService amazonClient;

    @Autowired
    ImageBucketController(ImageBucketService imageBucketService){
        this.amazonClient = imageBucketService;
    }

    @PostMapping("/uploadFile/{CustomerID}")
    public String uploadFileWithDirName(@RequestPart(value = "file")MultipartFile file,@PathVariable int CustomerID){
        return amazonClient.uploadFile(file,CustomerID);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

    @GetMapping("/GetImagesForCustomer/{id}")
    public List<String> getAllImagesOfCustomer(@PathVariable int id){
        return amazonClient.GetFolderImages(id);
    }

    @GetMapping("/download/{keyname}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String keyname){
        ByteArrayOutputStream downloadInputStream = amazonClient.downloadFile(keyname);

        return ResponseEntity.ok()
                .contentType(contentType(keyname))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + keyname + "\"")
                .body(downloadInputStream.toByteArray());
    }

    private MediaType contentType(String keyname) {
        String[] arr = keyname.split("\\.");
        String type = arr[arr.length-1];
        switch(type) {
            case "txt": return MediaType.TEXT_PLAIN;
            case "png": return MediaType.IMAGE_PNG;
            case "jpg": return MediaType.IMAGE_JPEG;
            default: return MediaType.APPLICATION_OCTET_STREAM;
        }
    }

}
