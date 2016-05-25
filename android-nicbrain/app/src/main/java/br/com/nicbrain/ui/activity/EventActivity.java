package br.com.nicbrain.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import br.com.nicbrain.R;
import br.com.nicbrain.ui.fragment.EventFragment;

public class EventActivity extends MainActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment();

    }


    private void initFragment() {
        EventFragment fragment = new EventFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

}
