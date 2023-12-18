package com.lzp.tablayout.demo.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lzp.tablayout.demo.adapter.SimpleHomeAdapter;

public class SimpleHomeActivity extends AppCompatActivity {
    private Context mContext = this;
    private final String[] mItems = {
            "SlidingTabLayout", "CommonTabLayout",
            "SegmentTabLayout", "SlidingScaleTabLayout(new)",
            "SlidingScaleTabLayoutFragmentActivity(new)",
            "SlidingScaleTabLayout without ViewPager(new)"};
    private final Class<?>[] mClasses = {
            SlidingTabActivity.class, CommonTabActivity.class,
            SegmentTabActivity.class, SlidingScaleTabLayoutActivity.class,
            SlidingScaleTabLayoutFragmentActivity.class,
            SlidingTabLayoutWithoutViewPagerActivity3.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView lv = new ListView(mContext);
        lv.setCacheColorHint(Color.TRANSPARENT);
        lv.setFadingEdgeLength(0);
        lv.setAdapter(new SimpleHomeAdapter(mContext, mItems));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, mClasses[position]);
                startActivity(intent);
            }
        });

        setContentView(lv);
    }
}
