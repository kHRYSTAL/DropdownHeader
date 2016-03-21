package me.khrystal.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.khrystal.activities.R;
import me.khrystal.widget.coverflow.KCoverFlow;

/**
 * Created by kHRYSTAL on 16/3/21.
 */
public class KCoverFlowLayout extends LinearLayout {

    private int selectPosition = -1;

    private boolean isTouch = false;

    private KCoverFlow coverFlow;
    private TextView textView;

    public KCoverFlowLayout(Context context) {
        this(context,null,0);
    }

    public KCoverFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public KCoverFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View inflate = View.inflate(context, R.layout.cover_flow_layout, this);
        coverFlow = (KCoverFlow) inflate.findViewById(R.id.cover_flow);
        LinearLayout rootLayout = (LinearLayout)inflate.findViewById(R.id.cover_flow_root);
        rootLayout.setBackgroundColor(Color.parseColor("#ffff00"));
        textView = (TextView)inflate.findViewById(R.id.text);
        coverFlow.setOnItemSelectedListener(onItemSelectedListener);
    }

    public KCoverFlow getCoverFlow(){
        return coverFlow;
    }


    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            selectPosition = position;
            textView.setText(String.valueOf(position));

//            Thread.State state = runnable.getState();
//            if (state == Thread.State.NEW || state == Thread.State.WAITING || state == Thread.State.TERMINATED)
//                runnable.run();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

//    Thread runnable = new Thread() {
//
//        @Override
//        public void run() {
//            try {
//                Log.d("onItemSelected", "isTouch:" + isTouch + "selectPosition:" + selectPosition + "copyPosition:" + copyPosition);
//                if (!isTouch) {
//                    if (copyPosition != selectPosition) {
//                        copyPosition = selectPosition;
//                        deleteMessage();
//                        sendMessage(selectPosition);
//                        return;
//                    } else {
//                        return;
//                    }
//                }
//                mHandler.postDelayed(runnable, 10);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    };


//    private void sendMessage(int position) {
//        Message msg = new Message();
//        msg.what = 998;
//        msg.obj = position;
//        mHandler.sendMessageDelayed(msg, 500);
//    }
//
//    private void deleteMessage() {
//        while (mHandler.hasMessages(998)) {
//            mHandler.removeMessages(998);
//        }
//    }

}
