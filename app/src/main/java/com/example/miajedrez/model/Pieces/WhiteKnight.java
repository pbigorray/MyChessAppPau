package com.example.miajedrez.model.Pieces;

import static com.example.miajedrez.model.ChessType.WHITE_KNIGHT;


import com.example.miajedrez.view.Cell;

/**
 * Clase WhiteKnight encargada de la logica de la pieza WhiteKnight
 * @author Pau Bigorra
 * @version 1.0
 */
public class WhiteKnight extends Knight{
    /**
     * Constructor del WhiteKnight
     *
     * @param cell Celda que contiene la pieza
     */
    public WhiteKnight(Cell cell) {
        super(cell, WHITE_KNIGHT);
        place();
    }
}