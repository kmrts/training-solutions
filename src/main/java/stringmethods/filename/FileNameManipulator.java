package stringmethods.filename;

public class FileNameManipulator {

    public char findLastCharacter(String str){
        if (str == null || "".equals(str.trim())) {
            throw new IllegalArgumentException("Empty string!");
        }
        str = str.trim();
        return str.charAt(str.length()-1);
    }
    public String findFileExtension(String fileName){
        //
        if(fileName.indexOf('.')==-1){
            throw new IllegalArgumentException("Invalid file name!");
        }
        return fileName.substring(fileName.indexOf('.')+1);
    }
    public boolean identifyFilesByExtension(String ext, String fileName){
        if(fileName.indexOf('.')==-1){
            throw new IllegalArgumentException("Invalid file name!");
        }
        return ext.equals(fileName.substring(fileName.indexOf('.')+1));
    }
    public boolean compareFilesByName(String searchedFileName, String actualFileName){
        return searchedFileName.equals(actualFileName);
    }
    public String changeExtensionToLowerCase(String fileName){
        if(fileName.indexOf('.')==-1){
            throw new IllegalArgumentException("Invalid file name!");
        }
        return fileName.substring(0, fileName.indexOf('.')+1).concat(findFileExtension(fileName).toLowerCase());
    }
    public String replaceStringPart(String fileName, String present, String target){
        if(fileName.contains(present)){
            throw new IllegalArgumentException("Invalid argument!");
        }
        return fileName.replace(present, target);
    }



}
