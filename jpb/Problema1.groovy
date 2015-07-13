package jpb

public class Problema1{

	public static void main(String[] args){
		def scanner = new TextScanner()
		
		if(args){
			scanner.readInput(args[0])		
			def result = scanner.getMostRepeatedChars()
			
			if(result){
				if(result.size() > 1)
					println "Los caracteres mas repetidos son: " + result
				else
					println "El caracter mas repetido es: " + result
			}
		} else {
			println "Debe ingresar un texto para procesar"
		}		
	}
}