package com.capacitacion.excepciones2;

import com.capacitacion.excepciones.personalizadas.ExcepcionesPersonalizadas;
import com.capacitacion.excepciones.procesos.ProcesarDatos;

public class ExcepcionesApplication {

	public static void main(String[] args) throws ExcepcionesPersonalizadas {

		caso1();
		caso2();
		caso3();
		caso4();
		caso5();

	}

	public static void caso1() {

		ProcesarDatos pd = new ProcesarDatos();
		pd.division("50", "0");
		ProcesarDatos pd1 = new ProcesarDatos();
		pd1.division("48.5", "30");

	}

	public static void caso2() {

		ProcesarDatos pda = new ProcesarDatos();
		String[] nombre = { "Juan", "Pedro", "Luis" };
		pda.arreglo(nombre);

	}

	public static void caso3() {

		ProcesarDatos pdf = new ProcesarDatos();
		pdf.fecha("2021/01/29");

	}

	public static void caso4() throws ExcepcionesPersonalizadas {
		String ruta = "C:/Users/1215419/eclipse-workspace/Taller_3_Modulo_2_Java/src/main/java/com/capacitacion/excepciones/datos/data.txt";
		ProcesarDatos pd = new ProcesarDatos();
		pd.buscarArchivo(ruta);
	}

	public static void caso5() {

		ProcesarDatos pd1 = new ProcesarDatos();
		String arorigen = "C:/Users/1215419/eclipse-workspace/Taller_3_Modulo_2_Java/src/main/java/com/capacitacion/excepciones/datos/data.txt";
		String ardestino = "C:/Users/1215419/eclipse-workspace/Taller_3_Modulo_2_Java/src/main/java/com/capacitacion/excepciones/datos/data2.txt";
		pd1.leerCopiar(arorigen, ardestino);

	}

}
