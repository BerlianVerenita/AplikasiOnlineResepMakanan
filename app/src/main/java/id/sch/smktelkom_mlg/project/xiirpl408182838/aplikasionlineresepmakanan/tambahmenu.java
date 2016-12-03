package id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.adapter.CustomAdapter;
import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.helper.FirebaseHelper;
import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.model.Resep;


public class tambahmenu extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper helper;
    CustomAdapter adapter;
    Resep resep;
    RecyclerView rv;
    private EditText etNama;
    private EditText etBahan;
    private EditText etDeskripsi;
    private EditText etCaraMembuat;
    private Button buttonSave;
    private TextView tvResep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahmenu);

        Firebase.setAndroidContext(this);
        buttonSave = (Button) findViewById(R.id.buttonSimpan);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etBahan = (EditText) findViewById(R.id.editTextBahan);
        etDeskripsi = (EditText) findViewById(R.id.editTextDeskripsi);
        etCaraMembuat = (EditText) findViewById(R.id.editTextStep);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Judul = etNama.getText().toString();
                String desc = etDeskripsi.getText().toString();
                String step = etCaraMembuat.getText().toString();
                String bahan = etBahan.getText().toString();

                Resep s = new Resep();
                s.setJudul(Judul);
                s.setDeskripsi(desc);
                s.setStep(step);

                if (Judul.length() > 0 && Judul != null) {
                    if (helper.save(s)) {
                        etNama.setText("");
                        adapter = new ArrayAdapter<String>(DaftarResep.class, android.R.layout.simple_list_item_2, helper.retrive());
                        rv.setAdapter(adapter);
                    }
                }

            }
        });
    }
}
