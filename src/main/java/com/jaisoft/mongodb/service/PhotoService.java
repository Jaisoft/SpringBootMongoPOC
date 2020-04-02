package com.jaisoft.mongodb.service;

import com.jaisoft.mongodb.model.Photo;
import com.jaisoft.mongodb.repository.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class PhotoService {

    private PhotoRepository photoRepo;


    public PhotoService(PhotoRepository photoRepo){}



    public Photo getPhoto(String id) {
        return photoRepo.findById(id).get();
    }

    public String addPhoto(String title, MultipartFile file) throws IOException {
        Photo photo = new Photo(title);
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = photoRepo.insert(photo);
        return photo.getId();
    }
}
