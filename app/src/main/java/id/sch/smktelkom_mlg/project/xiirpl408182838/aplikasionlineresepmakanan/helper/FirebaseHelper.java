package id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.helper;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.model.Resep;

/**
 * Created by Keni Amalia on 19-Nov-16.
 */

public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved;
    ArrayList<Resep> resep = new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    public Boolean save(Resep resep) {
        if (resep == null) {
            saved = false;
        } else {
            try {
                db.child("Resep").push().setValue(resep);
                saved = true;
            } catch (DatabaseException e) {
                e.printStackTrace();
                saved = false;
            }
        }
        return saved;
    }

    private void fetchData(DataSnapshot dataSnapshot) {
        resep.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Resep resept = ds.getValue(Resep.class);
            resep.add(resept);
        }
    }

    public ArrayList<Resep> retrive() {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return resep;
    }

}
