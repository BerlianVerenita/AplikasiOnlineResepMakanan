package id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.helper.FirebaseHelper;

import static id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.DaftarResep.DB_URL;


public class tambahmenu extends AppCompatActivity {

    public static final int PICK_IMAGE_REQUEST = 234;
    FirebaseHelper helper;
    RecyclerView rv;
    EditText etNama;
    EditText etDeskripsi;
    EditText etCaraMembuat;
    Button buttonSave;
    ImageView imgPick;
    ImageView imgHasil;
    private Uri filepath;

    //private StorageReference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahmenu);

        buttonSave = (Button) findViewById(R.id.buttonSimpan);
        etNama = (EditText) findViewById(R.id.editTextJudul);
        etDeskripsi = (EditText) findViewById(R.id.editTextDeskripsi);
        etCaraMembuat = (EditText) findViewById(R.id.editTextStep);
        imgPick = (ImageView) findViewById(R.id.imageViewFoto);
        imgHasil = (ImageView) findViewById(R.id.imageViewHasil);

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
        imgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChoose();
            }
        });
    }

    private void showFileChoose() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select an Image"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
            filepath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                imgHasil.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

