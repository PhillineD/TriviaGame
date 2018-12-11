package com.example.phill.trivia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HighScoreAdapter extends ArrayAdapter<ListScoreItems> {
    Context context;
    public HighScoreAdapter(Context context, int resource, ArrayList<ListScoreItems> scores) {
        super(context, resource, scores);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.highscore_item, parent, false);

        }
        ListScoreItems Highscore = getItem(position);
        TextView username  = convertView.findViewById(R.id.username);
        TextView score = convertView.findViewById(R.id.score);
        score.setText(Highscore.getUsername());
        username.setText(Highscore.getScore());
        return convertView;
    }
}
