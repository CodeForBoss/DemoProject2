package com.example.demoproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<SeatModelList> allSeats;
    private RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recylerViewId);
        allSeats = new ArrayList<>();
        showData();
        linearLayoutManager  = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(allSeats);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
    private void showData(){
        String file = "seatMap57.json";
        LoadData loadData = new LoadData();
        try {
            JSONArray jsonArray = new JSONArray(loadData.loadJsonFromAssets(file,MainActivity.this));
            for(int i = 0; i < jsonArray.length(); i++){
                Object obj = jsonArray.get(i);
                if(obj instanceof JSONObject){
                    SeatModel seatModel = new SeatModel();
                    List<SeatModel>seatModels = new ArrayList<>();

                   JSONObject zero =  new JSONObject(((JSONObject) obj).getString("0"));
                    seatModel.setN(zero.getString("n"));
                    seatModels.add(seatModel);

                   JSONObject one =  new JSONObject(((JSONObject) obj).getString("1"));
                   seatModel = new SeatModel();
                    seatModel.setN(one.getString("n"));
                    seatModels.add(seatModel);

                   JSONObject three =  new JSONObject(((JSONObject) obj).getString("3"));
                    seatModel = new SeatModel();
                    seatModel.setN(three.getString("n"));
                    seatModels.add(seatModel);

                    JSONObject four =  new JSONObject(((JSONObject) obj).getString("4"));
                    seatModel = new SeatModel();
                    seatModel.setN(four.getString("n"));
                    seatModels.add(seatModel);

                   SeatModelList seatModelList = new SeatModelList(seatModels);
                   allSeats.add(seatModelList);
                } else if (obj instanceof JSONArray){
                   if(i==0){
                       List<SeatModel>seatModels = new ArrayList<>();
                       for(int j = 0;j<((JSONArray) obj).length();j++){
                           JSONObject jsonObject = ((JSONArray) obj).getJSONObject(j);
                           SeatModel seatModel = new SeatModel();
                           seatModel.setT(jsonObject.getString("t"));
                           seatModels.add(seatModel);
                       }
                       SeatModelList seatModelList = new SeatModelList(seatModels);
                       allSeats.add(seatModelList);
                   } else {
                       List<SeatModel>seatModels = new ArrayList<>();
                       for(int j = 0;j<((JSONArray) obj).length();j++){
                           JSONObject jsonObject = ((JSONArray) obj).getJSONObject(j);
                           SeatModel seatModel = new SeatModel();
                           seatModel.setN(jsonObject.getString("n"));
                           seatModels.add(seatModel);
                       }
                       SeatModelList seatModelList = new SeatModelList(seatModels);
                       allSeats.add(seatModelList);
                   }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}