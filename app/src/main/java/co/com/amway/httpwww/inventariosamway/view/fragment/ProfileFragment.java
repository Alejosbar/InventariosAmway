package co.com.amway.httpwww.inventariosamway.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.com.amway.httpwww.inventariosamway.R;
import co.com.amway.httpwww.inventariosamway.adapter.PictureAdapterRecyclerView;
import co.com.amway.httpwww.inventariosamway.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("", false, view);

        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);
        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buidPictures(), R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    public ArrayList<Picture> buidPictures() {
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://universomlm.com/file_drive/img-noticias/Productos-Amway.jpg", "Yehin Steven Patiño", "4 días", "3 Me gusta"));
        pictures.add(new Picture("https://pbs.twimg.com/profile_images/760207906117677056/3bg5fCik.jpg", "Alejandro Yazo", "3 días", "10 Me gusta"));
        pictures.add(new Picture("http://www.amway.com.co/img_pict/190_Common/carrusel/Hogar_ABR.png", "Anahi Salgado", "2 días", "9 Me gusta"));
        return  pictures;
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
