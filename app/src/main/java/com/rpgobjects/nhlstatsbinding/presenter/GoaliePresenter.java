package com.rpgobjects.nhlstatsbinding.presenter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.rpgobjects.nhlstatsbinding.model.NHLDataTypes;

import java.util.Locale;

/**
 * Created by chris on 1/27/17.
 */

public class GoaliePresenter extends BaseObservable {
    private NHLDataTypes.PlayerSummary playerSummary;

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
}
