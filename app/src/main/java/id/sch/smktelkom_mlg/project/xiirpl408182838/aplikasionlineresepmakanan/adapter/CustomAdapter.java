package id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.R;
import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.model.Resep;

/**
 * Created by Keni Amalia on 19-Nov-16.
 */

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Resep> resep;

    public CustomAdapter(Context c, ArrayList<Resep> resep) {
        this.c = c;
        this.resep = resep;
    }

    @Override
    public int getCount() {
        return resep.size();
    }

    @Override
    public Object getItem(int position) {
        return resep.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.activity_daftar_resep, parent, false);
        }

        TextView nameTxt = (TextView) convertView.findViewById(R.id.textViewJudul);
        TextView propTxt = (TextView) convertView.findViewById(R.id.textViewLihat);
        // ImageView imgRsp = (ImageView) convertView.findViewById(R.id.imageView);

        final Resep s = (Resep) this.getItem(position);

        nameTxt.setText(s.getJudul());
        propTxt.setText(s.getDeskripsi());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c, s.getJudul(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
