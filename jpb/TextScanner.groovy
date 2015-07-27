package jpb

import groovy.time.*

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

        def timeStart = new Date()

        def int mostRepeatedCharCount
        def mostRepeatedChars = []
        def checkedChars = []

        value.each { ch ->

            def lowerCh = ch.toLowerCase()

            def currentCharCount = value.count(lowerCh)
            
            if(!checkedChars.contains(lowerCh)){

                if(!mostRepeatedChars.isEmpty()){
                    if(currentCharCount > mostRepeatedCharCount){
                        mostRepeatedChars.clear()
                        mostRepeatedCharCount = currentCharCount
                        mostRepeatedChars.add(lowerCh)
                    } else if(currentCharCount == mostRepeatedCharCount){
                        mostRepeatedChars.add(lowerCh)
                    }
                } else {
                    mostRepeatedCharCount = currentCharCount
                    mostRepeatedChars.add(lowerCh)
                }

                checkedChars.add(lowerCh)
            }

        }

        def timeEnd
        TimeDuration td
        
        if(mostRepeatedCharCount == 1){
            timeEnd = new Date()
            td = TimeCategory.minus( timeEnd, timeStart )
            println td
            return null
        }

        timeEnd = new Date()
        
        td = TimeCategory.minus( timeEnd, timeStart )
        println td

        return mostRepeatedChars
    }

    /** 
    Devuelve un array con el/los caracter/es mas repetido/s del value. 
        Si no hay caracteres repetidos devuelve null
    */
    def getMostRepeatedChars(optimized){

        def timeStart = new Date()

        def checkedChars = []
        def repeatedCharsMap = new HashMap()

        value.each { ch ->
            def lowerCh = ch.toLowerCase()
            repeatedCharsMap.get(lowerCh) ? repeatedCharsMap.put(lowerCh, repeatedCharsMap.get(lowerCh) + 1) : repeatedCharsMap.put(loweChar, 1)
        }

        def int mostRepeatedCharCount
        def mostRepeatedChars = []
        repeatedCharsMap.each{ ch, count ->

            if(!mostRepeatedChars.isEmpty()){
                if(count > mostRepeatedCharCount){
                    mostRepeatedChars.clear()
                    mostRepeatedCharCount = count
                    mostRepeatedChars.add(ch)
                } else if(count == mostRepeatedCharCount){
                    mostRepeatedChars.add(ch)
                }
            } else {
                mostRepeatedCharCount = count
                mostRepeatedChars.add(ch)
            }
        }

        def timeEnd
        TimeDuration td
        
        if(mostRepeatedCharCount == 1){
            timeEnd = new Date()
            td = TimeCategory.minus( timeEnd, timeStart )
            println td
            return null
        }

        timeEnd = new Date()
        
        td = TimeCategory.minus( timeEnd, timeStart )
        println td

        return mostRepeatedChars
        
    } 

    /** 
    Devuelve un array con el/los tag/s mas repetido/s del value. 
        Si no hay caracteres repetidos devuelve null
    */
    def getMostRepeatedTags(){
        def lowerValue = new StringBuffer(value.toString().toLowerCase())
        println value
        def tagList = lowerValue.toString().replace(">","").tokenize("<")
        def repeatedTagsMap = new HashMap()

        for(tag in tagList){

            def trimTag = tag.trim()
            def emptySpaceIndex = trimTag.indexOf(" ")
            def tagName = trimTag.indexOf(" ") == -1 ? trimTag.replace("/","") : trimTag.substring(0, emptySpaceIndex)
            
            if(tag.contains("/")){        
                if(trimTag.indexOf("/") > 0){
                    repeatedTagsMap.get(tagName) ? repeatedTagsMap.put(tagName, repeatedTagsMap.get(tagName) + 1) : repeatedTagsMap.put(tagName, 1)
                }
            }
            else{
         repeatedTagsMap.get(tagName) ? repeatedTagsMap.put(tagName, repeatedTagsMap.get(tagName) + 1) : repeatedTagsMap.put(tagName, 1)
            }
        }

        def int mostRepeatedTagCount
        def mostRepeatedTags = []

        repeatedTagsMap.each{ tag, count ->
            if(!mostRepeatedTags.isEmpty()){
                if(count > mostRepeatedTagCount){
                    mostRepeatedTags.clear()
                    mostRepeatedTagCount = count
                    mostRepeatedTags.add(tag)
                } else if(count == mostRepeatedTagCount){
                    mostRepeatedTags.add(tag)
                }
            } else {
                mostRepeatedTagCount = count
                mostRepeatedTags.add(tag)
            }
        }
        
        if(mostRepeatedTagCount == 1){
            return null
        }
        println mostRepeatedTags
        return mostRepeatedTags
    }

}

