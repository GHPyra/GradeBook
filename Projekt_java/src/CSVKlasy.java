
import Szkolna.Klasa;

import java.io.*;
import java.util.ArrayList;

public class CSVKlasy {

   public void tworz_plik(ArrayList<Klasa> klasy) {

      try(PrintWriter writer = new PrintWriter("klasy.csv");) {
         StringBuilder sb = new StringBuilder();
      for(int i = 0 ; i < klasy.size() ; i++){
         sb.append("K,"+klasy.get(i).getClass_name()+",");
         for(int j = 0 ; j < klasy.get(i).getPrzedmiots().size();j++){
            sb.append(klasy.get(i).getPrzedmiots().get(j).getName()+",");
         }
         sb.append('\n');
         for(int j = 0 ; j < klasy.get(i).getUczens().size() ; j++){
            sb.append("U,"+klasy.get(i).getUczens().get(j).getImie()+","+klasy.get(i).getUczens().get(j).getNazw()+",");
            sb.append('\n');
            for(int z = 0; z < klasy.get(i).getUczens().get(j).getPrzedmiots().size();z++){
               sb.append("P,"+z+",");
               for(int y = 0 ; y < klasy.get(i).getUczens().get(j).getPrzedmiot(z).getOcenas().size() ; y++){
                  sb.append(klasy.get(i).getUczens().get(j).getPrzedmiot(z).getOcenas().get(y).getWaga()+","+klasy.get(i).getUczens().get(j).getPrzedmiot(z).getOcenas().get(y).getOcn()+",");
               }
               sb.append('\n');
            }
         }
      }
      sb.append("EOF");
      writer.write(sb.toString());
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }

   public  ArrayList<Klasa> czytaj_plik(){
      ArrayList<Klasa> klasy;
      klasy = new ArrayList<Klasa>();

      String csvFile = "klasy.csv";
      BufferedReader br = null;
      String line = "";
      String cvsSplitBy = ",";
      try {

         br = new BufferedReader(new FileReader(csvFile));
         while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] str = line.split(cvsSplitBy);
            switch (str[0]){
               case "K":
                     klasy.add(new Klasa(klasy.size(),str[1]));
                     for(int i = 2; i < str.length; i++){
                        klasy.get(klasy.size()-1).dodaj_przedmiot(str[i],i);
                     }
                     break;
               case "U":
                  klasy.get(klasy.size()-1).dodaj_ucznia(str[1],str[2],klasy.get(klasy.size()-1).getUczens().size());
                  break;
               case "P":
                  int p_idx = Integer.parseInt(str[1]);
                  for(int i = 2 ; i < str.length; i=i+2){
                     klasy.get(klasy.size()-1).getUczens().get(klasy.get(klasy.size()-1).getUczens().size()-1).
                             getPrzedmiot(p_idx).dodaj_ocene(Integer.parseInt(str[i]),Integer.parseInt(str[i+1]));
                  }
            }


         }

      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if (br != null) {
            try {
               br.close();
               return klasy;
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
     return null;
   }

}
