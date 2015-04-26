package co.qualitysolutions.plasmaliquid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import co.qualitycolutions.plasmaliquid.R;
import co.qualitysolutions.utilities.SpinnerAdapter;


public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener,OnClickListener,OnItemSelectedListener {
    private TextView titleHeader1,txtWeight,txtWeightNumber,txtSexo,txtFemenino,txtMasculino,txtTreizt;
    private Typeface antipasto;
    private SeekBar seekBarWeight;
    private ImageButton imgFemenino,imgMasculino;
    private Drawable dImgFemenino,dImgFemeninoPress,dImgMasculino,dImgMasculinoPress;
    private boolean sexo;
    private Spinner spinnerPatologia;
    private Button btnDeficit,btnCalcular;
    private RelativeLayout layoutTrzert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeElements();
    }

    public void initializeElements(){

        this.antipasto = Typeface.createFromAsset(getAssets(), "fonts/AntipastoBold.ttf");

        this.btnDeficit = (Button) findViewById(R.id.btnDeficit);
        this.btnDeficit.setTypeface(this.antipasto);

        this.btnCalcular = (Button) findViewById(R.id.btnCalcular);
        this.btnCalcular.setTypeface(this.antipasto);

        this.seekBarWeight = (SeekBar) findViewById(R.id.seekBarWeight);
        this.seekBarWeight.setOnSeekBarChangeListener(this);

        this.titleHeader1=(TextView)findViewById(R.id.titleHeader1);
        this.titleHeader1.setTypeface(this.antipasto);

        this.txtWeight=(TextView)findViewById(R.id.txtWeight);
        this.txtWeight.setTypeface(this.antipasto);

        this.txtWeightNumber=(TextView)findViewById(R.id.txtWeightNumber);
        this.txtWeightNumber.setTypeface(this.antipasto);

        this.txtSexo=(TextView)findViewById(R.id.txtSexo);
        this.txtSexo.setTypeface(this.antipasto);

        this.txtTreizt=(TextView)findViewById(R.id.txtTreizt);
        this.txtTreizt.setTypeface(this.antipasto);

        this.txtFemenino=(TextView)findViewById(R.id.txtFemenino);
        this.txtFemenino.setOnClickListener(this);
        this.txtFemenino.setTypeface(this.antipasto);

        this.txtMasculino=(TextView)findViewById(R.id.txtMasculino);
        this.txtMasculino.setOnClickListener(this);
        this.txtMasculino.setTypeface(this.antipasto);

        this.imgFemenino = (ImageButton) findViewById(R.id.imgFemenino);
        this.imgFemenino.setOnClickListener(this);
        this.dImgFemenino = this.getResources().getDrawable(R.mipmap.femline);
        this.dImgFemeninoPress = this.getResources().getDrawable(R.mipmap.femwhite);

        this.imgMasculino = (ImageButton) findViewById(R.id.imgMasculino);
        this.imgMasculino.setOnClickListener(this);
        this.dImgMasculino = this.getResources().getDrawable(R.mipmap.masculinoline);
        this.dImgMasculinoPress = this.getResources().getDrawable(R.mipmap.masculinowhite);

        this.sexo=false;

        this.spinnerPatologia=(Spinner) findViewById(R.id.spinnerPatologia);
        this.spinnerPatologia.setOnItemSelectedListener(this);

        SpinnerAdapter adapter = new SpinnerAdapter(
                getApplicationContext(),
                R.layout.spinneritem,
                Arrays.asList(getResources().getStringArray(R.array.patologia))
        );
        this.spinnerPatologia.setAdapter(adapter);

        this.layoutTrzert=(RelativeLayout) findViewById(R.id.layoutTrzert);

        visibilityTreizt(this.spinnerPatologia.getSelectedItemPosition());



    }

    public void visibilityTreizt(int position){

        if(position==1){

            this.layoutTrzert.setVisibility(View.VISIBLE);

        }
        else{

            this.layoutTrzert.setVisibility(View.GONE);

        }

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        this.txtWeightNumber.setText(String.valueOf(progress)+"kg");

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {



    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.imgFemenino){

            if(this.sexo){

                this.imgFemenino.setBackground(this.dImgFemeninoPress);
                this.imgFemenino.setEnabled(false);

                this.txtFemenino.setTextColor(getResources().getColor(R.color.white));

                this.imgMasculino.setBackground(this.dImgMasculino);
                this.imgMasculino.setEnabled(true);

                this.txtMasculino.setTextColor(getResources().getColor(R.color.gray));

                this.sexo=false;

            }
        }

        else if(v.getId() == R.id.imgMasculino){

            if(!this.sexo){

                this.imgMasculino.setBackground(this.dImgMasculinoPress);
                this.imgMasculino.setEnabled(false);

                this.txtMasculino.setTextColor(getResources().getColor(R.color.white));

                this.imgFemenino.setBackground(this.dImgFemenino);
                this.imgFemenino.setEnabled(true);

                this.txtFemenino.setTextColor(getResources().getColor(R.color.gray));

                this.sexo=true;
            }


        }

        else if(v.getId() == R.id.txtFemenino){

            if(this.sexo){

                this.imgFemenino.setBackground(this.dImgFemeninoPress);
                this.imgFemenino.setEnabled(false);

                this.txtFemenino.setTextColor(getResources().getColor(R.color.white));

                this.imgMasculino.setBackground(this.dImgMasculino);
                this.imgMasculino.setEnabled(true);

                this.txtMasculino.setTextColor(getResources().getColor(R.color.gray));

                this.sexo=false;

            }

        }

        else if(v.getId() == R.id.txtMasculino){

            if(!this.sexo){

                this.imgMasculino.setBackground(this.dImgMasculinoPress);
                this.imgMasculino.setEnabled(false);

                this.txtMasculino.setTextColor(getResources().getColor(R.color.white));

                this.imgFemenino.setBackground(this.dImgFemenino);
                this.imgFemenino.setEnabled(true);

                this.txtFemenino.setTextColor(getResources().getColor(R.color.gray));

                this.sexo=true;
            }


        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        visibilityTreizt(position);
        //Toast.makeText(this,String.valueOf(position),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
