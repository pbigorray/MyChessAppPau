package com.example.miajedrez.model.Pieces;


import java.io.Serializable;

/**
 * Enumerador de el color al cual puede pertenecer las piezas
 * @author Pau Bigorra
 * @version 1.0
 */
public enum PieceColor implements Serializable {
    WHITE,
    BLACK;

    private String color;

    /**
     * Constructor del color de la pieza
     * @param
     */
    PieceColor(){
        this.color = color;
    }

    /**
     * Getter del color de la pieza
     * @return Devuelve el color
     */
    public String getAttribute(){
        return color;
    }

}