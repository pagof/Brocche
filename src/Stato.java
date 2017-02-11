
public class Stato {

	public int liv1;
	public int liv2;
	public int liv3;
	public boolean visitato;
	public int costo;
	public String soluzione = "";
	
	
	Stato(int l1,int l2, int l3, int costoI,String sol){
		liv1=l1;
		liv2=l2;
		liv3=l3;
		costo=costoI;
		if(liv1>12) liv1=12;
		if(liv1< 0) liv1= 0;
		if(liv2> 8) liv2= 8;
		if(liv2< 0) liv2= 0;
		if(liv3> 3) liv3= 3;
		if(liv3< 0) liv3= 0;
		stampa();
		soluzione=sol+">("+liv1+"."+liv2+"."+liv3+")";
		if(liv3< 0) liv3= 0;
		
	}

	public boolean isFinale() {
		if ((liv1+liv2+liv3)==1) return true;
		else return false;
	}
	public void stampa(){
		//System.out.println(liv1+"-"+liv2+"-"+liv3+"("+costo+")");
	}
}
