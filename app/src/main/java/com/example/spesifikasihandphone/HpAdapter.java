package com.example.spesifikasihandphone;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HpAdapter extends RecyclerView.Adapter<HpAdapter.handphone> {

        List<Handphone>handphones;
        Activity activity;

    public HpAdapter(List<Handphone> handphones, Activity activity) {
        this.handphones = handphones;
        this.activity = activity;
    }

    @NonNull
        @Override
        public handphone onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hp_item,parent,false);

            return new handphone(view) ;
        }

    @Override
    public void onBindViewHolder(@NonNull handphone holder, final int position) {

        holder.txtNama.setText(handphones.get(position).getNama_produk());
        Picasso.with(activity).load(handphones.get(position).getPic()).into(holder.imgHp);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handphone hp=handphones.get(position);
                Intent PINDAH=new Intent(activity,DetailActivity.class);
                PINDAH.putExtra(DetailActivity.KEY_ACTIVITY,hp);
                view.getContext().startActivity(PINDAH);
            }
        });
    }



        @Override
        public int getItemCount() {
            return handphones.size();
        }
        static class handphone extends RecyclerView.ViewHolder {

            TextView txtNama, txtRam, txtInternalmemory, txtHarga;
            ImageView imgHp;

            public handphone(@NonNull View itemView) {
                super(itemView);
                txtNama = (TextView) itemView.findViewById(R.id.txt_nama_produk);
                txtRam = (TextView) itemView.findViewById(R.id.txt_ram);
                txtInternalmemory = (TextView) itemView.findViewById(R.id.txt_internal_memory);
                txtHarga = (TextView) itemView.findViewById(R.id.txt_harga);
                imgHp = (ImageView) itemView.findViewById(R.id.img_hp);
            }
        }
    }




