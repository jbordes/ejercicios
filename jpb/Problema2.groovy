package jpb

public class Problema2{

	public static void main(String[] args){
		def scanner = new TextScanner()
		
		if(args && !args[0].isEmpty()){
			scanner.readInput(args[0])		
			def result = scanner.getMostRepeatedTags()
			
			if(result){
				if(result.size() > 1)
					println "Los tags mas repetidos son: " + result
				else
					println "El tag mas repetido es: " + result
			} else {
				println "No hay tags repetidos"
			}
		} else {
			println "Debe ingresar un texto para procesar"
		}		
	}
}