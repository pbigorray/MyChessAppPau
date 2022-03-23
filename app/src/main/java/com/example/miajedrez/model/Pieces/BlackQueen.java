package com.example.miajedrez.model.Pieces;

import static com.example.miajedrez.model.ChessType.BLACK_QUEEN;


import com.example.miajedrez.view.Cell;

/**
 * Clase BlackQueen encargada de la logica de la pieza BlackQueen
 * @author Pau Bigorra
 * @version 1.0
 */
public class BlackQueen extends Queen {
    /**
     * Constructor del BlackQueen
     *
     * @param cell Celda que contiene la pieza
     */
    public BlackQueen(Cell cell) {
        super(cell, BLACK_QUEEN);
        place();
    }
}