package id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.adapter.CustomAdapter;
import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.helper.FirebaseHelper;
import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.model.Resep;

public class DaftarResep extends AppCompatActivity {

    final static String DB_URL = "https://aplikasionlineresepmakanan.firebaseio.com/";
    DatabaseReference db;
    FirebaseHelper helper;
    CustomAdapter adapter;
    RecyclerView rv;
    ArrayList<Resep> mList = new ArrayList<>();
    EditText etJudul, etDeskripsi, etStep;
    Button saveBtn;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_resep);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = (RecyclerView) findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(this));

        helper = new FirebaseHelper(this, DB_URL, rv);
        FirebaseHelper.refreshData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(DaftarResep.this, tambahmenu.class));
                displayDialog();
            }
        });
    }

    private void displayDialog() {
        Dialog d = new Dialog(this);
        d.setTitle("Save Online");
        d.setContentView(R.layout.dialoglayout);
        etJudul = (EditText) d.findViewById(R.id.judulEditText);
        etDeskripsi = (EditText) d.findViewById(R.id.descEditText);
        etStep = (EditText) d.findViewById(R.id.stepEditText);
        saveBtn = (Button) d.findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseHelper.saveOnline(etJudul.getText().toString(), etDeskripsi.getText().toString(), etStep.getText().toString());
                etJudul.setText("");
                etDeskripsi.setText("");
                etStep.setText("");
            }
        });
        //SHOW
        d.show();
    }
}
