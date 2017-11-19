package com.example.khanhchivu.myapplication3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by khanhchivu on 18/11/2017.
 */

public class AcademyAdapter extends RecyclerView.Adapter<AcademyAdapter.ViewHolder> {

    List<String> academyList;
    private Context context;
    private LayoutInflater mLayoutInflater;

    public AcademyAdapter(Context context, List<String> datas) {
        super();
        this.context = context;
        academyList = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.academy_activity, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int    position) {
         String aca = (String) academyList.get(position);
         viewHolder.txtTitile.setText(aca);

    }

    @Override
    public int getItemCount() {
        return academyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtTitile;
        public ImageView img1;

        public ViewHolder(final View itemView){
            super(itemView);
            txtTitile = (TextView) itemView.findViewById(R.id.txtacademy);
                img1 = itemView.findViewById(R.id.imsport);
                Picasso.with(context).load(R.drawable.sport).into(img1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,LookUpActivity.class);
                    context.startActivity(intent);
                }
            });
        }


    }
}
