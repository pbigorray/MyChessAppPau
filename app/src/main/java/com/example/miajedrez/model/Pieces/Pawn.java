package com.example.miajedrez.model.Pieces;

import com.example.miajedrez.model.ChessType;
import com.example.miajedrez.view.Cell;

/**
 * Clase abtracta Pawn la cual hederan las fichas para sus respectivos colores
 * @author Pau Bigorra
 * @version 1.0
 */
public abstract class Pawn extends Piece {
    /**
     * Constructor del Pawn
     *
     * @param cell      Celda que contiene la pieza
     * @param chessType Tipo de la pieza
     */
    public Pawn(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

}