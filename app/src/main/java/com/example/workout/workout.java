package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class workout extends AppCompatActivity {
    ImageView imageView;
    List<User> userList;
    private UserAdapter userAdapter;
    private RecyclerView item1;
    ArrayList<Integer> id=new ArrayList<>();
    ArrayList<String> name=new ArrayList<>();
    ArrayList<String> imagename=new ArrayList<>();
    ArrayList<String> jsonname=new ArrayList<>();
    ArrayList<Integer> dem=new ArrayList<>();
    int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        loadJson();

        item1=findViewById(R.id.item);
        userAdapter = new UserAdapter(this,userList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false );
        item1.setLayoutManager(linearLayoutManager);

        userAdapter.setData(getListData());
        item1.setAdapter(userAdapter);
    }
    //getData cho recycleView
    private List<User> getListData(){
        List<User> listx=new ArrayList<>();
        for (int i=0; i<max; i++) {
            listx.add(new User(dem.get(i),name.get(i),imagename.get(i)));
        }
        return listx;
    }
    //lấy dữ liệu từ file categories.json
    private void loadJson() {
        try {
            InputStream inputStream=getAssets().open("categories.json");
            int size=inputStream.available();
            byte[] buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, "UTF-8");
            JSONArray jsonArray=new JSONArray(json);

            max=jsonArray.length();
            for (int i=0; i<max; i++) {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                id.add(jsonObject.getInt("id"));
                name.add(jsonObject.getString("name"));
                imagename.add(jsonObject.getString("image_name"));
                jsonname.add(jsonObject.getString("json_name"));
                String s=jsonname.get(i);
                dem.add(loadJson1(s));
            }


        } catch (Exception e) {
            Log.e("Tag", "loadJson: error "+e  );
        }
    }
    //lấy số bài tập trong từng mục
    private int loadJson1(String s) {
        int max1 = 0;
        try {
            InputStream inputStream = getAssets().open(s);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            max1=jsonArray.length();
        } catch (Exception e) {
            Log.e("Tag1", "loadJson: error " + e);
        }
        return max1;
    }
}