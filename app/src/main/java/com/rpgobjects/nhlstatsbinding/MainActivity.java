package com.rpgobjects.nhlstatsbinding;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.rpgobjects.nhlstatsbinding.databinding.ActivityMainBinding;
import com.rpgobjects.nhlstatsbinding.model.NHLDataTypes;
import com.rpgobjects.nhlstatsbinding.model.NHLService;
import com.rpgobjects.nhlstatsbinding.model.ServiceGenerator;
import com.rpgobjects.nhlstatsbinding.presenter.GoaliePresenter;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
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
    }

    @BindingAdapter("bind:playerId")
    public static void loadImage(ImageView view, String playerId) {
        Picasso.with(view.getContext()).load("https://nhl.bamcontent.com/images/actionshots/"+playerId+".jpg").placeholder(R.drawable.goalie_mask_black_silhouette).into(view);
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
                binding.getGoalieB().setPlayerSummary(statsSearchResult.playerList.get(10));
            }

            @Override
            public void onFailure(Call<NHLDataTypes.StatsSearchResult> call, Throwable t) {

            }
        });
    }
}

