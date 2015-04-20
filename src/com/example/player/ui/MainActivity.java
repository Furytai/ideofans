package com.example.player.ui;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.Vitamio;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.ViewDebug.IntToString;
import android.view.Window;
import android.widget.Toast;

import com.example.player.utils.POS_TAB;
import com.example.viewpageindicator.R;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends FragmentActivity {

	private final String TAG = "MainActivity";
	
	private static final String[] TITLE = new String[] {"热点","频道","我的"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
        //必需初始滑Vitamio
    	Vitamio.initialize(this);
		
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_main);
		
		FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
        
        indicator.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				Toast.makeText(getApplicationContext(), TITLE[arg0], Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
        
	}

	
	/**
	 * ViewPager������
	 * @author len
	 *
	 */
    class TabPageIndicatorAdapter extends FragmentPagerAdapter {
        public TabPageIndicatorAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
        	//�½�һ��Fragment��չʾViewPager item�����ݣ������ݲ���
        	Fragment fragment;
            Bundle args = new Bundle(); 
        	switch (position) {
				case POS_TAB.HOT_TAB:
					fragment = new VideosFlowFragment();  
		            args.putString("arg", TITLE[position]);  
		            fragment.setArguments(args);  
					break;
				case POS_TAB.CHANNEL_TAB:
		        	fragment = new ItemFragment();  
		            args.putString("arg", TITLE[position]);  
		            fragment.setArguments(args); 
		            break;
				default:
		        	fragment = new ItemFragment();  
		            args.putString("arg", TITLE[position]);  
		            fragment.setArguments(args);
					break;
			}        	
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position % TITLE.length];
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }
    }

}
