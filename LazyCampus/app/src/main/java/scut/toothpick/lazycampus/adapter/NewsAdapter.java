package scut.toothpick.lazycampus.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import scut.toothpick.lazycampus.fragment.NewsPublishFragment;
import scut.toothpick.lazycampus.fragment.NewsReceiveFragment;

/**
 * Created by dgliang on 2018/6/20.
 */

public class NewsAdapter extends FragmentPagerAdapter {
    private String[] titles = new String[]{"我发布的任务","我收到的任务"};
    public NewsAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 1) {
            return new NewsReceiveFragment();
        } else {
            return new NewsPublishFragment();
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }

}
