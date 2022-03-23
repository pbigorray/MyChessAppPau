package com.example.miajedrez.model.Pieces;

import static com.example.miajedrez.model.ChessType.WHITE_ROOK;


import com.example.miajedrez.view.Cell;

/**
 * Clase WhiteRook encargada de la logica de la pieza WhiteRook
 * @author Pau Bigorra
 * @version 1.0
 */
public class WhiteRook extends Rook{
    /**
     * Constructor del WhiteRook
     *
     * @param cell Celda que contiene la pieza
     */
    public WhiteRook(Cell cell) {
        super(cell, WHITE_ROOK);
        place();
    }
}