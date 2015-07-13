package jpb

public class TextScanner {

    def value

    def readInput(String input){
        def file = new File(input)
        if(!file.exists())
            value = input
        else value = file.getText()
    }

    def getMostRepeatedChars(){

        def auxVal = value?.toLowerCase()

        def int mostRepeatedCharCount
        def mostRepeatedChars = []
        def checkedChars = []

        auxVal.each {ch ->

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

        return mostRepeatedChars
    }

}