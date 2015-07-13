package jpb

public class TextScanner {

    //def input

    def getMostRepeatedChars(String input){

        def auxVal = input.toLowerCase()

        def int mostRepeatedCharCount
        def mostRepeatedChars = []
        def checkedChars = []

        auxVal.each {ch ->

            def currentCharCount = input.toLowerCase().count(ch)

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

        //if(mostRepeatedChars.size() == 1) return mostRepeatedChars

        return mostRepeatedChars
    }

}