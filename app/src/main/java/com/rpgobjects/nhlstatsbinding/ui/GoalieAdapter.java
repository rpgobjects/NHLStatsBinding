package com.rpgobjects.nhlstatsbinding.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rpgobjects.nhlstatsbinding.R;
import com.rpgobjects.nhlstatsbinding.model.NHLDataTypes;

import java.util.List;


public class GoalieAdapter extends RecyclerView.Adapter<GoalieViewHolder> {
    private List<NHLDataTypes.PlayerSummary> playerList;
    private GoaliePresenter.GoalieSelectedHandler goalieSelectedHandler;

    public GoalieAdapter(List<NHLDataTypes.PlayerSummary> playerList) {
        this.playerList = playerList;
    }

    @Override
    public GoalieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goalie_item_view,parent,false);
        return new GoalieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GoalieViewHolder holder, int position) {
        GoaliePresenter goaliePresenter = new GoaliePresenter(playerList.get(position));
        goaliePresenter.setGoalieSelectedHandler(goalieSelectedHandler);
        holder.setGoalie(goaliePresenter);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public void setGoalieSelectedHandler(GoaliePresenter.GoalieSelectedHandler goalieSelectedHandler) {
        this.goalieSelectedHandler = goalieSelectedHandler;
    }
}
