package id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.MyHolder;
import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.R;
import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.model.Resep;

/**
 * Created by Keni Amalia on 19-Nov-16.
 */

public class CustomAdapter extends RecyclerView.Adapter<MyHolder> {
    ArrayList<Resep> resepList;
    Context c;

    public CustomAdapter(Context c, ArrayList<Resep> resepList) {
        this.c = c;
        this.resepList = resepList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdaftar, parent, false);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {


        holder.judulTxt.setText(resepList.get(position).getJudul());
        holder.descText.setText(resepList.get(position).getDeskripsi());
        //  holder.imgRsp.setImageBitmap(Uri.parse(resepList.get(position)).getFoto());

    }

    @Override
    public long getItemId(int position) {

        return position;

    }

    @Override
    public int getItemCount() {
        return resepList.size();
    }

    public interface IResepAdapter {
        void doClick(int pos);
    }
}
