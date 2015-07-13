package jpb

public class Main{

	public static void main(String[] args){
		def scanner = new TextScanner()
		def input
		if(args){
			def file = new File(args[0])
			if(!file.exists())
				input = args[0]
			else input = file.getText()
		}
		def result = scanner.getMostRepeatedChars(input)
		if(result){
			if(result.size() > 1)
				println "Los caracteres mas repetidos son: " + result
			else
				println "El caracter mas repetido es: " + result
		}
		
	}
}