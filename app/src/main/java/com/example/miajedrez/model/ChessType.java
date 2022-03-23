package com.example.miajedrez.model;

import com.example.miajedrez.R;
import com.example.miajedrez.model.Pieces.PieceColor;

/**
 * Enumerador encargado de poner el icono correcto al tipo de pieza correspondiente
 * @author Pau Bigorra
 * @version 1.0
 */
public enum ChessType {

    WHITE_KING(R.mipmap.ic_white_king_foreground, PieceColor.WHITE),
    WHITE_QUEEN(R.mipmap.ic_white_queen_foreground, PieceColor.WHITE),
    WHITE_ROOK(R.mipmap.ic_white_rook_foreground, PieceColor.WHITE),
    WHITE_BISHOP(R.mipmap.ic_white_bishop_foreground, PieceColor.WHITE),
    WHITE_KNIGHT(R.mipmap.ic_white_knight_foreground, PieceColor.WHITE),
    WHITE_PAWN(R.mipmap.ic_white_pawn_foreground, PieceColor.WHITE),
    BLACK_KING(R.mipmap.ic_black_king_foreground, PieceColor.BLACK),
    BLACK_QUEEN(R.mipmap.ic_black_queen_foreground, PieceColor.BLACK),
    BLACK_ROOK(R.mipmap.ic_black_rook_foreground, PieceColor.BLACK),
    BLACK_BISHOP(R.mipmap.ic_black_bishop_foreground, PieceColor.BLACK),
    BLACK_KNIGHT(R.mipmap.ic_black_knight_foreground, PieceColor.BLACK),
    BLACK_PAWN(R.mipmap.ic_black_pawn_foreground, PieceColor.BLACK);

    private int shape;
    private PieceColor color;

    /**
     * Constructor del ChessType
     * @param shape
     * @param color
     */
    ChessType(int shape,PieceColor color){
        this.shape = shape;
        this.color = color;
    }

    /**
     * Getter de la forma de la pieza
     * @return Devuelve el icono correspondiente
     */
    public int getShape(){
        return shape;
    }

    /**
     * Getter del color de la pieza
     * @return Devuelve el color correspondiente
     */
    public PieceColor getColor() {
        return color;
    }

}