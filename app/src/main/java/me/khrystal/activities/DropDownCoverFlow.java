package me.khrystal.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.khrystal.adapter.CoverFlowSampleAdapter;
import me.khrystal.widget.DropDownHeader;
import me.khrystal.widget.KCoverFlowLayout;
import me.khrystal.widget.coverflow.KCoverFlow;

public class DropDownCoverFlow extends AppCompatActivity {

    @InjectView(R.id.dropDown)
    DropDownHeader mDropDownHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down_cover_flow);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        KCoverFlowLayout flowLayout = new KCoverFlowLayout(this);
        KCoverFlow coverFlow = flowLayout.getCoverFlow();
        coverFlow.setAdapter(new CoverFlowSampleAdapter(this));
//        倾斜角度
        coverFlow.setMaxRotation(0);
//        透明度
        coverFlow.setUnselectedAlpha(0.6f);
//        饱和度
        coverFlow.setUnselectedSaturation(0.0f);
//        未选中缩放大小
        coverFlow.setUnselectedScale(0.7f);
//        中间对齐
        coverFlow.setScaleDownGravity(0.5f);
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DropDownCoverFlow.this,"item"+position,Toast.LENGTH_SHORT).show();
            }
        });


        //init context view
        TextView contentView = new TextView(this);
        contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        contentView.setText("内容显示区域");
        contentView.setGravity(Gravity.CENTER);
        contentView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        //init dropdownview
        mDropDownHeader.setDropDownMenu(flowLayout, contentView);
    }



}
