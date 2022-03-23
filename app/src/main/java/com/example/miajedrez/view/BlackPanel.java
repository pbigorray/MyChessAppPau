package com.example.miajedrez.view;

import android.content.Context;
import android.widget.GridLayout;

import com.example.miajedrez.model.IDeletePieceManager;
import com.example.miajedrez.model.Pieces.Piece;

public class BlackPanel extends GridLayout implements IDeletePieceManager {
    public BlackPanel(Context context) {
        super(context);
    }

    @Override
    public void add(Piece piece) {

    }
}
