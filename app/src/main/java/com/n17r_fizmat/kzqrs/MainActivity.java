package com.n17r_fizmat.kzqrs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    //Toolbar myToolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Disable in version 1
        //myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(myToolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.setContext(this);
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            viewPagerAdapter.addFragments(new NewsFragmentNew(), "News");
            viewPagerAdapter.addFragments(new HomeFragment(), "Profile");
            viewPagerAdapter.addFragments(new SearchFragment(), "Search");
        } else {
            viewPagerAdapter.addFragments(new NewsFragmentNew(), "News");
            viewPagerAdapter.addFragments(new HomeGuestFragment(), "Profile");
            viewPagerAdapter.addFragments(new SearchFragment(), "Search");
        }
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.mainmenu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.logout:
//                ParseUser.logOut();
//                Intent intent = new Intent(this, LoginActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//                finish();
//                break;
//            case R.id.settingsButton:
//                Intent settingsIntent = new Intent(this, SettingsActivity.class);
//                startActivity(settingsIntent);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
