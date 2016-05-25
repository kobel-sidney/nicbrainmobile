package br.com.nicbrain.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import br.com.nicbrain.R;
import br.com.nicbrain.ui.fragment.ChecklistFragment;
import br.com.nicbrain.ui.fragment.EventFragment;

public class ChecklistActivity extends MainActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            getSupportActionBar().setTitle(extras.getString("nomeEvento"));
        }else{
            getSupportActionBar().setTitle("Checklist");
        }

        initFragment();

    }


    private void initFragment() {
        ChecklistFragment fragment = new ChecklistFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

}
