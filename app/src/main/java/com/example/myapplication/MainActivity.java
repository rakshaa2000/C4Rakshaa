package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Stack;

import views.CanvasView;

public class MainActivity extends AppCompatActivity {

    private CanvasView can1;
    private int l1=5,l2=5,l3=5,l4=5,l5=5,l6=5,l7=5;
    //private int lastX,lastY;
    public Stack xStack= new Stack<>();
    public Stack yStack= new Stack<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        can1=(CanvasView)findViewById(R.id.can1);
        can1.assigntxt();
//        if(can1.game>0){
//            can1.checkWinner();
//        }
        findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(can1.game>0){
                    reset();
                    can1.game=0;
                    can1.changeColor(1, l1);
                    xStack.push(0);
                    yStack.push(l1);
                    l1--;
                }
                else if(l1>=0){
                    can1.changeColor(1, l1);
                    xStack.push(0);
                    yStack.push(l1);
                    l1--;
                }
            }
        });
        findViewById(R.id.b2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(can1.game>0){
                    reset();
                    can1.game=0;
                    can1.changeColor(2, l2);
                    xStack.push(1);
                    yStack.push(l2);
                    l2--;
                }
                else if(l2>=0){
                    can1.changeColor(2, l2);
                    xStack.push(1);
                    yStack.push(l2);
                    l2--;
                }
            }
        });
        findViewById(R.id.b3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(can1.game>0){
                    reset();
                    can1.game=0;
                    can1.changeColor(3, l3);
                    xStack.push(2);
                    yStack.push(l3);
                    l3--;
                }
                else if(l3>=0){
                    can1.changeColor(3, l3);
                    xStack.push(2);
                    yStack.push(l3);
                    l3--;
                }
            }
        });
        findViewById(R.id.b4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(can1.game>0){
                    reset();
                    can1.game=0;
                    can1.changeColor(4, l4);
                    xStack.push(3);
                    yStack.push(l4);
                    l4--;
                }
                else if(l4>=0){
                    can1.changeColor(4, l4);
                    xStack.push(3);
                    yStack.push(l4);
                    l4--;
                }
            }
        });
        findViewById(R.id.b5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(can1.game>0){
                    reset();
                    can1.game=0;
                    can1.changeColor(5, l5);
                    xStack.push(4);
                    yStack.push(l5);
                    l5--;
                }
                else if(l5>=0){
                    can1.changeColor(5, l5);
                    xStack.push(4);
                    yStack.push(l5);
                    l5--;
                }
            }
        });
        findViewById(R.id.b6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(can1.game>0){
                    reset();
                    can1.game=0;
                    can1.changeColor(6, l6);
                    xStack.push(5);
                    yStack.push(l6);
                    l6--;
                }
                else if(l6>=0){
                    can1.changeColor(6, l6);
                    xStack.push(5);
                    yStack.push(l6);
                    l6--;
                }
            }
        });
        findViewById(R.id.b7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(can1.game>0){
                    reset();
                    can1.game=0;
                    can1.changeColor(7, l7);
                    xStack.push(6);
                    yStack.push(l7);
                    l7--;
                }
                else if(l7>=0){
                    can1.changeColor(7, l7);
                    xStack.push(6);
                    yStack.push(l7);
                    l7--;
                }
            }
        });
        findViewById(R.id.undo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(xStack.empty()||yStack.empty())) {
                    int x = (int) xStack.pop();
                    int y = (int) yStack.pop();
                    can1.undo(x, y);
                    switch (x) {
                        case 0:
                            l1++;
                            break;
                        case 1:
                            l2++;
                            break;
                        case 2:
                            l3++;
                            break;
                        case 3:
                            l4++;
                            break;
                        case 4:
                            l5++;
                            break;
                        case 5:
                            l6++;
                            break;
                        case 6:
                            l7++;
                            break;
                    }

                }
                can1.cpaint.setColor(can1.cpaint.getColor()==Color.YELLOW?Color.RED:Color.YELLOW);
            }
        });
        //checkWinner();
    }
    public void reset(){
        l1=5;
        l2=5;
        l3=5;
        l4=5;
        l5=5;
        l6=5;
        l7=5;
    }
}
