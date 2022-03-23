package com.example.miajedrez.view;



import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.miajedrez.R;
import com.example.miajedrez.model.ChessType;
import com.example.miajedrez.model.Coordinate;
import com.example.miajedrez.model.IDeletePieceManager;
import com.example.miajedrez.model.Piece;
import com.example.miajedrez.model.PieceColor;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Clase Board encargada de la creacion del tablero asi como su modificacion y representacion
 * @author Pau Bigorra
 */
public class Board extends TableLayout implements Serializable {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private Map<Coordinate, Cell> cells;
    private IDeletePieceManager store;
    private List<Piece> whitePiece;
    private List<Piece> blackPiece;

    /**
     * Metodo constructor del tablero
     */
    public Board(Context context, AttributeSet attrs) {
        super(context, attrs);

        cells = new HashMap<>();
        //store = new IDeletePieceManager();

        initializeCells();
        LOGGER.finest("Board created.");
    }
    /**
     * Metodo constructor del tablero
     */
//    public Board(Context context) {
//        super(context);
//        cells = new HashMap<>();
//       // store = new MyStore();
//        whitePiece = new LinkedList<>();
//        blackPiece = new LinkedList<>();
//
//        Coordinate coordinate;
//        Cell cell;
//        TableRow tableRow;
//
//        for (int row = 1; row <= 8; row++) {
//            tableRow =new TableRow(getContext());
//            for (int col = 0; col < 8; col++) {
//                coordinate = new Coordinate((char) ('A' + col), row);
//                cell = new Cell(context,this, coordinate);
//                cells.put(coordinate, cell);
//                tableRow.addView(cell);
//            }
//            addView(tableRow);
//        }
//
//        placePieces();
//
//    }
    private void initializeCells() {
        Coordinate coordinate;
        Cell cell;
        TableRow tableRow;

        tableRow = new TableRow(getContext());
        tableRow.addView(getNewLabel(""));
        for(int i='A';i<='H';i++)
            tableRow.addView(getNewLabel(String.valueOf((char)i)));
        tableRow.addView(getNewLabel(""));
        addView(tableRow);

        for (int row = 0; row < 8; row++) {
            tableRow = new TableRow(getContext());
            tableRow.addView(getNewLabel(String.valueOf(row)));
            for (int col = 0; col < 8; col++) {
                coordinate = new Coordinate((char) ('A' + col), 1 + row);
                cell = new Cell(getContext(),null,this, coordinate);

                cells.put(coordinate, cell);
                tableRow.addView(cell);
            }
            tableRow.addView(getNewLabel(String.valueOf(row)));

            addView(tableRow);
        }

        tableRow = new TableRow(getContext());
        tableRow.addView(getNewLabel(""));
        for(int i='A';i<='H';i++)
            tableRow.addView(getNewLabel(String.valueOf((char)i)));
        tableRow.addView(getNewLabel(""));
        addView(tableRow);
    }
    public TextView getNewLabel(String characters) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
       // int padding = (int) (displayMetrics.density * 16);
        int padding = (int)(getResources().getDimension(R.dimen.board_padding) * 2);
        int width = displayMetrics.widthPixels - padding;

