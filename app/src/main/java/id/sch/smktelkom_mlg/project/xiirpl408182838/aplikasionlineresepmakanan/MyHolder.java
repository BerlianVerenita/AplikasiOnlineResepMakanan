package id.sch.smktelkom_mlg.project.xiirpl408182838.aplikasionlineresepmakanan;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Keni Amalia on 03-Dec-16.
 */

public class MyHolder extends RecyclerView.ViewHolder {

    public TextView judulTxt;
    public TextView descText;
    public ImageView imgRsp;
    Button btnDetail;

    public MyHolder(View itemView) {
        super(itemView);

        judulTxt = (TextView) itemView.findViewById(R.id.textViewJudul);
        descText = (TextView) itemView.findViewById(R.id.textViewLihat);
        imgRsp = (ImageView) itemView.findViewById(R.id.imageView);
        btnDetail = (Button) itemView.findViewById(R.id.buttonLihat);

    }
}
