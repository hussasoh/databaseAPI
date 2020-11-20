package com.farmer.database.farmerdb.ImageHandler;

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

    @PostMapping("/uploadCustomerFile/{CustomerID}")
    public String uploadCustomerFileWithDirName(@RequestPart(value = "file")MultipartFile file,@PathVariable int CustomerID){
        return amazonClient.uploadCustomerFile(file,CustomerID);
    }

    @PostMapping("/uploadFarmFile/{FarmID}")
    public String uploadFarmFileWithDirName(@RequestPart(value = "file")MultipartFile file,@PathVariable int FarmID){
        return amazonClient.uploadFarmFile(file,FarmID);
    }

    @PutMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

    @GetMapping("/GetImagesForCustomer/{id}")
    public List<String> getAllImagesOfCustomer(@PathVariable int id){
        return amazonClient.GetCustomerFolderImages(id);
    }

    @GetMapping("/GetImagesForFarm/{id}")
    public List<String> getAllImagesOfFarm(@PathVariable int id){
        return amazonClient.GetFarmFolderImages(id);
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
