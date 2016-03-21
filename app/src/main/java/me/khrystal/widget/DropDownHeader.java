package me.khrystal.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.khrystal.activities.R;

/**
 * Created by kHRYSTAL on 16/3/21.
 */
public class DropDownHeader extends LinearLayout{

    //底部容器，包含popupMenuViews，maskView
    private FrameLayout containerView;
    //弹出菜单父布局
    private FrameLayout popupMenuView;
    //遮罩半透明View，点击可关闭DropDownMenu
    private View maskView;
    private Toolbar toolbar;

    //popMenu是否打开
    private boolean popIsOpen = false;


    //遮罩颜色
    private int maskColor = 0x88888888;
    private ImageView rightArrow;
    private TextView titleTextView;
    private View mPopView;

    public DropDownHeader(Context context) {
        super(context,null);
    }

    public DropDownHeader(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DropDownHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View inflate = View.inflate(context, R.layout.header, this);
        rightArrow = (ImageView)inflate.findViewById(R.id.right_image);
        titleTextView = (TextView)inflate.findViewById(R.id.toolbar_title);
        rightArrow.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switchMenu();
            }
        });
        setOrientation(VERTICAL);
        //初始化containerView并将其添加到DropDownMenu
        containerView = new FrameLayout(context);
        containerView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        addView(containerView, 1);
    }

    /**
     * 初始化DropDownMenu
     *
     * @param popupView
     * @param contentView
     */
    public void setDropDownMenu(@NonNull View popupView, @NonNull View contentView) {
        containerView.addView(contentView, 0);

        maskView = new View(getContext());
        maskView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        maskView.setBackgroundColor(maskColor);
        maskView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                closeMenu();
            }
        });
        containerView.addView(maskView, 1);
        maskView.setVisibility(GONE);

        popupMenuView = new FrameLayout(getContext());
        popupMenuView.setVisibility(GONE);
        containerView.addView(popupMenuView, 2);

        if (popupView!=null){
            mPopView = popupView;
            popupView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            popupMenuView.addView(popupView);
        }
    }

    /**
     * 关闭菜单
     */
    public void closeMenu() {
        if (popIsOpen) {
            popupMenuView.setVisibility(View.GONE);
            popupMenuView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_out));
            maskView.setVisibility(GONE);
            maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_out));
            rightArrow.setImageResource(R.drawable.drop_down_unselected_icon);
            popIsOpen = false;
        }
    }

    /**
     * DropDownMenu是否处于可见状态
     *
     * @return
     */
    public boolean isShowing() {
        return  popIsOpen;
    }

    /**
     * 切换菜单
     *
     */
    private void switchMenu() {
        System.out.println(popIsOpen);
        if (popIsOpen) {
            closeMenu();
            rightArrow.setImageResource(R.drawable.drop_down_unselected_icon);
        } else {
            rightArrow.setImageResource(R.drawable.drop_down_selected_icon);
            popupMenuView.setVisibility(View.VISIBLE);
            popupMenuView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_in));
            maskView.setVisibility(VISIBLE);
            maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_in));
            mPopView.setVisibility(VISIBLE);
            popIsOpen = true;
        }
    }

    public TextView getTitleTextView(){
        return titleTextView;
    }
}
