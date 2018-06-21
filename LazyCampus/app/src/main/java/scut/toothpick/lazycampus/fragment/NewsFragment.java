package scut.toothpick.lazycampus.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import scut.toothpick.lazycampus.R;
import scut.toothpick.lazycampus.adapter.NewsAdapter;


public class NewsFragment extends Fragment {

    private ViewPager newsViewpager;
    private MagicIndicator newsMagicIndicator;
    private NewsAdapter newsAdapter;
    private CommonNavigatorAdapter newsCommonNavigatorAdapter;
    private ColorTransitionPagerTitleView newsColorTransitionPagerTitleView;
    private CommonNavigator newsCommonNavigator;
    //标题
    private String[] titles = new String[]{"我发布的任务","我接受的任务"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取view
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_news, container, false);

        newsViewpager = (ViewPager)view.findViewById(R.id.newsViewPager);
        newsAdapter = new NewsAdapter(getActivity().getSupportFragmentManager());
        newsViewpager.setAdapter(newsAdapter);
        newsMagicIndicator = (MagicIndicator)view.findViewById(R.id.newsMagicIndicator);
        newsCommonNavigator = new CommonNavigator(getActivity());
        newsCommonNavigator.setAdjustMode(true);
        newsCommonNavigatorAdapter = new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titles == null ? 0: titles.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context,final int i) {
                newsColorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                //设置标题栏 颜色 样式
                newsColorTransitionPagerTitleView.setNormalColor(Color.GRAY);
                newsColorTransitionPagerTitleView.setSelectedColor(Color.parseColor("#5d73ff"));
                newsColorTransitionPagerTitleView.setBackgroundColor(Color.WHITE);
                newsColorTransitionPagerTitleView.setText(titles[i]);
                newsColorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        newsViewpager.setCurrentItem(i);
                    }
                });
                return newsColorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                return indicator;
            }
        };
        newsCommonNavigator.setAdapter(newsCommonNavigatorAdapter);
        newsMagicIndicator.setNavigator(newsCommonNavigator);
        ViewPagerHelper.bind(newsMagicIndicator,newsViewpager);
        return view;
    }
}
