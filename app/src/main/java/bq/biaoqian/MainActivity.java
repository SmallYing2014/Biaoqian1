package bq.biaoqian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list;
    LayoutInflater mInflater;
    private FlowAddLayout mFlowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlowLayout = (FlowAddLayout) findViewById(R.id.id_flowlayout);
        list = new ArrayList<>();

        list.add("糗事");
        list.add("里约奥运会");
        list.add("菲尔普斯");
        list.add("吐槽");
        list.add("王宝强离婚");
        list.add("洪荒少女傅园慧");
        list.add("嗑药骗子霍顿");


        mInflater = LayoutInflater.from(this);
        updateData();

    }




    private void updateData() {

        mFlowLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            TextView view = (TextView) mInflater.inflate(R.layout.item_flow, mFlowLayout, false);
            view.setText(list.get(i));
            mFlowLayout.addView(view);


        }

        ImageView iv = (ImageView) mInflater.inflate(R.layout.add_item_flow, mFlowLayout, false);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, AddBiaoQianActivity.class).putStringArrayListExtra("bq", list), 1);
            }
        });
        mFlowLayout.addView(iv);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == 1) {
                list = data.getStringArrayListExtra("bg");
                updateData();
            }
        }
    }
}