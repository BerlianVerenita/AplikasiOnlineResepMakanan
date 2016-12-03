package id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.R;
import id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan.model.Resep;

/**
 * Created by Keni Amalia on 19-Nov-16.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    ArrayList<Resep> resepList;
    Context c;


    public CustomAdapter(Context c, ArrayList<Resep> resepList) {
        this.c = c;
        this.resepList = resepList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdaftar, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Resep resep = resepList.get(position);
        holder.nameTxt.setText(resep.getJudul());
        holder.proptxt.setText(resep.getDeskripsi());
    }

    @Override
    public long getItemId(int position) {

        return position;

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTxt;
        TextView proptxt;

        public ViewHolder(View itemView) {
            super(itemView);
            TextView nameTxt = (TextView) itemView.findViewById(R.id.textViewJudul);
            TextView propTxt = (TextView) itemView.findViewById(R.id.textViewLihat);
            // ImageView imgRsp = (ImageView) convertView.findViewById(R.id.imageView);

        }
    }
}
