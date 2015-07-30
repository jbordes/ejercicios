package jpb

public class Problema2_1{

	public static void main(String[] args){
		def scanner = new TextScanner()
		
		if(args && !args[0].isEmpty()){
			scanner.readInput(args[0])		
			def result = scanner.listTagsOrderedByRepetitions()
		} else {
			println "Debe ingresar un texto para procesar"
		}		
	}
}