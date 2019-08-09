package br.univille.poo.programacaoestruturada.registro;

public class HoraMinutoUtil {
	

	public static void acrescentaMinutos(HoraMinuto h, int minutos) {
		h.minuto += minutos;
		
		while(h.minuto < 60 && h.minuto != 0) {
			h.minuto += 60;
			h.hora -= 1;
		}
		
		while(h.minuto > 60) {
			h.minuto -= 60;
			h.hora += 1;
		}
		
		if(h.hora > 23) {
			h.hora = 00;
		}
		
		if(h.hora == -1) {
			h.hora = 23;
		}
	}
	
	public static boolean isEquals(HoraMinuto h1, HoraMinuto h2) {
		if(h1.minuto == h2.minuto && h1.hora ==  h2.hora) {
			return true;
		}
		
		return false;
	}
}


//h.minuto += minutos; 
//
//if(h.minuto > 60) {
//	h.minuto = h.minuto - 60;
//	h.hora = h.hora + 1;
//}