package com.example.miajedrez.model.Pieces;

import static com.example.miajedrez.model.ChessType.WHITE_KING;

import com.example.miajedrez.view.Cell;

/**
 * Clase WhiteKing encargada de la logica de la pieza WhiteKing
 * @author Pau Bigorra
 * @version 1.0
 */
public class WhiteKing extends King {
    /**
     * Constructor del WhiteKing
     *
     * @param cell Celda que contiene la pieza
     */
    public WhiteKing(Cell cell) {
        super(cell, WHITE_KING);
        place();

    }
}