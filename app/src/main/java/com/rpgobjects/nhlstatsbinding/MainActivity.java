package com.rpgobjects.nhlstatsbinding;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rpgobjects.nhlstatsbinding.databinding.ActivityMainBinding;
import com.rpgobjects.nhlstatsbinding.model.NHLDataTypes;
import com.rpgobjects.nhlstatsbinding.model.NHLService;
import com.rpgobjects.nhlstatsbinding.model.ServiceGenerator;
import com.rpgobjects.nhlstatsbinding.ui.GoaliePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final int GOALIE_A = 955;
    private static final int GOALIE_B = 956;

    ActivityMainBinding binding;
    NHLDataTypes.StatsSearchResult statsSearchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setGoalieA(new GoaliePresenter(new NHLDataTypes.PlayerSummary()));
        binding.setGoalieB(new GoaliePresenter(new NHLDataTypes.PlayerSummary()));
        setSupportActionBar(binding.toolBar);
        loadGoalies();
        binding.setDark(true);
        // presenter event handler used by lambda expression
        binding.getGoalieB().setGoalieSelectedHandler(new GoaliePresenter.GoalieSelectedHandler() {
            @Override
            public void onGoalieSelected(NHLDataTypes.PlayerSummary goalie) {
                PlayerPickerActivity.start(MainActivity.this,GOALIE_B);
            }
        });

    }

    // old school method reference handler
    public void onGoalieA(View view) {
        PlayerPickerActivity.start(this,GOALIE_A);
    }

    public void loadGoalies() {
        NHLService service = ServiceGenerator.createService(NHLService.class);
        Call<NHLDataTypes.StatsSearchResult> call = service.getGoalieStats("seasonId=20162017 and gameTypeId=2 and playerPositionCode=\"G\"",
                "gamesPlayed>=14",
                "[{\"property\":\"goalsAgainstAverage\",\"direction\":\"ASC\"}]");
        call.enqueue(new Callback<NHLDataTypes.StatsSearchResult>() {
            @Override
            public void onResponse(Call<NHLDataTypes.StatsSearchResult> call, Response<NHLDataTypes.StatsSearchResult> response) {
                statsSearchResult = response.body();
                binding.getGoalieA().setPlayerSummary(statsSearchResult.playerList.get(0));
                binding.getGoalieB().setPlayerSummary(statsSearchResult.playerList.get(1));
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("goalies",statsSearchResult.toJson()).apply();
            }

            @Override
            public void onFailure(Call<NHLDataTypes.StatsSearchResult> call, Throwable t) {

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK) {
            NHLDataTypes.PlayerSummary playerSummary = NHLDataTypes.PlayerSummary.fromJson(data.getStringExtra("goalie"));
            if(requestCode==GOALIE_A) {
                binding.getGoalieA().setPlayerSummary(playerSummary);
            } else {
                binding.getGoalieB().setPlayerSummary(playerSummary);
            }
        }
    }
}

