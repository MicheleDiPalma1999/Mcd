package mcd;

import java.util.Scanner;

public class Mcd {

    public static void main(String[] args) {
        
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    int m = 1;
    int n = 1; 
    System.out.print("Inserisci valore di m: ");
        try {
            m = assegnazione(scan.nextInt());
        } catch (ExceptionNoNum | EccezioneParametroNegativo e) {

            System.out.println("Tipo di errore: " + e.getMessage());
        }
        catch (Exception x){
            System.out.println("Inserire una stringa!");
        }

        System.out.print("Inserisci valore di n: ");
        try {
           n  = assegnazione(scan2.nextInt());
        } catch (ExceptionNoNum | EccezioneParametroNegativo e) {

            System.out.println("Tipo di errore: " + e.getMessage());
        }
             catch (Exception x){
            System.out.println("Inserire una stringa!");
        }
        
        
         System.out.println("Mcm: " + mcd(m,n));
        
        
    }
     public static int assegnazione(int N) throws ExceptionNoNum, EccezioneParametroNegativo
        {
            if (N < 0) {
                throw new EccezioneParametroNegativo("Argomento negativo\n");
            }
            if (N == 0) {
               throw new EccezioneParametroZero("Argomento pari a 0\n");

            }
 
            return N; 
        }
     
      public static int mcd(int m, int n) 
        {
              int risultato = 1;
   
         if (m > n) {
             int i = n; 
             do{         
                 if ((n%i ==0) && (m%i == 0)) {
                      if (i > risultato) {
                                    risultato = i;
                        }         
                 } 
                 else
                 i--;
               }while(i != risultato);
        }
        else  if (n > m) {
            int i = m;
               do {           
                        if ((n%i ==0) && (m%i == 0)) {
                                if (i > risultato) {
                                    risultato = i;
                                    }                          
                        }   
                        else
                        i--;
               }while (i != risultato);
        }
         else{
             risultato = m; 
         }      
         return risultato;
        }
    
}

 class EccezioneParametroZero extends Exception{
          
            public EccezioneParametroZero(String s){
                System.out.println(s);
                System.exit(404);
            }
            
            
        }

        class EccezioneParametroNegativo extends Exception{
             private String messaggioIniziale = "";
            
            public EccezioneParametroNegativo(String s){
                messaggioIniziale = s;
                System.out.println(s);
                System.exit(404);
            }
            
             @Override
            public String toString (){
                return "Il controllo dei parametri"
                + "\nha avuto esito negativo."
                + "\n" + messaggioIniziale; 
                
            }
            
        }