package com.example.handlingformsubmission;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HandlingFormSubmissionApplication {

	public static void main(String[] args) throws IOException {

		ClassLoader classLoader = HandlingFormSubmissionApplication.class.getClassLoader();
	
		File file =new File(Objects.requireNonNull(classLoader.getResource("resourceFile.json")).getFile());
			FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
		


		FirebaseOptions options = new FirebaseOptions.Builder()
			.setCredentials(GoogleCredentials.fromStream(serviceAccount))
			.setDatabaseUrl("https://trial-6b9c1-default-rtdb.firebaseio.com")
			.build();
		  
		FirebaseApp.initializeApp(options);

		SpringApplication.run(HandlingFormSubmissionApplication.class, args);
	}

}
