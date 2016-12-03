package id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.adapter.CustomAdapter;
import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.model.Resep;

/**
 * Created by Keni Amalia on 19-Nov-16.
 */

public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved;
    ArrayList<Resep> resep = new ArrayList<>();

    Context c;
    String DB_URL;
    RecyclerView rv;
    CustomAdapter adapter;
    Firebase fire;

    public FirebaseHelper(Context c, String DB_URL, RecyclerView rv) {
        this.c = c;
        this.DB_URL = DB_URL;
        this.rv = rv;

        Firebase.setAndroidContext(c);

        fire = new Firebase(DB_URL);
    }

    public void saveOnline(String judul, String step, String desc) {
        Resep r = new Resep();
        r.setJudul(judul);
        r.setDeskripsi(desc);
        r.setStep(step);
        fire.child("Resep").push().setValue(r);
    }

    public void refreshData() {
        fire.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void getUpdates(DataSnapshot dataSnapshot) {
        resep.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Resep r = new Resep();
            r.setJudul(ds.getValue(Resep.class).getJudul());
            r.setDeskripsi(ds.getValue(Resep.class).getDeskripsi());
            r.setStep(ds.getValue(Resep.class).getStep());
            resep.add(r);
        }
        if (resep.size() > 0) {
            adapter = new CustomAdapter(c, resep);
            rv.setAdapter(adapter);
        } else {
            Toast.makeText(c, "No data", Toast.LENGTH_SHORT).show();
        }
    }

}
