package com.hallapractice1.programmingproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private FragmentManager fragmentManager;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) { //구글맵 준비되면 호출되는 메소드
        LatLng location = new LatLng(37.3028339,127.9081367); // 한라대학교의 위도 경도를 입력해 시작위치 설정

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,16)); //구글맵을 시작할때 부드럽게 이동해주는 느낌을 주기위해 설정
    }

}
