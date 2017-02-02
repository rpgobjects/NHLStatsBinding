package com.rpgobjects.nhlstatsbinding.ui;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.rpgobjects.nhlstatsbinding.R;
import com.rpgobjects.nhlstatsbinding.model.NHLDataTypes;
import com.squareup.picasso.Picasso;

import java.util.Locale;

/**
 * Created by chris on 1/27/17.
 */

public class GoaliePresenter extends BaseObservable {
    private NHLDataTypes.PlayerSummary playerSummary;
    private GoalieSelectedHandler goalieSelectedHandler;

    public GoaliePresenter(NHLDataTypes.PlayerSummary playerSummary) {
        this.playerSummary = playerSummary;
    }

    @Bindable
    public String getSavePercentage() {
        return String.format(Locale.getDefault(),"%1$,.3f", playerSummary.savePctg);
    }

    @Bindable
    public String getGoalsAgainst() {
        return String.format(Locale.getDefault(),"%1$,.2f", playerSummary.goalsAgainstAverage);
    }

    @Bindable
    public String getPlayerId() {
        return String.format(Locale.getDefault(),"%d", playerSummary.playerId);
    }

    @Bindable
    public String getPlayerName() {
        return playerSummary.playerName;
    }

    public void setPlayerSummary(NHLDataTypes.PlayerSummary playerSummary) {
        this.playerSummary = playerSummary;
        notifyChange();
    }

    @BindingAdapter("bind:actionShotId")
    public static void loadActionImage(ImageView view, String playerId) {
        Picasso.with(view.getContext()).load("https://nhl.bamcontent.com/images/actionshots/"+playerId+".jpg").placeholder(R.drawable.goalie_mask_black_silhouette).into(view);
    }

    @BindingAdapter("bind:headShotId")
    public static void loadProfileImage(ImageView view, String playerId) {
        Picasso.with(view.getContext()).load("https://nhl.bamcontent.com/images/headshots/current/168x168/"+playerId+".jpg").placeholder(R.drawable.goalie_mask_black_silhouette).into(view);
    }

    public void onGoalieSelected() {
        if(goalieSelectedHandler!=null) {
            goalieSelectedHandler.onGoalieSelected(playerSummary);
        }
    }

    public void setGoalieSelectedHandler(GoalieSelectedHandler goalieSelectedHandler) {
        this.goalieSelectedHandler = goalieSelectedHandler;
    }

    public interface GoalieSelectedHandler {
        public void onGoalieSelected(NHLDataTypes.PlayerSummary goalie);
    }
}
