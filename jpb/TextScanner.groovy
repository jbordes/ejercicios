package jpb

public class TextScanner {

    def value

    /**
    Lee input. Si es un file setea el texto del file en value, sino setea el valor de input
    */
    def readInput(String input){
        def file = new File(input)
        if(!file.exists())
            value = input
        else value = file.getText()
    }

    /** 
    Devuelve un array con el/los caracter/es mas repetido/s del value. 
        Si no hay caracteres repetidos devuelve null
    */
    def getMostRepeatedChars(){

        def auxVal = value?.toLowerCase()

        def int mostRepeatedCharCount
        def mostRepeatedChars = []
        def checkedChars = []

        auxVal.each { ch ->

            def currentCharCount = value?.toLowerCase().count(ch)
            
            if(!checkedChars.contains(ch)){

                if(!mostRepeatedChars.isEmpty()){
                    if(currentCharCount > mostRepeatedCharCount){
                        mostRepeatedChars.clear()
                        mostRepeatedCharCount = currentCharCount
                        mostRepeatedChars.add(ch)
                    } else if(currentCharCount == mostRepeatedCharCount){
                        mostRepeatedChars.add(ch)
                    }
                } else {
                    mostRepeatedCharCount = currentCharCount
                    mostRepeatedChars.add(ch)
                }

                checkedChars.add(ch)
            }

        }
        if(mostRepeatedCharCount == 1)
            return null

        return mostRepeatedChars
    }

}