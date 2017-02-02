package com.rpgobjects.nhlstatsbinding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rpgobjects.nhlstatsbinding.model.NHLDataTypes;
import com.rpgobjects.nhlstatsbinding.ui.GoalieAdapter;
import com.rpgobjects.nhlstatsbinding.ui.GoaliePresenter;

public class PlayerPickerActivity extends AppCompatActivity {
    GoalieAdapter adapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, PlayerPickerActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }

    public static void start(Activity activity,int code) {
        Intent starter = new Intent(activity, PlayerPickerActivity.class);
        //starter.putExtra();
        activity.startActivityForResult(starter, code);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_picker);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        String json = PreferenceManager.getDefaultSharedPreferences(this).getString("goalies","");
        NHLDataTypes.StatsSearchResult statsSearchResult = NHLDataTypes.StatsSearchResult.fromJson(json);
        adapter = new GoalieAdapter(statsSearchResult.playerList);
        recyclerView.setAdapter(adapter);
        adapter.setGoalieSelectedHandler(new GoaliePresenter.GoalieSelectedHandler() {
            @Override
            public void onGoalieSelected(NHLDataTypes.PlayerSummary goalie) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("goalie", goalie.toJson());
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }

}
