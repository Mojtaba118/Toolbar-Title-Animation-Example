package ir.skydevelopers.toolbartitle;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean isAfterTitle =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar=findViewById(R.id.toolbar);
        NestedScrollView nestedScrollView=findViewById(R.id.nested);
        final AppCompatTextView title=findViewById(R.id.myTitle);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView nestedScrollView, int x, int y, int ox, int oy) {
                if (y>=(title.getY()+title.getHeight()/2)){
                    if (isAfterTitle){
                        toolbar.setTitle(title.getText().toString());
                        TranslateAnimation translateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,2,Animation.RELATIVE_TO_PARENT,0);
                        translateAnimation.setDuration(200);
                        for (int i = 0; i < toolbar.getChildCount(); i++) {
                            if (toolbar.getChildAt(i) instanceof TextView){
                                ((TextView)(toolbar.getChildAt(i))).startAnimation(translateAnimation);
                                break;
                            }
                        }
                        isAfterTitle =false;
                    }
                }else{
                    if (!isAfterTitle){
                        toolbar.setTitle(title.getText().toString());
                        TranslateAnimation translateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,2);
                        translateAnimation.setDuration(200);
                        translateAnimation.setFillAfter(true);
                        for (int i = 0; i < toolbar.getChildCount(); i++) {
                            if (toolbar.getChildAt(i) instanceof TextView){
                                ((TextView)(toolbar.getChildAt(i))).startAnimation(translateAnimation);
                                break;
                            }
                        }

                    }
                    isAfterTitle =true;
                }
            }
        });
    }
}
