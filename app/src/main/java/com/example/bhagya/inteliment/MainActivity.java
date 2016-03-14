package com.example.bhagya.inteliment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        final TextView textView = (TextView) findViewById(R.id.textView);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        Button red = (Button) findViewById(R.id.red);
        Button blue = (Button) findViewById(R.id.blue);
        Button green = (Button) findViewById(R.id.green);

        tabLayout.addTab(tabLayout.newTab().setText("Red"));
        tabLayout.addTab(tabLayout.newTab().setText("Blue"));
        tabLayout.addTab(tabLayout.newTab().setText("Green"));
        tabLayout.addTab(tabLayout.newTab().setText("Yellow"));
        tabLayout.addTab(tabLayout.newTab().setText("Black"));

        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.card);


        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorRed));
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            }
        });


        setupViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                textView.setText(tab.getText());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Item1(), "Item1");
        adapter.addFrag(new Item2(), "Item2");
        adapter.addFrag(new Item3(), "Item3");
        adapter.addFrag(new Item4(), "Item4");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter implements AdapterView.OnItemClickListener{
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Toast.makeText(getApplicationContext(), "current viewpager index " + position, Toast.LENGTH_SHORT).show();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
