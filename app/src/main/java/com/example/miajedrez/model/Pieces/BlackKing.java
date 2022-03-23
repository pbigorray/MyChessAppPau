package com.example.miajedrez.model.Pieces;

import static com.example.miajedrez.model.ChessType.BLACK_KING;

import com.example.miajedrez.view.Cell;

/**
 * Clase BlackKing encargada de la logica de la pieza BlackKing
 * @author Pau Bigorra
 * @version 1.0
 */
public class BlackKing extends King {
    /**
     * Constructor del BlackKing
     *
     * @param cell Celda que contiene la pieza
     */
    public BlackKing (Cell cell){
        super(cell,BLACK_KING);
        place();
    }
}