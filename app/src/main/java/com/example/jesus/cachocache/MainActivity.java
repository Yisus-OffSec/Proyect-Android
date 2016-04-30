package com.example.jesus.cachocache;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView TV,TV2;
    TextView boton,boton2;
    boolean primertiro = true;
    int juego=0;
    int n;
    int contador=0;

    int imagen[] = {R.drawable.dado,R.drawable.and_uno,R.drawable.and_dos, R.drawable.and_tres, R.drawable.and_cuatro,
            R.drawable.and_cinco, R.drawable.and_seis};
    int jugadorU[] = new int [11];
    int jugadorD[] = new int [11];
    int vec[] = new int[5];
    int vecD[] = new int[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV = (TextView) findViewById(R.id.my_text);   //definimos en ONCREATE donde esta por medio de un ID
        TV2 = (TextView) findViewById(R.id.my_text2);
        boton = (TextView) findViewById(R.id.lanzar);
        boton2 = (TextView) findViewById(R.id.siguiente);
        String font_path = "font/gloriahallelujah.ttf";  //definimos un STRING con el valor PATH ( o ruta pordonde tiene que buscar ) de nuetra fuente
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);
        //llamanos a la CLASS TYPEFACE y la definimos con un CREATE desde ASSETS con la ruta STRING
        TV.setTypeface(TF);   //finalmente aplicamos TYPEFACE al TEXTVIEW
        TV2.setTypeface(TF);
        boton.setTypeface(TF);
        boton2.setTypeface(TF);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.opciones,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.salir:
                Toast.makeText(this, "Estas Saliedo ", Toast.LENGTH_LONG).show();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void lanzar(View vista)
    {
            ImageView pimU = (ImageView) findViewById(R.id.imageView);
            ImageView pimD = (ImageView) findViewById(R.id.imageView2);
            ImageView pimT = (ImageView) findViewById(R.id.imageView3);
            ImageView pimC = (ImageView) findViewById(R.id.imageView4);
            ImageView pimCi = (ImageView) findViewById(R.id.imageView5);
            Button button = (Button) findViewById(R.id.lanzar);
            button.setEnabled(false);

            double dpimU = Math.random();
            int d1 = (int) (1 + (dpimU * 6));
            vec[0] = d1;
            pimU.setImageResource(imagen[(int) d1]);

            double dpimD = Math.random();
            int d2 = (int) (1 + (dpimD * 6));
            vec[1] = d2;
            pimD.setImageResource(imagen[(int) d2]);

            double dpimT = Math.random();
            int d3 = (int) (1 + (dpimT * 6));
            vec[2] = d3;
            pimT.setImageResource(imagen[(int) d3]);

            double dpimC = Math.random();
            int d4 = (int) (1 + (dpimC * 6));
            vec[3] = d4;
            pimC.setImageResource(imagen[(int) d4]);

            double dpimCi = Math.random();
            int d5 = (int) (1 + (dpimCi * 6));
            vec[4] = d5;
            pimCi.setImageResource(imagen[(int) d5]);

            n = (int) (d1 + d2 + d3 + d4 + d5);
            Toast.makeText(this, "La suma es " + n, Toast.LENGTH_LONG).show();
    }
    public void balas(View vista)
    {
        int suma=0;
        Button button = (Button) findViewById(R.id.balas);
        TextView B = (TextView)findViewById(R.id.textBalas);
        button.setEnabled(false);
        for (int i=0;i<vec.length;i++)
        {
            if(vec[i] == 1)
            {
                suma=suma+vec[i];
            }
        }
        jugadorU[0]=suma;
        B.setText(suma+"");
    }
    public void tontos(View vista)
    {
        int suma=0;
        Button button = (Button) findViewById(R.id.tontos);
        TextView B = (TextView)findViewById(R.id.textTontos);
        button.setEnabled(false);
        for (int i=0;i<vec.length;i++)
        {
            if(vec[i] == 2)
            {
                suma=suma+vec[i];
            }
        }
        jugadorU[1]=suma;
        B.setText(suma+"");
    }
    public void trenes(View vista)
    {
        int suma=0;
        Button button = (Button) findViewById(R.id.trenes);
        TextView B = (TextView)findViewById(R.id.textTrenes);
        button.setEnabled(false);
        for (int i=0;i<vec.length;i++)
        {
            if(vec[i] == 3)
            {
                suma=suma+vec[i];
            }
        }
        jugadorU[2]=suma;
        B.setText(suma + "");

    }
    public void escalera(View vista)
    {   /*craneaar*/
        int suma=0;
        Button button = (Button) findViewById(R.id.escalera);
        TextView B = (TextView)findViewById(R.id.textEscalera);
        button.setEnabled(false);
        if(vec[0]==1 && vec[1]==2 && vec[2]==3 && vec[3]==4 && vec[4]==5)
        {
            suma=25;
        }
        else if(vec[0]==2 && vec[1]==3 && vec[2]==4 && vec[3]==5 && vec[4]==6)
        {
            suma=25;
        }
        else if(vec[0]==3 && vec[1]==4 && vec[2]==5 && vec[3]==6 && vec[4]==1)
        {
            suma=25;
        }
        else {
            suma=0;
        }
        jugadorU[3]=suma;
        B.setText(suma+"");
    }
    public void full(View vista)
    {
        int suma=0;
        Button button = (Button) findViewById(R.id.full);
        TextView B = (TextView)findViewById(R.id.textFull);
        button.setEnabled(false);
        if(vec[0]==vec[1] && vec[2]==vec[3]&& vec[3]==vec[4])
        {
            suma=35;
        }
        else if(vec[1]==vec[2] && vec[0]==vec[3]&& vec[3]==vec[4])
        {
            suma=35;
        }
        else if(vec[2]==vec[3] && vec[1]==vec[0]&& vec[0]==vec[4])
        {
            suma=35;
        }
        else if(vec[3]==vec[4] && vec[2]==vec[1]&& vec[1]==vec[0])
        {
            suma=35;
        }
        else if(vec[0]==vec[4] && vec[2]==vec[3]&& vec[3]==vec[1])
        {
            suma=35;
        }
        else if(vec[1]==vec[3] && vec[2]==vec[0]&& vec[0]==vec[4])
        {
            suma=35;
        }
        else if(vec[2]==vec[0] && vec[1]==vec[3]&& vec[3]==vec[4])
        {
            suma=35;
        }
        else if(vec[2]==vec[4] && vec[1]==vec[3]&& vec[3]==vec[0])
        {
            suma=35;
        }
        else if(vec[0]==vec[3] && vec[2]==vec[1]&& vec[1]==vec[1])
        {
            suma=35;
        }
        else if(vec[1]==vec[4] && vec[2]==vec[3]&& vec[3]==vec[0])
        {
            suma=35;
        }
        else {
            suma=0;
        }
        jugadorU[4]=suma;
        B.setText(suma+"");
    }
    public void poker(View vista)
    {
        int suma=0;
        Button button = (Button) findViewById(R.id.poker);
        TextView B = (TextView)findViewById(R.id.textPoker);
        button.setEnabled(false);
        if(vec[0]==vec[1] && vec[1]== vec[2] && vec[2]==vec[3])
        {
            suma=45;
        }
        else if(vec[1]==vec[2] && vec[2]== vec[3] && vec[3]==vec[4])
        {
            suma=45;
        }
        else if(vec[2]==vec[3] && vec[3]== vec[4] && vec[4]==vec[0])
        {
            suma=45;
        }
        else if(vec[0]==vec[1] && vec[1]== vec[3] && vec[3]==vec[4])
        {
            suma=45;
        }
        else if(vec[0]==vec[1] && vec[1]== vec[2] && vec[2]==vec[4])
        {
            suma=45;
        }
        else
        {
            suma=0;
        }
        jugadorU[5]=suma;
        B.setText(suma + "");

    }
    public void cuadras(View vista)
    {
        int suma=0;
        Button button = (Button) findViewById(R.id.cuadras);
        TextView B = (TextView)findViewById(R.id.textCuadra);
        button.setEnabled(false);
        for (int i=0;i<vec.length;i++)
        {
            if(vec[i] == 4)
            {
                suma=suma+vec[i];
            }
        }
        jugadorU[6]=suma;
        B.setText(suma + "");
    }
    public void quinas(View vista)
    {
        int suma=0;
        Button button = (Button) findViewById(R.id.quinas);
        TextView B = (TextView)findViewById(R.id.textQuinas);
        button.setEnabled(false);
        for (int i=0;i<vec.length;i++)
        {
            if(vec[i] == 5)
            {
                suma=suma+vec[i];
            }
        }
        jugadorU[7]=suma;
        B.setText(suma + "");
    }
    public void senas(View vista)
    {
        int suma=0;
        Button button = (Button) findViewById(R.id.senas);
        TextView B = (TextView)findViewById(R.id.textSenas);
        button.setEnabled(false);
        for (int i=0;i<vec.length;i++)
        {
            if(vec[i] == 6)
            {
                suma=suma+vec[i];
            }
        }
        jugadorU[8]=suma;
        B.setText(suma + "");
    }
    public void grandeU(View vista)
    {
        int suma=0;
        Button button = (Button) findViewById(R.id.grandeU);
        TextView B = (TextView)findViewById(R.id.textGrandeU);
        button.setEnabled(false);
        if(vec[1]==vec[0] && vec[2]==vec[3] && vec[4]==vec[0] && vec[3]==vec[4] && vec[0]==vec[2])
        {
            suma=50;
        }
        jugadorU[9]=suma;
        B.setText(suma + "");
    }
    public void grandeD(View vista)
    {
        int suma=0;
        Button button = (Button) findViewById(R.id.grandeD);
        TextView B = (TextView)findViewById(R.id.textGrandD);
        button.setEnabled(false);
        if(vec[1]==vec[0] && vec[2]==vec[3] && vec[4]==vec[0] && vec[3]==vec[4] && vec[0]==vec[2])
        {
            suma=50;
        }
        jugadorU[10] = suma;
        B.setText(suma + "");
    }

    public void siguiente(View vista)
    {
        RelativeLayout layone= (RelativeLayout)findViewById(R.id.relativeLayout);
        layone.setVisibility(View.GONE);
        Button button = (Button)findViewById(R.id.lanzar);
        button.setEnabled(true);

    }
    public void siguienteDos(View vista)
    {
        contador++;
        int suma=0,sumdos=0;
        RelativeLayout layone= (RelativeLayout)findViewById(R.id.relativeLayout);
        layone.setVisibility(View.VISIBLE);
        Button button = (Button)findViewById(R.id.lanzar2);
        button.setEnabled(true);
        if(contador==11)
        {
            for (int i=0;i<jugadorU.length;i++)
            {
                suma=jugadorU[i]+suma;
            }
            for (int i=0;i<jugadorD.length;i++)
            {
                sumdos=sumdos+jugadorD[i];
            }
            if(suma>sumdos)
            {
                Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Perdiste", Toast.LENGTH_SHORT).show();
            }
            Button sg= (Button)findViewById(R.id.siguiente);
            sg.setEnabled(false);
            Toast.makeText(this, "TERMINO EL JUEGO", Toast.LENGTH_LONG).show();
        }
    }
    public void lanzarDos(View vista)
    {
        ImageView pimU =(ImageView)findViewById(R.id.imageViewD2);
        ImageView pimD =(ImageView)findViewById(R.id.imageView2D2);
        ImageView pimT =(ImageView)findViewById(R.id.imageView3D2);
        ImageView pimC =(ImageView)findViewById(R.id.imageView4D2);
        ImageView pimCi =(ImageView)findViewById(R.id.imageView5D2);

        Button button = (Button)findViewById(R.id.lanzar2);
        button.setEnabled(false);

        double dpimU = Math.random();
        int d1 = (int) (1 + (dpimU*6));
        vecD[0]=d1;
        pimU.setImageResource(imagen[(int) d1]);

        double dpimD = Math.random();
        int d2 = (int) (1 + (dpimD*6));
        vecD[1]=d2;
        pimD.setImageResource(imagen[(int) d2]);

        double dpimT = Math.random();
        int d3 = (int) (1 + (dpimT*6));
        vecD[2]=d3;
        pimT.setImageResource(imagen[(int) d3]);

        double dpimC = Math.random();
        int d4 = (int) (1 + (dpimC*6));
        vecD[3]=d4;
        pimC.setImageResource(imagen[(int) d4]);

        double dpimCi = Math.random();
        int d5 = (int) (1 + (dpimCi * 6));
        vecD[4]=d5;
        pimCi.setImageResource(imagen[(int) d5]);

        n = (int) (d1+d2+d3+d4+d5);

        if(vecD[0]== vecD[1] && vecD[1]==vecD[2] && vecD[2]==vecD[3] && vecD[3]==vecD[4])
        {
            int suma=0;
            TextView B = (TextView)findViewById(R.id.textGrandeUD2);
            suma =50;
            B.setText(suma+"");
            jugadorD[9]=suma;
        }
        if(vecD[0]== vecD[1] && vecD[1]==vecD[2] && vecD[2]==vecD[3] && vecD[3]==vecD[4])
        {
            int suma=0;
            TextView B = (TextView)findViewById(R.id.textGrandDD2);
            suma =50;
            B.setText(suma+"");
            jugadorD[10]=suma;
        }
        else if(vecD[0]==vecD[1] && vecD[2]==vecD[3]&& vecD[3]==vecD[4])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textFullD2);
            suma = 35;
            B.setText(suma+"");
            jugadorD[4]=suma;
        }
        else if(vecD[1]==vecD[2] && vecD[0]==vecD[3]&& vecD[3]==vecD[4])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textFullD2);
            suma = 35;
            B.setText(suma+"");
            jugadorD[4]=suma;
        }
        else if(vecD[2]==vecD[3] && vecD[1]==vecD[0]&& vecD[0]==vecD[4])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textFullD2);
            suma = 35;
            B.setText(suma+"");
            jugadorD[4]=suma;
        }
        else if(vecD[3]==vecD[4] && vecD[2]==vecD[1]&& vecD[1]==vecD[0])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textFullD2);
            suma = 35;
            B.setText(suma+"");
            jugadorD[4]=suma;
        }
        else if(vecD[0]==vecD[4] && vecD[2]==vecD[3]&& vecD[3]==vecD[1])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textFullD2);
            suma = 35;
            B.setText(suma+"");
            jugadorD[4]=suma;
        }
        else if(vecD[1]==vecD[3] && vecD[2]==vecD[0]&& vecD[0]==vecD[4])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textFullD2);
            suma = 35;
            B.setText(suma+"");
            jugadorD[4]=suma;
        }
        else if(vecD[2]==vecD[0] && vecD[1]==vecD[3]&& vecD[3]==vecD[4])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textFullD2);
            suma = 35;
            B.setText(suma+"");
            jugadorD[4]=suma;
        }
        else if(vecD[2]==vecD[4] && vecD[1]==vecD[3]&& vecD[3]==vecD[0])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textFullD2);
            suma = 35;
            B.setText(suma+"");
            jugadorD[4]=suma;
        }
        else if(vecD[0]==vecD[3] && vecD[2]==vecD[1]&& vecD[1]==vecD[1])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textFullD2);
            suma = 35;
            B.setText(suma+"");
            jugadorD[4]=suma;
        }
        else if(vecD[1]==vecD[4] && vecD[2]==vecD[3]&& vecD[3]==vecD[0])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textFullD2);
            suma = 35;
            B.setText(suma+"");
            jugadorD[4]=suma;
        }
        /*  Poker */
        else if(vecD[0]==vecD[1] && vecD[1]== vecD[2] && vecD[2]==vecD[3])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textPokerD2);
            suma=45;
            B.setText(suma+"");
            jugadorD[5]=suma;
        }
        else if(vecD[1]==vecD[2] && vecD[2]== vecD[3] && vecD[3]==vecD[4])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textPokerD2);
            suma=45;
            B.setText(suma+"");
            jugadorD[5]=suma;
        }
        else if(vecD[2]==vecD[3] && vecD[3]== vecD[4] && vecD[4]==vecD[0])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textPokerD2);
            suma=45;
            B.setText(suma+"");
            jugadorD[5]=suma;
        }
        else if(vecD[0]==vecD[1] && vecD[1]== vecD[3] && vecD[3]==vecD[4])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textPokerD2);
            suma=45;
            B.setText(suma+"");
            jugadorD[5]=suma;
        }
        else if(vecD[0]==vecD[1] && vecD[1]== vecD[2] && vecD[2]==vecD[4])
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textPokerD2);
            suma=45;
            B.setText(suma+"");
            jugadorD[5]=suma;
        }
        /*  Escalera    */
        if(vecD[0]==1 && vecD[1]==2 && vecD[2]==3 && vecD[3]==4 && vecD[4]==5)
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textEscaleraD2);
            suma=25;
            B.getText();
            jugadorD[3]=suma;
        }
        else if(vecD[0]==2 && vecD[1]==3 && vecD[2]==4 && vecD[3]==5 && vecD[4]==6)
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textEscaleraD2);
            suma=25;
            B.getText();
            jugadorD[3]=suma;
        }
        else if(vecD[0]==3 && vecD[1]==4 && vecD[2]==5 && vecD[3]==6 && vecD[4]==1)
        {
            int suma = 0;
            TextView B = (TextView)findViewById(R.id.textEscaleraD2);
            suma=25;
            B.getText();
            jugadorD[3]=suma;
        }
        /***************************************************************/
        /*
        //Para uno
        int Tuno=0,Tdos=0,Ttres=0,Tcuatro=0,Tcinco=0,Tseis=0;
        int vecselec[] = new int [6];
        for(int i=0;i<vecD.length;i++)
        {
            if(vecD[i]==1)
            {
                Tuno=vecD[i]+Tuno;
            }
            else if(vecD[i]==2)
            {
                Tdos=vecD[i]+Tdos;
            }
            else if(vecD[i]==3)
            {
                Ttres=vecD[i]+Ttres;
            }
            else if(vecD[i]==4)
            {
                Tcuatro=vecD[i]+Tcuatro;
            }
            else if(vecD[i]==5)
            {
                Tcinco=vecD[i]+Tcinco;
            }
            else if(vecD[i]==6)
            {
                Tseis=vecD[i]+Tseis;
            }
        }
        vecselec[0]=Tuno;
        vecselec[1]=Tdos;
        vecselec[2]=Ttres;
        vecselec[3]=Tcuatro;
        vecselec[4]=Tcinco;
        vecselec[5]=Tseis;
        int mayor=0;
        int pos=0;
        for(int i=0;i<vecselec.length;i++)
        {
            if(vecselec[i]>mayor)
            {
                mayor=vecselec[i];
                pos=i;
            }
        }
        switch (pos)
        {
            case 0:
                if (jugadorD[0]==0){
                    TextView B = (TextView)findViewById(R.id.textBalasD2);
                    B.setText(mayor+"");
                }
                break;
            case 1:
                if (jugadorD[1]==0){
                    TextView B = (TextView)findViewById(R.id.textTontosD2);
                    B.setText(mayor+"");
                }
                break;
            case 2:
                if (jugadorD[2]==0){
                    TextView B = (TextView)findViewById(R.id.textTrenesD2);
                    B.setText(mayor+"");
                }
                break;
            case 3:
                if (jugadorD[6]==0){
                    TextView B = (TextView)findViewById(R.id.textCuadraD2);
                    B.setText(mayor+"");
                }
                break;
            case 4:
                if (jugadorD[7]==0){
                    TextView B = (TextView)findViewById(R.id.textQuinasD2);
                    B.setText(mayor+"");
                }
                break;
            case 5:
                if (jugadorD[8]==0){
                    TextView B = (TextView)findViewById(R.id.textSenasD2);
                    B.setText(mayor+"");
                }
                break;
        }
        Toast.makeText(this, "el mayor es "+mayor, Toast.LENGTH_LONG).show(); */

        int bls=0,tre=0,tnt=0,cua=0,qui=0,sen=0;

        int cont=0;
        int com[] = new int[5];
        for(int i=0;i<vecD.length;i++)
        {
            cont=0;
            for(int j=0;j<vecD.length;j++)
            {
                if(vecD[i] == vecD[j])
                {
                    cont++;
                }
            }
            com[i]=cont;
        }
        int my=0;
        int nu=0;
        for(int i=0;i<com.length;i++)
        {
            if(com[i] > my )
            {
                my=com[i];
                nu=vecD[i];
            }
        }
        int su=0;
        for(int i=0;i<vecD.length;i++)
        {
            if(nu==vecD[i])
            {
                su=vecD[i]+su;
            }
        }
        if(nu==1)
        {
            TextView B = (TextView) findViewById(R.id.textBalasD2);
            B.setText(su+"");
            jugadorD[0]=su;
        }
        if (nu == 2)
        {
            TextView T = (TextView)findViewById(R.id.textTontosD2);
            T.setText(su+"");
            jugadorD[1]=su;
        }
        if (nu ==3)
        {
            TextView Tr = (TextView)findViewById(R.id.textTrenesD2);
            Tr.setText(su+"");
            jugadorD[2]=su;
        }
        if (nu == 4)
        {
            TextView C = (TextView)findViewById(R.id.textCuadraD2);
            C.setText(su+"");
            jugadorD[6]=su;

        }
        if(nu==5)
        {
            TextView Q = (TextView)findViewById(R.id.textQuinasD2);
            Q.setText(su+"");
            jugadorD[7]=su;
        }
        if(nu==6)
        {
            TextView S = (TextView)findViewById(R.id.textSenasD2);
            S.setText(su+"");
            jugadorD[8]=su;
        }

    }
}
