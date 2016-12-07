package id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.adapter.CustomAdapter;
import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.helper.FirebaseHelper;

public class DaftarResep extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD = 88;
    final static String DB_URL = "https://aplikasionlineresepmakanan.firebaseio.com/";
    FirebaseHelper helper;
    CustomAdapter adapter;
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
        helper.refreshData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAdd();

            }
        });

    }

    private void goAdd() {
        startActivityForResult(new Intent(this, tambahmenu.class), REQUEST_CODE_ADD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {

        }
    }
}
