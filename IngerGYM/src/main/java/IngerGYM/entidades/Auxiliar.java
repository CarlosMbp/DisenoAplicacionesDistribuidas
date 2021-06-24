package IngerGYM.entidades;

public class Auxiliar {
	private int[] reservas=new int[56];
	
	public Auxiliar() {
		
	}
	public void reservar(int reserva) {
		reservas[reserva]=1;
	}
	public void reservar() {
		for(int i=0;i<56;i++) {
			reservas[i]=1;	
		}
	}
	public boolean estaLibre(int reserva) {
		if(reservas[reserva]==0) {
			return true;
		}
		else return false;
	}
}
