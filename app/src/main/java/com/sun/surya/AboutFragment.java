package com.sun.surya;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

//import me.relex.circleindicator.CircleIndicator;

public class AboutFragment extends Fragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    GoogleMap gMap = null;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    SupportMapFragment gMapView;
    private OnFragmentInteractionListener mListener;

    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        try {
            view = inflater.inflate(R.layout.fragment_about, container, false);
             gMapView = (SupportMapFragment) this.getChildFragmentManager()
                    .findFragmentById(R.id.map);
            gMapView.getMapAsync(this);
        }
        catch(InflateException e){
            if(view != null) {
                ViewGroup parent = (ViewGroup) view.getParent();
                if(parent != null) {
                    parent.removeView(view);
                }
            }// map is already there, just return view as it is
        }
        return view;
    }

     public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        gMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        gMap.getUiSettings().setMapToolbarEnabled(false);

        CameraPosition googlePlex = CameraPosition.builder()
                .target(new LatLng(15.2717856, 73.96225582))
                .zoom(18)
                .bearing(0)
                .tilt(40)
                .build();
        gMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex));

        gMap.addMarker(new MarkerOptions().zIndex(100)
                .position(new LatLng(15.2717856, 73.96225582 ))
                .title("Surya Jewellers").snippet(""));
                //.icon(R.drawable.near_me);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public class AndroidImageAdapter extends PagerAdapter {
        Context mContext;

        AndroidImageAdapter(Context context) {
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return sliderImagesId.length;
        }

        private int[] sliderImagesId = new int[]{
              //  R.drawable.cont_img, R.drawable.job, R.drawable.startup,
             //   R.drawable.deepweb, R.drawable.kodework, R.drawable.smartphone,
        };

        @Override
        public boolean isViewFromObject(View v, Object obj) {
            return v == ((ImageView) obj);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int i) {
            ImageView mImageView = new ImageView(mContext);
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setImageResource(sliderImagesId[i]);
            ((ViewPager) container).addView(mImageView, 0);
            return mImageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int i, Object obj) {
            ((ViewPager) container).removeView((ImageView) obj);
        }
    }
}
