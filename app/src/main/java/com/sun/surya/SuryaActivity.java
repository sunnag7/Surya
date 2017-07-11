package com.sun.surya;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuryaActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView responseText;
    APIInterface apiInterface;
    ArrayList<MasterFlow> mMaster;
    private CustomViewPager viewPager;
    SpaceNavigationView spaceNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surya);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // responseText = (TextView) findViewById(R.id.response);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

      /*  Call call = apiInterface.doGetUserList(0);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS" );
                Gson gson = gsonBuilder.serializeNulls().create();
                ArrayList<FeedData> mFeedArray = new ArrayList<FeedData>();
               // FeedData posts = gson.fromJson(response.toString(), FeedData.class);
                Toast.makeText(getApplicationContext(), "  " + response.body().toString(), Toast.LENGTH_SHORT).show();
                FeedData postss = (FeedData) response.body();
                mMaster = orderData(postss,0,0,0,0,0);
                mFeedArray.add(postss);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                call.cancel();
            }
        });*/

        spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        viewPager = (CustomViewPager) findViewById(R.id.pager);
        Pager adapter = new Pager(getSupportFragmentManager());
        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        viewPager.setPagingEnabled(false);

        spaceNavigationView.showIconOnly();
        spaceNavigationView.setCentreButtonIcon(R.drawable.home_x);
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_dashboard_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_search_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_local_mall_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_supervisor_account_black_24dp));
      //  mTextMessage = (TextView) findViewById(R.id.message);

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(SuryaActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
                //alertHereNow();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(SuryaActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
                switch (itemIndex){
                    case 0:
                        viewPager.setCurrentItem(0);
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        //   Intent in = new Intent(SuryaActivity.this, SocialLoginActivity.class);
                        //   startActivity(in);
                        break;

                    case 2:
                        viewPager.setCurrentItem(2);
                        break;

                    case 3:
                        viewPager.setCurrentItem(3);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(SuryaActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.surya, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private ArrayList<MasterFlow> orderData(FeedData posts,int articlecount,int estateestimatecount,int estateforsalecout,int estatesoldcout,int estateconsoldcout) {
        //
        ArrayList<MasterFlow> mMasterArr = new ArrayList<MasterFlow>();
        List<Article> mArtArray = posts.getArticles();
        List<EstateForSale> mEstArr = posts.getEstateForSale();
        List<EstateForSale> mEstSoldArr = posts.getEstateSold();
        List<EstateForSale> mEstConsSoldArr = posts.getEstateConsideredSold();
        List<EstateEstimate> mEstimateArr = posts.getEstateEstimate();

        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        //df.setTimeZone(TimeZone.getTimeZone("UTC"));
        //int totalCount = mArtArray.size()+mEstArr.size()+mEstimateArr.size();
        //SimpleDateFormat dfa = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        for (int i = 0; i < mArtArray.size(); i++) {
            MasterFlow mMastFlow = new MasterFlow();
            Date date;
            mMastFlow.setIndex(articlecount);
            mMastFlow.setType(1);
            String tempDate = mArtArray.get(i).getDateOrder();
            date = getFormattedDate(tempDate);

            mMastFlow.setDate(date);
            mMasterArr.add(mMastFlow);
            articlecount++;
        }

        for (int i = 0; i < mEstArr.size(); i++) {
            MasterFlow mMastFlow = new MasterFlow();
            Date date;
            mMastFlow.setIndex(estateforsalecout);
            mMastFlow.setType(3);

            date = getFormattedDate(mEstArr.get(i).getDateOrder());
            mMastFlow.setDate(date);
            mMasterArr.add(mMastFlow);
            estateforsalecout++;
        }

        for (int i = 0; i < mEstSoldArr.size(); i++) {
            MasterFlow mMastFlow = new MasterFlow();
            Date date;
            mMastFlow.setIndex(estatesoldcout);
            mMastFlow.setType(4);

            date = getFormattedDate(mEstSoldArr.get(i).getDateOrder());
            mMastFlow.setDate(date);
            mMasterArr.add(mMastFlow);
            estatesoldcout++;
        }

        for (int i = 0; i < mEstConsSoldArr.size(); i++) {
            MasterFlow mMastFlow = new MasterFlow();
            Date date;
            mMastFlow.setIndex(estateconsoldcout);
            mMastFlow.setType(5);

            date = getFormattedDate(mEstConsSoldArr.get(i).getDateOrder());
            mMastFlow.setDate(date);
            mMasterArr.add(mMastFlow);
            estateconsoldcout++;
        }

        for (int i = 0; i < mEstimateArr.size(); i++) {
            MasterFlow mMastFlow = new MasterFlow();
            Date date;
            mMastFlow.setIndex(estateestimatecount);
            mMastFlow.setType(2);

            date = getFormattedDate(mEstimateArr.get(i).getDateOrder());
            mMastFlow.setDate(date);
            mMasterArr.add(mMastFlow);
            estateestimatecount++;
        }

        Collections.sort(mMasterArr, Collections.reverseOrder());

        return mMasterArr;
    }

    private Date getFormattedDate(String dateOrd) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        Date valuea = null;
        String newstr = "";
        try {
            if (dateOrd.contains(".")) {
                int endIndex = dateOrd.lastIndexOf(".");
                // String dateSim = mEstateEstimate.getEstimateDate().split("/+")[0];
                if (endIndex != -1) {
                    newstr = dateOrd.substring(0, endIndex); // not forgot to put check if(endIndex != -1)
                }
                valuea = df.parse(newstr);
            }
            else{
                int endIndex = dateOrd.lastIndexOf("Z");
                // String dateSim = mEstateEstimate.getEstimateDate().split("/+")[0];
                if (endIndex != -1) {
                    newstr = dateOrd.substring(0, endIndex); // not forgot to put check if(endIndex != -1)
                }
                valuea = df.parse(newstr);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return valuea;
    }
}
