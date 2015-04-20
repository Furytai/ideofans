package com.example.player.ui;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.widget.VideoView;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.player.adpter.HotAdpter;
import com.example.player.bean.MovieBean;
import com.example.viewpageindicator.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class VideosFlowFragment extends ListFragment {

    private static MainActivity activity;
    private static HotAdpter adapter;

    private PullToRefreshListView mPullToRefreshListView;

    
    ArrayList<MovieBean> beans = new ArrayList<MovieBean>();
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	//获取当前布局
    	//View layout = super.onCreateView(inflater, container, savedInstanceState);
    	View layout = inflater.inflate(R.layout.fragment_videoflow, null);

        ListView lv = (ListView) layout.findViewById(R.id.videoflow_list);
        //获取父 布局
        ViewGroup parent = (ViewGroup) lv.getParent();

        int lvIndex = parent.indexOfChild(lv);
        
        //移除当前布局
        parent.removeViewAt(lvIndex);
        
        //更新数据
        mPullToRefreshListView = new PullToRefreshListView(layout.getContext());
        mPullToRefreshListView.setMode(Mode.PULL_FROM_END);
        mPullToRefreshListView.setOnRefreshListener(
                new OnRefreshListener2<ListView>(){
            //下拉刷新
            @Override
            public void onPullDownToRefresh(
                    PullToRefreshBase<ListView> refreshView) {
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(),
                                "Don't pull down the list! Pull up instead.",
                                Toast.LENGTH_LONG).show();
                        //提醒更新当前界面
                        mPullToRefreshListView.onRefreshComplete();
                    }
                }, 1000);
            }
            //上拉加载数据
            @Override
            public void onPullUpToRefresh(
                    PullToRefreshBase<ListView> refreshView) {
                new GetDataTask().execute();
            }
        });

        //添加更新后的布局
        parent.addView(mPullToRefreshListView, lvIndex, lv.getLayoutParams());

        return layout;
    }

    private class GetDataTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            for (int i = 0; i< 10; i++) {
               // Adapter.add(random_string_please(20));
            	adapter.resh(new MovieBean(i+"", random_string_please(5)));
            	
            }
            mPullToRefreshListView.onRefreshComplete();
            super.onPostExecute(result);
        }
    }

    public static String random_string_please(int LENGTH) {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        char tempChar;
        for (int i = 0; i < LENGTH; i++){
            tempChar = (char) (generator.nextInt(25) + 65);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);


        activity = (MainActivity) getActivity();

        initData();
        
        adapter = new HotAdpter(activity, beans);

        setListAdapter(adapter);

        
        // Bundle mBundle = getArguments();
        // do something
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // https://github.com/chrisbanes/Android-PullToRefresh/issues/99
        position--;

        Toast.makeText(getActivity(), adapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();
    }

    
    //initData
    void initData(){
        for (int i = 0; i< 10; i++) {
        	beans.add(new MovieBean("http://live.3gv.ifeng.com/zixun.m3u8", random_string_please(10)));
        }
    }
}

