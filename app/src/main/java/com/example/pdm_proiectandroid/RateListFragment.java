package com.example.pdm_proiectandroid;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pdm_proiectandroid.adaptors.RatesAdapter;
import com.example.pdm_proiectandroid.entities.Currency;
import com.example.pdm_proiectandroid.entities.ExchangeRate;
import com.example.pdm_proiectandroid.entities.Rate;
import com.example.pdm_proiectandroid.services.ExchangeRateService;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.pdm_proiectandroid.MainActivity.SelectedCurrency;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RateListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RateListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RateListFragment extends Fragment {

    private ExchangeRateService exchangeRateService;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RateListFragment() {
        exchangeRateService = new ExchangeRateService();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RateListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RateListFragment newInstance(String param1, String param2) {
        RateListFragment fragment = new RateListFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rate_list, container, false);
        ExchangeRate exchangeRate = getTodayRates();
        ArrayList<Rate> rates = exchangeRateService.hashToList(exchangeRate);
        // add from list
        RecyclerView recyclerView = view.findViewById(R.id.rv_rate_list);
        recyclerView.setAdapter(new RatesAdapter(rates));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private ExchangeRate getTodayRates(){
        ExchangeRate exchangeRate = new ExchangeRate();

        String currencyName = SelectedCurrency.getName();

        try {
            exchangeRate = exchangeRateService.getTodayRates(currencyName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return exchangeRate;
    }
}
