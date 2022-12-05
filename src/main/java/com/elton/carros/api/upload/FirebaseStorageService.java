package com.elton.carros.api.upload;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

//https://firebase.google.com/docs/storage/admin/start
@Service
public class FirebaseStorageService {

    @PostConstruct
    private void init() throws IOException {

        if (FirebaseApp.getApps().isEmpty()) {
            InputStream in =
                    FirebaseStorageService.class.getResourceAsStream("/carros-api-4f356-firebase-adminsdk-tp5cn-67168b086c.json");

            System.out.println(in);

            System.out.println(in);

            if(in != null) {
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(in))
                        .setStorageBucket("carros-api-4f356.appspot.com")
                        .setDatabaseUrl("https://seu-projeto.firebaseio.com")
                        .build();

                FirebaseApp.initializeApp(options);
            } else {
                System.err.println("Configure o arquivo serviceAccountKey.json do Firebase NOT FOUND!");
            }
        }
    }

    public String upload(UploadInput uploadInput) {

        Bucket bucket = StorageClient.getInstance().bucket();
        System.out.println(bucket);

//        Blob blob = bucket.create("nome.txt","Elton Luiz Firebases".getBytes(), "text/html");

        byte[] bytes = Base64.getDecoder().decode(uploadInput.getBase64());

        String fileName = uploadInput.getFileName();
        Blob blob = bucket.create(fileName,bytes, uploadInput.getMimeType());

        // Assina URL válida por N dias
        //URL signedUrl = blob.signUrl(1, TimeUnit.DAYS);

        // Deixa URL pública
        blob.createAcl(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));

        return String.format("https://storage.googleapis.com/%s/%s",bucket.getName(),fileName);
    }
}

/**
 service firebase.storage {
 match /b/{bucket}/o {
 match /{allPaths=**} {
 allow read, write: if request.auth != null;
 }
 }
 }
*/

/**
 service firebase.storage {
 match /b/{bucket}/o {
 match /{allPaths=**} {
 allow write: if request.auth != null;
 }
 match /{allPaths=**} {
 allow read;
 }
 }
 }
**/