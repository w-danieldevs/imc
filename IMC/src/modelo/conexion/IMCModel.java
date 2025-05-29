package modelo.conexion;

public class IMCModel {

	    public static double calcular (double peso, double talla) {
	        return peso / (talla * talla);
	    }

	    public static String obtenerConclusion(double imc) {
	        if (imc < 18) return "Anorexia";
	        else if (imc < 20) return "Delgadez";
	        else if (imc < 27) return "Normalidad";
	        else if (imc < 30) return "Obesidad (grado 1)";
	        else if (imc < 35) return "Obesidad (grado 2)";
	        else if (imc < 40) return "Obesidad (grado 3)";
	        else return "Obesidad mórbida";
	    }
}