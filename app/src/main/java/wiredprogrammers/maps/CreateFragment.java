package wiredprogrammers.maps;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by yashtrivedi on 16 - Jun - 2017.
 */

public class CreateFragment extends Fragment implements SetMap{
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private GoogleMap mMap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.create_layout,container,false);

        return v;
    }

    GoogleMap.OnMapClickListener mapClickListener = new GoogleMap.OnMapClickListener() {
        @Override
        public void onMapClick(LatLng latLng) {
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(latLng));
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        configureMap();
    }

    private void configureMap(){
        if(mMap ==null) return;
        mMap.clear();
        mMap.setOnMapClickListener(mapClickListener);
        mMap.addMarker(new MarkerOptions().position(new LatLng(10,10)));
    }

    @Override
    public Fragment setMap(GoogleMap map) {
        mMap = map;
        configureMap();
        return this;
    }
}
