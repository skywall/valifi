package com.mlykotom.exampleviewmodel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.mlykotom.exampleviewmodel.single.SingleValidationFragment;
import com.mlykotom.exampleviewmodel.form.FormValidationFragment;
import com.mlykotom.exampleviewmodel.manual.ManualValidationFragment;

import eu.inloop.viewmodel.base.ViewModelBaseEmptyActivity;


public class ExampleViewModelActivity extends ViewModelBaseEmptyActivity {
	private PagesAdapter mAdapter;
	private ViewPager mViewPager;
	private TabLayout mTabLayout;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_example);
		setupActionbar();
		setupAdapter();
	}


	private void setupActionbar() {
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle("ValiFi example");
		setSupportActionBar(toolbar);
	}


	private void setupAdapter() {
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mTabLayout = (TabLayout) findViewById(R.id.tabs);

		mAdapter = new PagesAdapter(getSupportFragmentManager());

		mViewPager.setAdapter(mAdapter);
		mTabLayout.setupWithViewPager(mViewPager);
	}


	private static class PagesAdapter extends FragmentStatePagerAdapter {
		private static String[] sTitles = new String[]{"Single", "Form", "Manual"};


		public PagesAdapter(FragmentManager fm) {
			super(fm);
		}


		@Override
		public Fragment getItem(int position) {
			switch(position) {
				case 0:
				default:
					return SingleValidationFragment.newInstance();

				case 1:
					return FormValidationFragment.newInstance();

				case 2:
					return ManualValidationFragment.newInstance();
			}
		}


		@Override
		public int getCount() {
			return sTitles.length;
		}


		@Override
		public CharSequence getPageTitle(int position) {
			return sTitles[position];
		}
	}

}
