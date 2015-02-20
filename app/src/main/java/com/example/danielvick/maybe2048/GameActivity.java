package com.example.danielvick.maybe2048;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;


public class GameActivity extends ActionBarActivity implements View.OnClickListener {

    protected Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.board = new Board(4, new Random());
        display(this.board);

        Button Up = (Button) findViewById(R.id.Up);
        Up.setOnClickListener(this);
        Button Down = (Button) findViewById(R.id.Down);
        Down.setOnClickListener(this);
        Button Left = (Button) findViewById(R.id.Left);
        Left.setOnClickListener(this);
        Button Right = (Button) findViewById(R.id.Right);
        Right.setOnClickListener(this);
        //Random random1 = new Random();
        //GameManager game = new GameManager(4, random1);
        //try {
        //    game.play();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void display(Board board) {
        TextView tv00 = (TextView) findViewById(R.id.R0C0);
        TextView tv01 = (TextView) findViewById(R.id.R0C1);
        TextView tv02 = (TextView) findViewById(R.id.R0C2);
        TextView tv03 = (TextView) findViewById(R.id.R0C3);
        TextView tv10 = (TextView) findViewById(R.id.R1C0);
        TextView tv11 = (TextView) findViewById(R.id.R1C1);
        TextView tv12 = (TextView) findViewById(R.id.R1C2);
        TextView tv13 = (TextView) findViewById(R.id.R1C3);
        TextView tv20 = (TextView) findViewById(R.id.R2C0);
        TextView tv21 = (TextView) findViewById(R.id.R2C1);
        TextView tv22 = (TextView) findViewById(R.id.R2C2);
        TextView tv23 = (TextView) findViewById(R.id.R2C3);
        TextView tv30 = (TextView) findViewById(R.id.R3C0);
        TextView tv31 = (TextView) findViewById(R.id.R3C1);
        TextView tv32 = (TextView) findViewById(R.id.R3C2);
        TextView tv33 = (TextView) findViewById(R.id.R3C3);
        tv00.setText(Integer.toString(board.grid[0][0]));
        tv01.setText(Integer.toString(board.grid[0][1]));
        tv02.setText(Integer.toString(board.grid[0][2]));
        tv03.setText(Integer.toString(board.grid[0][3]));
        tv10.setText(Integer.toString(board.grid[1][0]));
        tv11.setText(Integer.toString(board.grid[1][1]));
        tv12.setText(Integer.toString(board.grid[1][2]));
        tv13.setText(Integer.toString(board.grid[1][3]));
        tv20.setText(Integer.toString(board.grid[2][0]));
        tv21.setText(Integer.toString(board.grid[2][1]));
        tv22.setText(Integer.toString(board.grid[2][2]));
        tv23.setText(Integer.toString(board.grid[2][3]));
        tv30.setText(Integer.toString(board.grid[3][0]));
        tv31.setText(Integer.toString(board.grid[3][1]));
        tv32.setText(Integer.toString(board.grid[3][2]));
        tv33.setText(Integer.toString(board.grid[3][3]));

    }



    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.Up:
                if (board.canMove(Direction.UP)) {
                    board.move(Direction.UP);
                    board.addRandomTile();
                }
                display(this.board);
                break;

            case R.id.Down:
                if (board.canMove(Direction.DOWN)) {
                    board.move(Direction.DOWN);
                    board.addRandomTile();
                }
                display(this.board);
                break;

            case R.id.Left:
                if (board.canMove(Direction.LEFT)) {
                    board.move(Direction.LEFT);
                    board.addRandomTile();
                }
                display(this.board);
                break;

            case R.id.Right:
                if (board.canMove(Direction.RIGHT)) {
                    board.move(Direction.RIGHT);
                    board.addRandomTile();
                }
                display(this.board);
                break;

            default:
                break;
        }

    }
}
