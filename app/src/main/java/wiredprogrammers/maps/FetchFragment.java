package wiredprogrammers.maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by yashtrivedi on 16 - Jun - 2017.
 */

public class FetchFragment extends Fragment implements SetMap{
int MY_LOCATION_REQUEST_CODE = 11001;
    private GoogleMap mMap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fetch_layout,container,false);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        configureMap();
    }

    private void configureMap(){
        if(mMap == null) return;
        mMap.clear();
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

            }
        });
        //add all fetched markers here
        mMap.addMarker(new MarkerOptions().position(new LatLng(10,10)));
    }
    @Override
    public Fragment setMap(GoogleMap map) {
        mMap = map;
        configureMap();
        return this;
    }
}
