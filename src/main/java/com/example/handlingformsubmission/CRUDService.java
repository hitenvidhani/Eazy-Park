package com.example.handlingformsubmission;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.v1.FirestoreClient;
import com.google.firestore.v1.Document;

@Service
public class CRUDService {

	public String createCRUD(Greeting crud) throws ExecutionException,InterruptedException {
		Firestore dbFirestore= com.google.firebase.cloud.FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture=dbFirestore.collection("users").document(crud.getId()).set(crud);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	public String updateCRUD(Greeting crud) throws InterruptedException, ExecutionException {
		Firestore dbFirestore=com.google.firebase.cloud.FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture=dbFirestore.collection("users").document(crud.getId()).set(crud);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	public String deleteCRUD(String user_id) throws ExecutionException,InterruptedException{
		Firestore dbFirestore= com.google.firebase.cloud.FirestoreClient.getFirestore();
		ApiFuture<WriteResult> documentReference=dbFirestore.collection("users").document(user_id).delete();
		return "Successfully deleted" + user_id;
	}
	
	public Greeting getCRUD(String user_id)throws ExecutionException,InterruptedException {
		Firestore dbFirestore= com.google.firebase.cloud.FirestoreClient.getFirestore();
		DocumentReference documentReference=dbFirestore.collection("users").document(user_id);
		ApiFuture<DocumentSnapshot> future=documentReference.get();
		DocumentSnapshot document=future.get();
		Greeting crud;
		if(document.exists()) {
			crud=document.toObject(Greeting.class);
			return crud;
		}
		return null;
	}

}