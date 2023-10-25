import java.util.ArrayList;

public class StringСollection {
    static ArrayList<String> StringArrayList = new ArrayList<>();
    static void add(String _string){
        StringArrayList.add(_string);
    }
    static String FindDuplicateWordAndSymbols(String _string1,String _string2){
        if(_string1==null|_string1==""|_string2==null|_string2=="")return null;
        String[] words = _string2.replaceAll("\\pP", " ").split(" ");
        String rezultWords="";
        String rezultSymbols="";
        String tmps1=_string1.replaceAll("\\pP", " ");
        for (String word : words) {
            if (tmps1.contains(word))
                if (!rezultWords.contains(word))
                    rezultWords = rezultWords + word + " ";
        }
        words = _string2.split("");
        for (String word : words) {
            if (_string1.contains(word))
                if (!rezultSymbols.contains(word))
                    rezultSymbols = rezultSymbols + word + " ";
        }
        if(rezultSymbols+rezultWords=="")return null;
        else return rezultWords+rezultSymbols;
    }
    static String FindWordAndSymbolsOnlyInString1(String _string1,String _string2){
        if(_string1==null|_string1==""|_string2==null|_string2=="")return null;
        String[] words = _string1.replaceAll("\\pP", " ").split(" ");
        String rezultWords="";
        String rezultSymbols="";
        String tmps1=_string2.replaceAll("\\pP", " ");
        for (int i =0; i< words.length;i++) {
            if (!tmps1.contains(words[i]))
                    rezultWords=rezultWords + words[i]+" ";
        }
        words = _string1.split("");
        for (int i =0; i< words.length;i++) {
            if (!_string2.contains(words[i]))
                if (!rezultSymbols.contains(words[i]))
                    rezultSymbols=rezultSymbols + words[i]+" ";
        }
        if(rezultSymbols+rezultWords=="")return null;
        else return rezultWords+rezultSymbols;
    }
    static String FindWordAndSymbolsInAtLeast1Line(String _string1,String _string2){
        if(_string1==null|_string1==""|_string2==null|_string2=="")return null;
        String[] words = _string1.replaceAll("\\pP", "").split(" ");
        String rezultWords="";
        for(String word : words)rezultWords=rezultWords+word+" ";
        String rezultSymbols="";
        String tmps1=_string1.replaceAll("\\pP", "");
        words = _string2.replaceAll("\\pP", "").split(" ");
        for (String word : words) {
            if (!tmps1.contains(word))
                if (!rezultWords.contains(word))
                    rezultWords = rezultWords + word + " ";
        }
        words = _string1.split("");
        for(String word : words)rezultSymbols=rezultSymbols+word+" ";
        words = _string2.split("");
        for (String word : words) {
            if (!_string1.contains(word))
                if (!rezultSymbols.contains(word))
                    rezultSymbols = rezultSymbols + word + " ";
        }
        if(rezultSymbols+rezultWords=="")return null;
        else return (rezultWords+rezultSymbols).replaceAll("[\\s]{2,}", " ");
    }
}
