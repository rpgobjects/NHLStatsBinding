package com.rpgobjects.nhlstatsbinding.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rpgobjects.nhlstatsbinding.databinding.GoalieItemViewBinding;

/**
 * Created by chris on 1/31/17.
 */

public class GoalieViewHolder extends RecyclerView.ViewHolder {
    private GoalieItemViewBinding binding;

    public GoalieViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void setGoalie(GoaliePresenter goaliePresenter) {
        binding.setPresenter(goaliePresenter);
    }
}
