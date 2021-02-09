package com.capacitacion.excepciones.procesos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import com.capacitacion.excepciones.personalizadas.ExcepcionesPersonalizadas;

public class ProcesarDatos {

	public int division(String numero1, String numero2) {
		int resultado = 0;
		try {

			resultado = Integer.valueOf(numero1) / Integer.valueOf(numero2);

		} catch (ArithmeticException ex) {

			System.out.println("error: " + ex.getStackTrace());
			System.out.println("error: " + ex.getCause());
			System.out.println("error: " + ex.getMessage());
		}

		catch (NumberFormatException ex) {

			System.out.println("error: " + ex.getStackTrace());
			System.out.println("error: " + ex.getCause());
			System.out.println("error: " + ex.getMessage());
		}

		finally {
			System.out.println("La División: " + numero1 + "/" + numero2 + " Es una excepción en java");
			System.out.println("El resultado es: " + resultado);

		}

		return resultado;

	}

	public void arreglo(String[] lista) {

		try {
			for (int i = 0; i <= 5; i++) {

				System.out.println(lista[i]);
			}

		} catch (ArrayIndexOutOfBoundsException ex) {

			System.out.println("error: " + ex.getStackTrace());
			System.out.println("error: " + ex.getCause());
			System.out.println("error: " + ex.getMessage());

		}

		finally {
			System.out.println("Se esperaba el numero de elementos totales para el vector");
		}

	}

	public void fecha(String input) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = format.parse(input);
			date.toString();
		} catch (ParseException e) {

			System.out.println("error: " + e.getStackTrace());
			System.out.println("error: " + e.getCause());
			System.out.println("error: " + e.getMessage());

		} finally {
			System.out.println("Formato de fecha icorrecto");
		}
	}

	public String buscarArchivo(String rutaarchivo) {
		String texto = "";
		try {
			File file = new File(rutaarchivo);
			if (!file.exists()) {
				System.out.println("Cuando archivo no existe");
				throw new ExcepcionesPersonalizadas("causa", "tipoFalla");
			}

			BufferedReader bf = new BufferedReader(new FileReader(rutaarchivo));
			String data = "";
			String info;

			while ((info = bf.readLine()) != null) {
				data = data + info;
				System.out.println(info + "\n");
			}

			texto = data;
			if (texto.equals("")) {
				System.out.println("Cuando archivo está vacío");
				throw new ExcepcionesPersonalizadas("causa", "tipoFalla");
			}
		}

		catch (ExcepcionesPersonalizadas e) {

			System.out.println(e.getCausa());
			System.out.println(e.getTipoFalla());

		} catch (IOException e) {

			System.out.println(e.getCause());

		} finally {
			System.out.println("Proceso ejecutado");
		}
		return texto;

	}

	public String leerCopiar(String origen, String destino) {

		try {

			System.out.println("Archivo Origen: " + origen);
			System.out.println("Archivo Destino: " + destino);

			FileReader entrada = new FileReader(origen);
			File salida = new File(destino);

			BufferedReader en = new BufferedReader(entrada);
			FileWriter fw = new FileWriter(salida);
			BufferedWriter sa = new BufferedWriter(fw);

			String info;

			while ((info = en.readLine()) != null) {

				String[] vectordatos = info.split(";");
				sa.append(vectordatos[0] + ";" + vectordatos[2] + "\n");

			}
			en.close();
			sa.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}

		finally {
			System.out.println("El proceso  terminó");
		}
		return destino;
	}

}
