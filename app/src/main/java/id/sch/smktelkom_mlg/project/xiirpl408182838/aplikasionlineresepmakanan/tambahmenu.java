package id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.helper.FirebaseHelper;

import static id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.DaftarResep.DB_URL;


public class tambahmenu extends AppCompatActivity {

    FirebaseHelper helper;
    RecyclerView rv;
    EditText etNama;
    EditText etDeskripsi;
    EditText etCaraMembuat;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahmenu);

        buttonSave = (Button) findViewById(R.id.buttonSimpan);
        etNama = (EditText) findViewById(R.id.editTextJudul);
        etDeskripsi = (EditText) findViewById(R.id.editTextDeskripsi);
        etCaraMembuat = (EditText) findViewById(R.id.editTextStep);

        helper = new FirebaseHelper(this, DB_URL, rv);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                helper.saveOnline(etNama.getText().toString(), etCaraMembuat.getText().toString(), etDeskripsi.getText().toString());
                etNama.setText("");
                etCaraMembuat.setText("");
                etDeskripsi.setText("");

            }
        });
    }
}

