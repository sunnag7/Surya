package com.sun.surya;

/**
 * Created by Sanny on 1/21/2017.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Belal on 2/3/2016.
 */
//Extending FragmentStatePagerAdapter
public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount = 4;

    //Constructor to the class
    public Pager(FragmentManager fm) {
        super(fm);
        //Initializing tab count
        //this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 2:
                AboutFragment tab1 = new AboutFragment();
                return tab1;
            case 1:
                ServicesFragment tab2 = new ServicesFragment();
                return tab2;
            case 0:
                PortfolioFragment tab3 = new PortfolioFragment();
                return tab3;
            case 3:
                SocialFragment tab4 = new SocialFragment();
                return tab4;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}