package com.tulasoft.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity{
    private TextView expr,result;
    private Button zero,one,two,three,four,five,six,seven,eight,nine, clear,openBrc,closeBrc,div,mul,minus,plus,dot,back,equals;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);
        this.setContentView(R.layout.calculator_layout);
        // id linking
        expr = (TextView) findViewById(R.id.expr);
        result = (TextView) findViewById(R.id.result);
        clear = (Button) findViewById(R.id.clear);
        openBrc = (Button) findViewById(R.id.openBrc);
        closeBrc = (Button) findViewById(R.id.closeBrc);
        div = (Button) findViewById(R.id.div);
        mul = (Button) findViewById(R.id.mul);
        minus = (Button) findViewById(R.id.minus);
        plus = (Button) findViewById(R.id.plus);
        dot = (Button) findViewById(R.id.dot);
        back = (Button) findViewById(R.id.back);
        equals = (Button) findViewById(R.id.equals);

        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);

        // Numbers
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("1",true);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("2",true);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("3",true);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("4",true);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("5",true);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("6",true);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("7",true);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("8",true);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("9",true);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("0",true);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr(".",true);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("+",false);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("-",false);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("*",false);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("/",false);
            }
        });
        openBrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("(",false);
            }
        });
        closeBrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr(")",false);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = expr.getText().toString();
                if(!string.isEmpty()){
                    expr.setText(string.substring(0,string.length()-1));
                }
                result.setText("");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText("");
                result.setText("");
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Expression expression = new ExpressionBuilder(expr.getText().toString()).build();
                    double reslt = expression.evaluate();
                    int intres = (int) reslt;
                    if (reslt == intres) {
                        result.setText(Integer.toString(intres));
                    } else {
                        result.setText(Double.toString(reslt));
                    }
                } catch (Exception e) {
                    result.setText("Không thể thực hiện phép tính");
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menucalc, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuhis:
//                Intent intent = new Intent(this, HistoryActivity.class);
//                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void appendOnExpr(String string , Boolean canClear){
        if(!result.getText().toString().isEmpty()){
            expr.setText("");
        }
        if(canClear){
            result.setText("");
            expr.append(string);
        }else{
            expr.append(result.getText());
            expr.append(string);
            result.setText("");
        }
    }
}
