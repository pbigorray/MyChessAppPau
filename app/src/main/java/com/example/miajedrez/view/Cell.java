package com.example.miajedrez.view;



import static com.example.miajedrez.view.Cell.CellColor.*;

import java.io.Serializable;


import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.miajedrez.R;
import com.example.miajedrez.model.Coordinate;
import com.example.miajedrez.model.Pieces.Piece;

/**
 * Clase Cell encargada de la creacion, utilizacion y representacion de cada celda
 * @author Pau Bigorra
 */
public class Cell extends androidx.appcompat.widget.AppCompatImageButton implements Serializable {
    private Coordinate coordinate;
    private CellColor color;
    private CellColor originalColor;
    private Piece piece;
    private Board board;



    /**
     * Metodo constructor de las celdas
     */
    public Cell(@NonNull Context context) {
        super(context);
    }

    public Cell(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Cell(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public Cell(@NonNull Context context, @Nullable AttributeSet attrs, Board board, Coordinate cordenada){
        super(context,attrs);

        this.board = board;
        this.coordinate = cordenada;
        if (((cordenada.getLetter()-'A') + cordenada.getNumber())%2==0){
            originalColor=CellColor.BLACK_CELL;
        } else {
            originalColor = CellColor.WHITE_CELL;
        }

        color = originalColor;
        setBackgroundColor(color.getAttribute());

    /*DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int padding = (int) (displayMetrics.density * 16);
    int width = displayMetrics.widthPixels - padding;

    int size = (width) / 10;

    setMaxWidth(size);
    setMaxHeight(size);
    setMinimumWidth(size);
    setMinimumHeight(size);*/

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //int padding = (int) (displayMetrics.density * 16);
        int padding = (int)(getResources().getDimension(R.dimen.board_padding) * 2);
        int width = displayMetrics.widthPixels - padding;
        getResources().getDimension(R.dimen.board_padding);

        int size = (width) / 10;

        setMinimumWidth(size);
        setMinimumHeight(size);
        setMaxWidth(size);
        setMaxHeight(size);

        setBackgroundColor(getResources().getColor(color.getAttribute(),getContext().getTheme()));
    }
  /*public Cell( Context context, Board board, Coordinate coordinate) {
      super(context);

      DisplayMetrics displayMetrics =new DisplayMetrics();
      ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

      int padding = (int) (displayMetrics.density*16);
      int width =displayMetrics.widthPixels-padding;

      int size =(width)/10;
      setMaxHeight(size);
      setMaxWidth(size);
      setMinimumHeight(size);
      setMinimumWidth(size);

        this.board = board;
        this.coordinate = coordinate;
        if (((coordinate.getLetter() - 'A') + coordinate.getNumber()) % 2 == 0)
            originalColor = CellColor.BLACK_CELL;
        else
            originalColor = CellColor.WHITE_CELL;

        color = originalColor;
        setBackgroundColor(color.getAttribute());
    }
*/

    /**
     * Getter del tablero
     * @return Devuelve el tablero
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Getter del cordenada
     * @return Devuelve la cordenada a la que corresponde
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Getter de la pieza que contiene
     * @return Devuelve la pieza que contiene
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Setter para colocar la pieza en la celda
     * @param piece Pieza a colocar
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
        //establecer imagen
        if(piece!=null){
            setImageResource(piece.getChessType().getShape());
            int pading =(int)(getResources().getDimension(R.dimen.piece_padding));
            setPadding(pading,pading,pading,pading);
            setScaleType(ScaleType.FIT_CENTER);
            setAdjustViewBounds(true);
        }else {
            setImageResource(0);
        }

    }

    /**
     * Getter para optener el color de la celda
     * @return Devuelve el color de la celda
     */
    public CellColor getColor() {
        return color;
    }

    /**
     * Metodo encargado de pintar las celdas a las que te puedes mover de distinto color
     */
    public void hightLight() {
        //otro if
        if (piece != null)
            color = (originalColor == WHITE_CELL) ? HIGHTLIGHT_KILL_WHITE : HIGHTLIGHT_KILL_BLACK;
        else
            color = (originalColor == WHITE_CELL) ? HIGHTLIGHT_WHITE : HIGHTLIGHT_BLACK;
        setBackgroundColor(color.getAttribute());
    }

    /**
     * Metodo encargado de poner los colores al los iniciales
     */
    public void resetColor() {
        color = originalColor;
        setBackgroundColor(originalColor.getAttribute());
    }

    /**
     * Enumerador de los colores de las celdas
     */
    public enum CellColor {
// cambiar los colores
        WHITE_CELL(R.color.cell_white_color),
        BLACK_CELL(R.color.cell_black_color),
        HIGHTLIGHT_KILL_WHITE(R.color.cell_kill_destination_color_white),
        HIGHTLIGHT_KILL_BLACK(R.color.cell_kill_destination_color_black),
        HIGHTLIGHT_WHITE(R.color.cell_destination_color_white),
        HIGHTLIGHT_BLACK(R.color.cell_destination_color_black);

        private int color;

        /**
         * Constructor del color de la celda
         * @param color Color por defecto
         */
        CellColor(int color) {
            this.color = color;
        }

        /**
         * Getter del color
         * @return Devuelve el color
         */
        public int getAttribute() {
            return color;
        }
    }
}