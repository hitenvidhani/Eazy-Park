package com.example.handlingformsubmission;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.v1.FirestoreClient;
import com.google.firestore.v1.Document;

@Service
public class WorkerService {

	public String createCRUD(Worker w) throws ExecutionException, InterruptedException {
		Firestore dbFirestore = com.google.firebase.cloud.FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Workers").document(w.getName())
				.set(w);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public String updateCRUD(Spot crud) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = com.google.firebase.cloud.FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Workers").document(crud.getName())
				.set(crud);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public String deleteCRUD(String name) throws ExecutionException, InterruptedException {
		Firestore dbFirestore = com.google.firebase.cloud.FirestoreClient.getFirestore();
		ApiFuture<WriteResult> documentReference = dbFirestore.collection("Workers").document(name).delete();
		return "Successfully deleted" + name;
	}

	public String getAllCRUD() throws InterruptedException, ExecutionException {
		Firestore dbFirestore = com.google.firebase.cloud.FirestoreClient.getFirestore();
		CollectionReference collectionReference = dbFirestore.collection("Workers");
		ApiFuture<QuerySnapshot> future = collectionReference.get();

		String s = "";

		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			s = s + (document.getId() + "|") ;
			System.out.println(document.getId());
		}
		System.out.println(s);

		return s;

	}

	public Worker getCRUD(String name) throws ExecutionException, InterruptedException {
		Firestore dbFirestore = com.google.firebase.cloud.FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("Workers").document(name);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		Worker crud;
		if (document.exists()) {
			crud = document.toObject(Worker.class);
			return crud;
		}
		return null;
	}

}