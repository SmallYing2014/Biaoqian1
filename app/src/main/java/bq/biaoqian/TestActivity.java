package bq.biaoqian;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;
import java.util.TooManyListenersException;

import bq.biaoqian.view.FlowLayout;
import bq.biaoqian.view.TagAdapter;
import bq.biaoqian.view.TagFlowLayout;
//关联网上的两个流式布局一个是多选一个是添加子view,该demo
public class TestActivity extends AppCompatActivity {
    private String[] mVals = new String[]
            {"Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView","Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld"};

    ArrayList<String> list=new ArrayList<>();

    private TagFlowLayout mFlowLayout;
    private TagAdapter<String> mAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        for(int i=0;i<mVals.length;i++){
            list.add(mVals[i]);
        }
        updateData(list);

    }

    private void updateData(final ArrayList<String> list) {


        final LayoutInflater mInflater = LayoutInflater.from(this);

        mFlowLayout = (TagFlowLayout)findViewById(R.id.id_flowlayout);
        //mFlowLayout.setMaxSelectCount(3);

        mFlowLayout.setAdapter(mAdapter = new TagAdapter<String>(list)
        {

            @Override
            public View getView(FlowLayout parent, int position, String s)
            {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                        mFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        });

        //mAdapter.setSelectedList(1,3,5,7,8,9);
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener()
        {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent)
            {
                //Toast.makeText(getActivity(), mVals[position], Toast.LENGTH_SHORT).show();
                //view.setVisibility(View.GONE);
                return true;
            }
        });


        mFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener()
        {
            @Override
            public void onSelected(Set<Integer> selectPosSet)
            {
                //这里的代码中mFlowLayout.getSelectedList()是获取选择的个数
                setTitle("choose:" + selectPosSet.toString()+"   "+mFlowLayout.getSelectedList().toString());
                Log.e("pp",mFlowLayout.getSelectedList().toString());
            }
        });


        ImageView iv = (ImageView) mInflater.inflate(R.layout.add_item_flow, mFlowLayout, false);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(new Intent(TestActivity.this, AddBiaoQianActivity.class).putStringArrayListExtra("bq", list), 1);

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
                updateData(list);
            }
        }
    }


}