        TextView textView = new TextView(getContext());
        textView.setText(characters);
        textView.setBackgroundColor(getResources().getColor(R.color.label_border_color,getContext().getTheme()));
        textView.setTextColor(getResources().getColor(R.color.white,getContext().getTheme()));
        textView.setGravity(Gravity.CENTER);
        textView.setWidth(width / 10);
        textView.setHeight(width / 10);
        return textView;
    }
    /**
     * Metodo encargado de colocar las piezas al inicio de la partida
     */
    private void placePieces() {
        //cambiar a coordinates
//        for (int i = 0; i < 8; i++) {
//            blackPiece.add(new BlackPawn(getCellAt(new Coordinate((char) ('A' + i), 2))));
//            whitePiece.add(new WhitePawn(getCellAt(new Coordinate((char) ('A' + i), 7))));
//
//        }
//        //White
//        whitePiece.add(new WhiteRook(getCellAt(new Coordinate('H', 8))));
//        whitePiece.add(new WhiteRook(getCellAt(new Coordinate('A', 8))));
//
//        whitePiece.add(new WhiteKnight(getCellAt(new Coordinate('G', 8))));
//        whitePiece.add(new WhiteKnight(getCellAt(new Coordinate('B', 8))));
//
//        whitePiece.add(new WhiteBishop(getCellAt(new Coordinate('F', 8))));
//        whitePiece.add(new WhiteBishop(getCellAt(new Coordinate('C', 8))));
//
//        whitePiece.add(new WhiteKing(getCellAt(new Coordinate('E', 8))));
//        whitePiece.add(new WhiteQueen(getCellAt(new Coordinate('D', 8))));
//
//        //Black
//        blackPiece.add(new BlackRook(getCellAt(new Coordinate('H', 1))));
//        blackPiece.add(new BlackRook(getCellAt(new Coordinate('A', 1))));
//
//        blackPiece.add(new BlackKnight(getCellAt(new Coordinate('G', 1))));
//        blackPiece.add(new BlackKnight(getCellAt(new Coordinate('B', 1))));
//
//        blackPiece.add(new BlackBishop(getCellAt(new Coordinate('F', 1))));
//        blackPiece.add(new BlackBishop(getCellAt(new Coordinate('C', 1))));
//
//        blackPiece.add(new BlackKing(getCellAt(new Coordinate('D', 1))));
//        blackPiece.add(new BlackQueen(getCellAt(new Coordinate('E', 1))));


    }

    /**
     * Metodo encargado de hacer una lista con la piezas blancas
     *
     * @return Devuelve una lista con las piezas blancas
     */
    public List<Piece> getWhitePiece() {
        List<Piece> pieces = new ArrayList<>();
        for (Cell cell : cells.values())
            if (cell.getPiece() != null && cell.getPiece().getColor() == PieceColor.BLACK) {
                pieces.add(cell.getPiece());
            }
        return pieces;

    }

    /**
     * Metodo encargado de hacer una lista con la piezas negras
     *
     * @return Devuelve una lista con las piezas negras
     */
    public List<Piece> getBlackPiece() {
        List<Piece> pieces = new ArrayList<>();
        for (Cell cell : cells.values())
            if (cell.getPiece() != null && cell.getPiece().getColor() == PieceColor.BLACK) {
                pieces.add(cell.getPiece());
            }
        return pieces;
    }

    /**
     * Geter de las celdas del tablero
     *
     * @return Devuelve las celdas del tablero
     */
    public Map<Coordinate, Cell> getCells() {
        return cells;
    }

    /**
     * Geter para optener el almacen de piezas
     *
     * @return Devuelve el elmacen de piezas
     */
    public IDeletePieceManager getStore() {
        return store;
    }

    /**
     * Metodo encargado de comprobar si hay jaque
     *
     * @param turn Turno en el que se comprueba el jaque
     * @return Devuelve verdadero si hay jaque
     */
    public boolean isJaque(PieceColor turn) {
        List<Piece> enemys;
        Set<Coordinate> movimentsEnemys = new HashSet<>();

        if (turn == PieceColor.WHITE) {
            enemys = getBlackPiece();
        } else {
            enemys = getWhitePiece();
        }
        for (Piece piece : enemys) {
            movimentsEnemys.addAll(piece.getNextMovements());
        }
        if (movimentsEnemys.contains(kingCorrdinate(turn)))
            return true;
        return false;
    }

    /**
     * Metodo encargado que optener las cordenadas del rey en ese turno
     *
     * @param turn Turno en el que se comprueba el jaque
     * @return Devuelve las cordenadas en las que se encuentra el rey
     */
    private Coordinate kingCorrdinate(PieceColor turn) {
        List<Piece> pices;
        Coordinate king = null;
        if (turn == PieceColor.WHITE) {
            pices = getWhitePiece();
            for (Piece piece : pices) {
                if (piece.getChessType() == ChessType.WHITE_KING) {
                    king = piece.getCell().getCoordinate();
                }
            }
        } else {
            pices = getBlackPiece();
            for (Piece piece : pices) {
                if (piece.getChessType() == ChessType.BLACK_KING) {
                    king = piece.getCell().getCoordinate();
                }
            }
        }
        return king;
    }

    /**
     * Metodo encardo de comprobar si las cordenadas son de una celda
     *
     * @param coordinate Cordenadas a comprobar
     * @return Devuelve verdadero si las celdas contienen esa cordenada
     */
    public boolean containsCellAt(Coordinate coordinate) {
//        if(coordinate.getLetter()<'A'|| coordinate.getLetter()>'H')
//            return false;
//        if(coordinate.getNumber()<1 || coordinate.getNumber()>8)
//            return false;

//        Cell c =cells.get(coordinate);
//
//        return c!=null;

        return cells.containsKey(coordinate);
    }

    /**
     * Metodo encargado de comprobar si la cordenada contiene una pieza
     *
     * @param coordinate Cordenadas a comprobar
     * @return Devuelve verdadero si las celdas contienen una pieza
     */
    public boolean containsPieceAt(Coordinate coordinate) {
        Cell cell = getCellAt(coordinate);
        if (cell == null) return false;
        return (cell.getPiece() != null);
    }

    /**
     * Geter de la cellda de una cordenada
     *
     * @param coordinate Cordenadas a comprobar
     * @return Devuelve una celda
     */
    public Cell getCellAt(Coordinate coordinate) {
        return cells.get(coordinate);
    }
//    public String toString(){
//        String salida="";
//        for (int row=0;row<8;row++){
//            for (int col=0;col<8;col++){
//                salida+=cells[row][col].toString();
//            }
//            salida+="\n";
//        }
//        return salida;
//    }

    /**
     * Metodo para contar piezas del tablero por un ChessType
     *
     * @param chessType ChessType que quieres contar
     * @return Devuelve el numero de piezas de ese tipo
     */
    public long count(ChessType chessType) {
        return this.cells.values().stream()
                .filter(cell -> cell.getPiece() != null && cell.getPiece().getChessType() == chessType)
                .count();
    }

    /**
     * Metodo para ver los movimientos de las piezas blancas??
     */
    public void moviments() {
        Set<Coordinate> moviments = cells.values().stream()
                .filter(cell -> cell.getPiece() != null)
                .map(cell -> cell.getPiece())
                .filter(piece -> piece.getColor() == PieceColor.WHITE)
                .flatMap(piece -> piece.getNextMovements().stream())
                .collect(Collectors.toSet());

        System.out.println(moviments);
    }

    /**
     * Metodo para resaltar las celdas a las que te puedes mover
     *
     * @param coordinates Lista de cordenadas a resaltar
     */
    public void hightLight(List<Coordinate> coordinates) {
        for (Coordinate coordinate : coordinates)
            getCellAt(coordinate).hightLight();
    }

    /**
     * Metodo para resetear los colores de las celdas
     */
    public void resetColors() {

        for (Cell cell : cells.values())
            cell.resetColor();
    }

}