package com.sun.surya;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static android.support.v4.app.ActivityCompat.invalidateOptionsMenu;

public class PortfolioFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    boolean isProductViewAsList = true;
    TextView mTextPrice, mTextday;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    ImageView ivGrid;

    public PortfolioFragment() {
        // Required empty public constructor
    }

    public static PortfolioFragment newInstance(String param1, String param2) {
        PortfolioFragment fragment = new PortfolioFragment();
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

       // getWebsite();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_portfolio, container, false);
        // Get the widgets reference from XML layout
        //mRelativeLayout = (RelativeLayout)view. findViewById(R.id.rl);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mTextPrice = (TextView) view.findViewById(R.id.textView2);
        mTextday = (TextView) view.findViewById(R.id.textView11);
        // Initialize a new String array
        String[] colors = {
                "Red","Green","Blue","Yellow","Magenta","Cyan","Orange",
                "Aqua","Azure","Beige","Bisque","Brown","Coral","Crimson"
        };

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Initialize a new instance of RecyclerView Adapter instance
        mAdapter = new ColorAdapter(getActivity(),colors);
        ivGrid = (ImageView) view.findViewById(R.id.imageView4);
        ivGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isProductViewAsList = !isProductViewAsList;
                invalidateOptionsMenu(getActivity());
                mRecyclerView.setLayoutManager(isProductViewAsList ? new LinearLayoutManager(getActivity()) : new GridLayoutManager(getActivity(), 2));
                mAdapter.notifyDataSetChanged();
            }
        });

        new Description().execute();
        // Set the adapter for RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        //mTextPrice.setText(priceGold);
        return view;
    }

    ProgressDialog mProgressDialog;
    private class Description extends AsyncTask<Void, Void, Void> {
        String desc;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setTitle("Wait");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Document document = Jsoup.connect("http://www.goldpriceindia.com/").get();
                // Using Elements to get the Meta data
              /*  Elements description = document
                        .select("meta[name=description]");
                // Locate the content attribute
                desc = description.attr("content");*/
                title = document.title();
                message = document.select("div.prc").first();
                priceGold = message.text() ;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView
            mTextday.setText(title);
            mTextPrice.setText(priceGold);
            mProgressDialog.dismiss();
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume() {
        super.onResume();
        new Runnable() {
            @Override
            public void run() {
             //   mTextPrice.setText(priceGold);
            }
        } ;
    }

    Element message;
    String priceGold = "",title = "";
    private void getWebsite() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();

                try {
                    Document doc = Jsoup.connect("http://www.goldpriceindia.com/").get();
                    title = doc.title();
                    // Elements links = doc.select("a[href]");

                    builder.append(title).append("\n");
                    message = doc.select("div.prc").first();
                    priceGold = message.text() ;
                    //mTextPrice.setText(priceGold);

                    /*for (Element link : links) {
                        builder.append("\n").append("Link : ").append(link.attr("href"))
                                .append("\n").append("Text : ").append(link.text());
                    }

                    for(Element div : doc.select("div")){
                        System.out.println(div.text());
                        for(Element img : div.select("img")){
                            System.out.println(img.attr("src"));

                        }
                    }*/

                } catch (IOException e) {
                    builder.append("Error : ").append(e.getMessage()).append("\n");
                }
            }
        }).start();


    }
}
