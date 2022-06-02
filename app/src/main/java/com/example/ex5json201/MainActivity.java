package com.example.ex5json201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
 TextView txt_id,txt_nom,txt_ville,txt_noteFr,txt_noteMath,txt_phys,txt_hind,txt_naissance;
 Spinner sp1;
 ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_id=findViewById(R.id.txt_id);
        txt_nom=findViewById(R.id.txt_nom);
        txt_naissance=findViewById(R.id.txt_naissance);
        txt_ville=findViewById(R.id.txt_ville);
        txt_noteFr=findViewById(R.id.txt_noteFr);
        txt_noteMath=findViewById(R.id.txt_noteMath);
        txt_hind=findViewById(R.id.txt_noteHist);
        txt_phys=findViewById(R.id.txt_notePhys);
        sp1=findViewById(R.id.sp1);
        ls=findViewById(R.id.lst);

        ArrayList<Etudiant> etd1=getEtudiantFromJSON();
        ArrayList<HashMap<String,Object>> lst_etudion = new ArrayList<>();
         for(Etudiant  e: etd1){
              HashMap<String,Object> ithms= new HashMap<>();
             ithms.put("Ident",e.getIdent());
             ithms.put("nom",e.getNom());
            /* ithms.put("pville","ville "+e.getVille());
             ithms.put("pnaissance","naissance "+e.getNaissance());
             ithms.put("pfr","fr "+e.getNoteFr());
             ithms.put("pMth","mth "+e.getNoteMath());
             ithms.put("pPhys","phys "+e.getNotePhys());
             ithms.put("phist","hist "+e.getNoteHist());*/
             lst_etudion.add(ithms);

            }
         ArrayList<String> ar1=new ArrayList<>();
         ar1.add("zaid- bakkali ");
        ar1.add("abdo - hncjhncj");
        ar1.add("sajid-ghgre");
        ar1.add("mohhamed-hhfhhhsdr");
        ar1.add("asmai-hhfryu");

        String[] from ={"Ident","nom"};
      //   int[] t={R.id.}
        int[] to = { R.id.id2,R.id.nom2};

        SimpleAdapter ad = new SimpleAdapter(this,lst_etudion,R.layout.test,from,to);
        sp1.setAdapter(ad);
       ArrayAdapter ad2= new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,ar1);
       ls.setAdapter(ad2);

    }
    public String loadJSONFromRaw(int resId){

        InputStream in = getResources().openRawResource(resId);
        try {
            byte[] d= new  byte[in.available()];
            in.read(d);
            in.close();
            return new String(d);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public  ArrayList<Etudiant> getEtudiantFromJSON(){
       ArrayList<Etudiant> etd= new ArrayList<>();
        try {
            JSONArray arr=new JSONArray(loadJSONFromRaw(R.raw.etudiants));
            for(int i =0;i<arr.length();i++){
                Etudiant e=new Etudiant();
                JSONObject ob=arr.getJSONObject(i);
                e.setIdent(ob.getString( "ident"));
                e.setNom(ob.getString( "nom"));
                e.setVille(ob.getString( "ville"));
                e.setNaissance(ob.getString("naissance"));
                e.setNoteFr(ob.getJSONObject("resultat").getDouble( "fr"));
                e.setNoteHist(ob.getJSONObject("resultat").getDouble( "hist"));
                e.setNoteMath(ob.getJSONObject("resultat").getDouble( "math"));
                e.setNotePhys(ob.getJSONObject("resultat").getDouble( "phys"));
                etd.add(e);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  etd;

    }
}