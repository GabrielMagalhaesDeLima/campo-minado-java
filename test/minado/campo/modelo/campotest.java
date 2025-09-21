package minado.campo.modelo;

	import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

	import org.junit.jupiter.api.Test;

	public class campotest {


		 private Campo campo = new Campo(3, 3);
		 
		 @Test
		 void testeVizinhoRealDistancia1() {
			 Campo vizinho = new Campo (3, 4);
			 boolean resultado = campo.adcionarVizinho(vizinho);
			 assertTrue(resultado);
}
			 @Test
			 void testeVizinhoRealDistancia2() {
				 Campo vizinho = new Campo (2, 2);
				 boolean resultado = campo.adcionarVizinho(vizinho);
				 assertTrue(resultado);
}
			 @Test
			 void testeNaoVizinho() {
				 Campo vizinho = new Campo (1, 1);
				 boolean resultado = campo.adcionarVizinho(vizinho);
				 assertFalse(resultado);
			 }
}
