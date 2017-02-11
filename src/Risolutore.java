import java.util.Hashtable;


public class Risolutore {
	static int costoBest=12;
	static int contatore;
	static String solstar="";
	static Hashtable statiVisitati = new Hashtable();
	public static void main(String[] args){
		
		Stato statoIniziale =new Stato(0,0,0,0,"");
		statoIniziale.soluzione =">";
		esaminaStato(statoIniziale);
		System.out.println(costoBest);
		System.out.println(statiVisitati.size());
		System.out.println(solstar+ contatore);
	}
	public static void esaminaStato(Stato x){
		//x.stampa();
		contatore++;
		if (x.isFinale() ) {
			if (costoBest> x.costo) {
				//System.out.println(x.soluzione);
				costoBest=x.costo;
				System.out.println(x.soluzione);
				solstar=x.soluzione;
			}
			    return ;
		}
		if(x.costo >= costoBest) {
            //System.out.println("*+costoso di "+costoBest);
            return;}
		if (statiVisitati.containsKey(""+x.liv1+"-"+x.liv2+"-"+x.liv3)) {
			Stato y= (Stato)statiVisitati.get(""+x.liv1+"-"+x.liv2+"-"+x.liv3);
            
            if (x.costo >= y.costo) return;
            
            }
		else statiVisitati.put(""+x.liv1+"-"+x.liv2+"-"+x.liv3,x) ;
		
		//riempie
		if(x.liv1 <12) esaminaStato(new Stato(12,x.liv2,x.liv3,x.costo+1,x.soluzione));
		if(x.liv2 < 8) esaminaStato(new Stato(x.liv1,8,x.liv3,x.costo+1,x.soluzione));
		if(x.liv3 < 3) esaminaStato(new Stato(x.liv1,x.liv2,3,x.costo+1,x.soluzione));
		//svuota
		if(x.liv1 > 0) esaminaStato(new Stato(0,x.liv2,x.liv3,x.costo+1,x.soluzione));
		if(x.liv2 > 0) esaminaStato(new Stato(x.liv1,0,x.liv3,x.costo+1,x.soluzione));
		if(x.liv3 > 0) esaminaStato(new Stato(x.liv1,x.liv2,0,x.costo+1,x.soluzione));
		//versa da A a B
		if(x.liv1 > 0 && 
		   x.liv2 < 8) esaminaStato(new Stato(x.liv1-(8-x.liv2), (x.liv2+x.liv1),x.liv3,x.costo+1,x.soluzione));
		if(x.liv1 > 0 && 
		   x.liv3 < 3) esaminaStato(new Stato(x.liv1-(3-x.liv3), x.liv2,(x.liv3+x.liv1),x.costo+1,x.soluzione));
		if(x.liv2 > 0 && 
		   x.liv3 < 3) esaminaStato(new Stato(x.liv1,x.liv2-(3-x.liv3),(x.liv3+x.liv2),x.costo+1,x.soluzione));
		if(x.liv3 > 0 && 
		   x.liv2 < 8) esaminaStato(new Stato(x.liv1,x.liv2+x.liv3,(x.liv3-(8-x.liv2)),x.costo+1,x.soluzione));
		if(x.liv3 > 0 && 
		   x.liv1 < 12) esaminaStato(new Stato(x.liv1+x.liv3,x.liv2,  (x.liv3-(12-x.liv1)),x.costo+1,x.soluzione));
		if(x.liv2 > 0 && 
		   x.liv1 < 12) esaminaStato(new Stato(x.liv1+x.liv2,x.liv2-(12-x.liv1), x.liv3 ,x.costo+1,x.soluzione));
	}
}
