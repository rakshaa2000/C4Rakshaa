package views;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.Circle;
import com.example.myapplication.R;

import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.zip.CheckedOutputStream;


public class CanvasView extends View {

    private Rect rect;
    private Paint paint;
    private int size = 130;
    public Paint cpaint;
    private int col=100, row=100;
    private Canvas canvas;
    public Circle[][] circle;
    public int game=0;
    public Paint wpaint;
    public TextView txt;
    public CanvasView(Context context) {
        super(context);
        init(null);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
//    public void drawC(int c, int r){
//        this.col=c;
//        this.row=r;
//        postInvalidate();
//    }
    public void assigntxt(){
        txt=this.getRootView().findViewById(R.id.txt);
    }
    private void init(@Nullable AttributeSet attrs) {
        rect = new Rect();
        paint = new Paint();
        paint.setColor(Color.BLUE);
        cpaint=new Paint();
        cpaint.setColor(Color.RED);
        circle= new Circle[7][6];
        //txt=this.getRootView().findViewById(R.id.txt);
        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                circle[i][j]=new Circle();
                circle[i][j].paint.setColor(Color.WHITE);
            }
        }
        wpaint=new Paint();
        wpaint.setColor(Color.WHITE);
    }
    public void undo(int X,int Y){
        circle[X][Y].paint.setColor(Color.WHITE);
        postInvalidate();
    }
    public void changeColor(int colno,int bottom){
        for(int j=5; j>=bottom; j--){
            if((cpaint.getColor()==Color.RED)&&(circle[colno-1][j].paint.getColor()==Color.WHITE)) {
                circle[colno-1][j].paint.setColor(Color.RED);
                cpaint.setColor(Color.YELLOW);
            }
            else if((cpaint.getColor()==Color.YELLOW)&&(circle[colno-1][j].paint.getColor()==Color.WHITE)){
                circle[colno-1][j].paint.setColor(Color.YELLOW);
                cpaint.setColor(Color.RED);
            }
        }
        postInvalidate();
    }
//    public void undo(int lastX,int lastY){
//        circle[lastX][lastY].paint.setColor(Color.WHITE);
//        cpaint.setColor(cpaint.getColor()==Color.YELLOW?Color.RED:Color.YELLOW);
//        postInvalidate();
//    }
    public void horiz(){
        for(int j=0; j<6; j++){
            for(int i=0; i<4; i++){
                if((circle[i][j].paint.getColor()==circle[i+1][j].paint.getColor())&&(circle[i][j].paint.getColor()==circle[i+2][j].paint.getColor())&&(circle[i][j].paint.getColor()==circle[i+3][j].paint.getColor())&&(circle[i][j].paint.getColor()!=Color.WHITE)) {
                    //paint.setColor(Color.BLACK);
                    wpaint.setColor(circle[i][j].paint.getColor());
                    newGame();
                    //break;
                }
            }
//            if(paint.getColor()==Color.BLACK)
//                break;
        }
        //postInvalidate();
    }
    public void vert(){
        for(int i=0; i<7; i++){
            for(int j=0; j<3; j++){
                if((circle[i][j].paint.getColor()==circle[i][j+1].paint.getColor())&&(circle[i][j].paint.getColor()==circle[i][j+2].paint.getColor())&&(circle[i][j].paint.getColor()==circle[i][j+3].paint.getColor())&&(circle[i][j].paint.getColor()!=Color.WHITE)) {
                    //paint.setColor(Color.BLACK);
                    //wpaint=circle[i][j].paint;
                    wpaint.setColor(circle[i][j].paint.getColor());
                    newGame();
                    //break;
                }
            }
//            if(paint.getColor()==Color.BLACK)
//                break;
        }
        //postInvalidate();
    }
    public void leftDown(){
        for(int i=0; i<4; i++){
            for (int j=0; j<3; j++){
                if((circle[i][j].paint.getColor()==circle[i+1][j+1].paint.getColor())&&(circle[i][j].paint.getColor()==circle[i+2][j+2].paint.getColor())&&(circle[i][j].paint.getColor()==circle[i+3][j+3].paint.getColor())&&circle[i][j].paint.getColor()!=Color.WHITE){
                    //paint.setColor(Color.BLACK);
                    wpaint.setColor(circle[i][j].paint.getColor());
                    //wpaint=circle[i][j].paint;
                    newGame();
                    //break;
                }
            }
        }
        //postInvalidate();
    }
    public void rightUp(){
        for(int i=6; i>=3; i--){
            for(int j=0;j<3; j++){
                if((circle[i][j].paint.getColor()==circle[i-1][j+1].paint.getColor())&&(circle[i][j].paint.getColor()==circle[i-2][j+2].paint.getColor())&&(circle[i][j].paint.getColor()==circle[i-3][j+3].paint.getColor())&&circle[i][j].paint.getColor()!=Color.WHITE){
                    //paint.setColor(Color.BLACK);
                    //wpaint=circle[i][j].paint;
                    wpaint.setColor(circle[i][j].paint.getColor());
                    newGame();
                    //break;
                }
            }
        }
        //postInvalidate();
    }
    public void newGame(){
        //checkWinner();
        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                circle[i][j].paint.setColor(Color.WHITE);
            }
        }
        game++;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas=canvas;
        int c=0;
        //
        //txt.setText("Hello");
        canvas.drawRect(50,50,995,995,paint);
        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                circle[i][j].x=(float)(117.5+135*i);
                circle[i][j].y=(float)(117.5+156*j);
                circle[i][j].rad=50;
                canvas.drawCircle(circle[i][j].x,circle[i][j].y,circle[i][j].rad,circle[i][j].paint);

            }
        }
        horiz();
        vert();
        leftDown();
        rightUp();
        if(wpaint.getColor()==Color.YELLOW){
            txt.setText("Yellow wins");
        }
        if(wpaint.getColor()==Color.RED){
            txt.setText("Red Wins");
        }
        for(int i=0; i<7; i++){
            if(circle[i][0].paint.getColor()!=Color.WHITE){
                c++;
            }
        }
        if(c==7){
            newGame();
            txt.setText("It is a Draw");
        }
    }
}

