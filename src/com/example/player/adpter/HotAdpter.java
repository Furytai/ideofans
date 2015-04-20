package com.example.player.adpter;
import io.vov.vitamio.MediaPlayer;

import java.util.ArrayList;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.player.bean.MovieBean;
import com.example.viewpageindicator.R;


//import com.hck.myplayer.R;
//import com.hck.player.bean.MovieBean;
//import com.hck.player.utils.MyTools;
//import com.nostra13.universalimageloader.core.ImageLoader;


public class HotAdpter extends BaseAdapter {
	
	private final String TAG = "HotAdpter";
	
	
	private Context context;
	
	public ArrayList<MovieBean> beans;
		
	private MediaPlayer mMediaPlayer = null;

	
	public HotAdpter(Context context, ArrayList<MovieBean> beans) {
		this.context = context;
		this.beans = beans;
	}

	@Override
	public int getCount() {
		return beans.size();
	}

	@Override
	public Object getItem(int arg0) {
		return beans.get(arg0);
	}
	@Override
	public long getItemId(int arg0) {
		return arg0;
	}
	@Override
	public View getView(final int pos, View arg1, ViewGroup arg2) {
		View view = arg1;
		final GetView getView;
		if (view == null) {
			view = LayoutInflater.from(context).inflate(
					R.layout.videoflow_item, null);
			getView = new GetView();
			getView.imageButton = (ImageButton) view.findViewById(R.id.videoflow_button);
			getView.videoAboveLayout = (RelativeLayout) view.findViewById(R.id.videoflow_aboveLayout);
			getView.videoView = (SurfaceView) view.findViewById(R.id.videoflow_view);
			getView.nameView = (TextView) view.findViewById(R.id.videoflow_text);
			
			view.setTag(getView);
		} else {
			getView = (GetView) view.getTag();
		}
		getView.nameView.setText(beans.get(pos).getTitle());
		Log.v(TAG,"getView url==>"+beans.get(pos).getVid());
		getView.videoView.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				if(getView.videoAboveLayout.VISIBLE == View.INVISIBLE){
					getView.videoAboveLayout.setVisibility(View.VISIBLE);
					//getView.imageButton.setClickable(true);
					Toast.makeText(context, "pause", Toast.LENGTH_SHORT).show();
					pauseVideo(getView.videoView, beans.get(pos).getVid());
				}
			}
		});
		
		getView.imageButton.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				if(getView.videoAboveLayout.VISIBLE == View.VISIBLE){
					getView.videoAboveLayout.setVisibility(View.INVISIBLE);
					//getView.imageButton.setClickable(false);
					Log.v(TAG,"onClick url==>"+beans.get(pos).getVid());
					Toast.makeText(context, beans.get(pos).getVid(), Toast.LENGTH_SHORT).show();
//						pauseOtherVideo();
					playVideo(getView.videoView, beans.get(pos).getVid());
				}
			}
		});
//		if (beans.get(arg0).getAllTime()!=null) {
//			getView.textView.setText(MyTools.changeTime2(Long.parseLong(beans.get(arg0).getAllTime())));
//		}
//		ImageLoader.getInstance().displayImage(beans.get(arg0).getSimg(),
//				getView.imageView);
		return view;
	}

	static class GetView {
		SurfaceView videoView;
		TextView nameView;
		RelativeLayout videoAboveLayout;
		ImageButton imageButton;
	}
	
	//数据改动 刷新界面
	public void resh(ArrayList<MovieBean> beans)
	{
		this.beans.addAll(beans);
		this.notifyDataSetChanged();
	}

	public void resh(MovieBean bean) {
		// TODO Auto-generated method stub
		this.beans.add(bean);
		this.notifyDataSetChanged();
	}

	private void pauseVideo(SurfaceView videoView, String vid) {
		if(videoView.VISIBLE == View.INVISIBLE && mMediaPlayer != null ){
			mMediaPlayer.pause();
		}	
	}
	
	//
	 private void playVideo(SurfaceView surfaceViewView, String url ) {
		 
		 if(mMediaPlayer == null){
			mMediaPlayer =  new MediaPlayer(context);
		 }	 
		 new MyAsynTask(surfaceViewView, url).execute(mMediaPlayer);
        //mMediaPlayer.setOnBufferingUpdateListener(this);//设置缓冲监听  
        //mMediaPlayer.setOnCompletionListener(this);//设置播放完毕监听  
        //mMediaPlayer.setOnPreparedListener(this);//设置准备完毕监听  
        //mMediaPlayer.setOnVideoSizeChangedListener(this);//设置显示大小改变监听  
        //mMediaPlayer.getMetadata();//在播放网络流媒体时。
		 }
	class MyAsynTask extends AsyncTask<MediaPlayer, Integer, Void>{

		SurfaceView surfaceView;
		String url;
		
		MyAsynTask(SurfaceView surfaceViewView, String url){
			this.surfaceView = surfaceViewView;
			this.url = url;
		}

		@Override
		protected Void doInBackground(MediaPlayer... params) {
			 SurfaceHolder holder = surfaceView.getHolder();

		     // Create a new media player and set the listeners  
	        try {
				mMediaPlayer.setDataSource(url);//设置数据源  
		        mMediaPlayer.setDisplay(holder);//设置显示  
		        mMediaPlayer.prepare();//准备(这里用prepareAsync()应该会更好。。) 
		        //*
		        int width =  surfaceView.getWidth();
		        int height = surfaceView.getHeight();
		        float boxWidth = width;
		        float boxHeight = height;

		        float videoWidth = mMediaPlayer.getVideoWidth();
		        float videoHeight = mMediaPlayer.getVideoHeight();

		        //Log.i(TAG, String.format("startVideoPlayback @ %d - video %dx%d - box %dx%d", mPos, (int) videoWidth, (int) videoHeight, width, height));

		        float wr = boxWidth / videoWidth;
		        float hr = boxHeight / videoHeight;
		        float ar = videoWidth / videoHeight;

		        if (wr > hr)
		            width = (int) (boxHeight * ar);
		        else
		            height = (int) (boxWidth / ar);
		        holder.setFixedSize(width, height);
		        // */
			} catch (Exception e) {
				Log.i(TAG, "error init player");
				e.printStackTrace();
			}
	        mMediaPlayer.start();
			return null;
		}
	}
}
