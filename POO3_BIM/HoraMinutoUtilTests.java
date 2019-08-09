package br.univille.poo.programacaoestruturada.registro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HoraMinutoUtilTests {
	

	// TESTE 1 = 10:00 + 10M = 10:10
	// TESTE 2 = 10:55 + 10M = 11:05
	// TESTE 3 = 10:55 + 70M = 12:05
	// TESTE 4 = 23:55 + 10M = 00:05
	// TESTE 5 = 10:10 - 10M = 10:00
	// TESTE 6 = 9:05 - 00:10 = 8:05
	// TESTE 7 = 9:05 - 00:70 = 7:55
	// TESTE 8 = 00:05 - 00:10 = 23:55
	
	
	@Test
	public void acrescentaMinutos() {
		HoraMinuto h = new HoraMinuto();
		h.hora = 10;
		h.minuto = 0;
		HoraMinutoUtil.acrescentaMinutos(h, 10);
		assertEquals("Hora e minutos sao iguais",10,h.minuto);
	}
	
	@Test
	public void acrescentarMinutosEMudarHora() {
		HoraMinuto h = new HoraMinuto();
		h.hora = 10;
		h.minuto = 55;
		HoraMinutoUtil.acrescentaMinutos(h, 10);
		assertEquals("Minutos deve ser 5.",5,h.minuto);
		assertEquals("Hora deve ser 11",11,h.hora);
	}
	
	@Test
	public void acrescentarHoraEMinuto() {
		HoraMinuto h = new HoraMinuto();
		h.hora = 10;
		h.minuto = 55;
		HoraMinutoUtil.acrescentaMinutos(h, 70);
		System.out.println(h.hora);
		assertEquals("Minutos deve ser 5.",5,h.minuto);
		assertEquals("Hora deve ser 12",12,h.hora);
		
	}
	
	@Test
	public void mudarTudo() {
		HoraMinuto h = new HoraMinuto();
		h.hora = 23;
		h.minuto = 55;
		HoraMinutoUtil.acrescentaMinutos(h, 10);
		assertEquals("Minutos deve ser 5.",5,h.minuto);
		assertEquals("Hora deve ser 11",00,h.hora);
	}
	
	@Test
	public void subtrairMinutos() {
		HoraMinuto h = new HoraMinuto();
		h.hora = 10;
		h.minuto = 10;
		System.out.println("SUB 1");
		System.out.println("min " + h.minuto + " hora " +  h.hora);
		HoraMinutoUtil.acrescentaMinutos(h, -10);
		assertEquals("Minutos deve ser 5.",00,h.minuto);
		assertEquals("Hora deve ser 11",10,h.hora);
	}
	
	@Test
	public void subtrairMinutosEMudarHora() {
		HoraMinuto h = new HoraMinuto();
		h.hora = 9;
		h.minuto = 05;
		HoraMinutoUtil.acrescentaMinutos(h, -10);
		System.out.println("SUB 2");
		System.out.println("min " + h.minuto + " hora " +  h.hora);
		assertEquals("Minutos deve ser 5.",55,h.minuto);
		assertEquals("Hora deve ser 11",8,h.hora);
	}
	
	@Test
	public void subtrairMinutosMudarHoraTalvezSubtrairMinutos() {
		HoraMinuto h = new HoraMinuto();
		h.hora = 9;
		h.minuto = 05;
		HoraMinutoUtil.acrescentaMinutos(h, -70);
		System.out.println("SUB 3");
		System.out.println("min " + h.minuto + " hora " +  h.hora);
		assertEquals("Minutos deve ser 5.",55,h.minuto);
		assertEquals("Hora deve ser 11",7,h.hora);
	}
	@Test
	public void subtrairTudo() {
		HoraMinuto h = new HoraMinuto();
		h.hora = 00;
		h.minuto = 05;
		HoraMinutoUtil.acrescentaMinutos(h, -10);
		System.out.println("SUB 4");
		System.out.println("min " + h.minuto + " hora " +  h.hora);
		assertEquals("Minutos deve ser 5.",55,h.minuto);
		assertEquals("Hora deve ser 11",23,h.hora);
		
	}
	
	@Test
	public void testeEquals() {
		HoraMinuto h1 = new HoraMinuto();
		h1.hora = 01;
		h1.minuto = 00;
		HoraMinuto h2 = new HoraMinuto();
		h2.hora = 01;
		h2.minuto = 00;
		boolean isEquals = HoraMinutoUtil.isEquals(h1, h2);
		assertEquals("Deve ser verdadeiro.",true, isEquals);
	}
	
	@Test
	public void testeTheFalseEquals() {
		HoraMinuto h1 = new HoraMinuto();
		h1.hora = 01;
		h1.minuto = 00;
		HoraMinuto h2 = new HoraMinuto();
		h2.hora = 00;
		h2.minuto = 00;
		boolean isEquals = HoraMinutoUtil.isEquals(h1, h2);
		assertEquals("Deve ser falso.",false, isEquals);
	}
	
}