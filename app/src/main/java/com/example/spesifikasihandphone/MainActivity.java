package com.example.spesifikasihandphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiInterface apiInterface;
    private ApiClient apiClient;
    private List<Handphone>handphones;
    RecyclerView hpku;
    RecyclerView.LayoutManager layoutManager;
    HpAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hpku=(RecyclerView)findViewById(R.id.hpmu);
        layoutManager=new LinearLayoutManager(this);
        hpku.setLayoutManager(layoutManager);
        hpku.setHasFixedSize(true);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Handphone>>call=apiInterface.getHandphone();
        call.enqueue(new Callback<List<Handphone>>() {
            @Override
            public void onResponse(Call<List<Handphone>> call, Response<List<Handphone>> response) {
                handphones=response.body();
                adapter=new HpAdapter(handphones,MainActivity.this);
                hpku.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Handphone>> call, Throwable t) {

            }
        });
    }
}
