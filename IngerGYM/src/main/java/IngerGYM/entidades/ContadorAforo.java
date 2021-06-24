package IngerGYM.entidades;

public class ContadorAforo {

		private int aforo[]=new int[56];
		private int maxAforo;
		private int[] horario=new int[56];
		
		public ContadorAforo(Clases clase) {
			this.maxAforo=clase.getAf();
			for(int i=0;i<56;i++) {
				this.aforo[i]=0;
			}
		}
		
		public boolean hayHueco(int d,int h) {
			int numero=d*7+h;
			if(horario[numero]==1) return false;
			if(aforo[numero]<maxAforo) return true;
			else return false;
		}
		
		public void cogeAforo(int d,int h) {
			int n=d*7+h;
			aforo[n]++;
			if(aforo[n]==maxAforo)horario[n]=1;
		}
		
		public int getAforo(int d,int h) {
			int numero=d*7+h;
			return maxAforo-aforo[numero];
		}
}
