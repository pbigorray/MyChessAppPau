package com.example.miajedrez.model.Pieces;



import static com.example.miajedrez.model.ChessType.BLACK_BISHOP;

import com.example.miajedrez.model.ChessType;
import com.example.miajedrez.view.Cell;

/**
 * Clase BlackBishop encargada de la logica de la pieza BlackBishop
 * @author Pau Bigorra
 * @version 1.0
 */
public class BlackBishop extends Bishop {


    /**
     * Constructor del BlackBishop
     *
     * @param cell Celda que contiene la pieza
     */
    public BlackBishop(Cell cell) {
        super(cell, BLACK_BISHOP);
        place();
    }
}