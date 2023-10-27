import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

public class FrequencyAnalysisFunctions {
    static void ShowMenu(){//метод для вывода пользовательского интерфэйса
        InOut.print("Определить символы, которые:\n" +
                "1 входят и в первую и во вторую строку\n2 входят в первую и не входят во вторую\n" +
                "3 содержатся хотя бы в одной строке");
        String rezult=null;
        switch(InOut.GetIntFromUser("Введите номер варианта", 4,1)) {
            case 1: {
                rezult = FrequencyAnalysisFunctions.FindDuplicateWordAndSymbols
                        (InOut.getLineFromUser("Введите первую строку"),
                                InOut.getLineFromUser("Введите вторую строку"));
                break;
            }
            case 2: {
                rezult = FrequencyAnalysisFunctions.FindWordAndSymbolsOnlyInString1
                        (InOut.getLineFromUser("Введите первую строку"),
                                InOut.getLineFromUser("Введите вторую строку"));
                break;
            }
            case 3: {
                rezult = FrequencyAnalysisFunctions.FindWordAndSymbolsInAtLeast1Line
                        (InOut.getLineFromUser("Введите первую строку"),
                                InOut.getLineFromUser("Введите вторую строку"));
                break;
            }
        }
        if(rezult!=null) {
            System.out.println(rezult);
            FrequencyAnalysisFunctions.WriteTextToFile(rezult,InOut.getLineFromUser
                    ("Введите названия файла в который сохранить(без расширения)" +
                            "(Файл будет перезаписан!!!)"));
        }
        else InOut.print("Error");
    }

    static void WriteTextToFile(String StringToWrite, String FileName){//метод для записи строки в файл
        try {
            if(StringToWrite !=null){
                FileWriter writer = new FileWriter(FileName+".txt");
                writer.write(StringToWrite);
                writer.close();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    static String FindDuplicateWordAndSymbols(String _string1,String _string2){//метод для поиска одинаковых слов и
        // символов в 2 строках
        if(_string1==null| Objects.equals(_string1, "") |_string2==null| Objects.equals(_string2, ""))return null;
        StringСollection WordsOfString1 = new StringСollection(_string1.replaceAll("\\pP", " ")
                .replaceAll("[\\s]{2,}", " ").split(" "));
        Iterator<String> IteratorOfString1 = WordsOfString1.iterator();
        String rezultWords="";
        StringСollection WordsOfString2 = new StringСollection(_string2.replaceAll("\\pP", " ")
                .replaceAll("[\\s]{2,}", " ").split(" "));
        Iterator<String> IteratorOfString2 = WordsOfString2.iterator();
        while (IteratorOfString1.hasNext()) {
           String value = IteratorOfString1.next();
            IteratorOfString2 = WordsOfString2.iterator();
            while (IteratorOfString2.hasNext()){
                String value1=IteratorOfString2.next();
                if(value.equals(value1))
                    if(!rezultWords.contains(value))
                        rezultWords = rezultWords + value + " ";
            }
        }
        String rezultSymbols="";
        StringСollection Symbols = new StringСollection(_string2.split(""));
        Iterator<String> iteratorSymbols = Symbols.iterator();
        //words = _string2.split("");
        while (iteratorSymbols.hasNext()){
            String value = iteratorSymbols.next();
            if(_string1.contains(value))
                if(!rezultSymbols.contains(value))
                    rezultSymbols = rezultSymbols + value + " ";
        }
        if((rezultSymbols + rezultWords).isEmpty())return null;
        else return "Слова: "+rezultWords+"\nБуквы: "+rezultSymbols;
    }
    static String FindWordAndSymbolsOnlyInString1(String _string1,String _string2){//метод для поиска  слов
        // которые встречаются только в первой строке
        if(_string1==null|_string1==""|_string2==null|_string2=="")return null;
        StringСollection WordsOfString1 = new StringСollection(_string1.replaceAll("\\pP", " ")
                .replaceAll("[\\s]{2,}", " ").split(" "));
        Iterator<String> IteratorOfString1 = WordsOfString1.iterator();
        String rezultWords="";
        String tmps1=_string2.replaceAll("\\pP", " ").replaceAll("[\\s]{2,}", " ");
        while (IteratorOfString1.hasNext()) {
            String value = IteratorOfString1.next();
            if(!tmps1.contains(value))
                if(!rezultWords.contains(value))
                    rezultWords = rezultWords + value + " ";
        }
        String rezultSymbols="";
        StringСollection Symbols = new StringСollection(_string1.split(""));
        Iterator<String> iteratorSymbols = Symbols.iterator();
        while (iteratorSymbols.hasNext()){
            String value = iteratorSymbols.next();
            if(!_string2.contains(value))
                if(!rezultSymbols.contains(value))
                    rezultSymbols = rezultSymbols + value + " ";
        }
        if((rezultSymbols + rezultWords).isEmpty())return null;
        else return "Слова: "+rezultWords+"\nБуквы: "+rezultSymbols;
    }
    static String FindWordAndSymbolsInAtLeast1Line(String _string1,String _string2){//метод для поиска  слов
        // которые встречаются только в одной строке
        StringСollection WordsOfString1 = new StringСollection(_string1.replaceAll("\\pP", " ")
                .replaceAll("[\\s]{2,}", " ").split(" "));
        Iterator<String> IteratorOfString1 = WordsOfString1.iterator();
        String rezultWords="";
        while (IteratorOfString1.hasNext()) {
            String value = IteratorOfString1.next();
            rezultWords=rezultWords+value+" ";
        }
        StringСollection WordsOfString2 = new StringСollection(_string2.replaceAll("\\pP", " ")
                .replaceAll("[\\s]{2,}", " ").split(" "));
        Iterator<String> IteratorOfString2 = WordsOfString2.iterator();
        IteratorOfString1=WordsOfString1.iterator();
        StringСollection WordsOfRezult = new StringСollection(rezultWords.split(" "));
        Iterator<String> IteratorOfRezult = WordsOfRezult.iterator();
        while (IteratorOfString2.hasNext()) {
            String value = IteratorOfString2.next();
            boolean foundWord=false;
            while (IteratorOfString1.hasNext()){
                String value1 = IteratorOfString1.next();
                if(value.equals(value1)) {
                    foundWord=true;
                    break;
                }
            }
            if(!foundWord){
                boolean Found = false;
                while (IteratorOfRezult.hasNext()) {
                    String valueOfRezult = IteratorOfRezult.next();
                    if (valueOfRezult.equals(value)) {
                        Found = true;
                        break;
                    }
                }
                if(!Found) {
                    rezultWords = rezultWords + value + " ";
                    WordsOfRezult = new StringСollection(rezultWords.split(" "));
                    IteratorOfRezult = WordsOfRezult.iterator();
                }
            }
        }
        StringСollection Symbols1 = new StringСollection(_string1.split(""));
        Iterator<String> IteratorSymbols1 = Symbols1.iterator();
        String rezultSymbols="";
        while (IteratorSymbols1.hasNext()){
            String value=IteratorSymbols1.next();
            if (!rezultSymbols.contains(value)) rezultSymbols=rezultSymbols+value+" ";
        }
        StringСollection Symbols2 = new StringСollection(_string2.split(""));
        Iterator<String> IteratorSymbols2 = Symbols2.iterator();
        while (IteratorSymbols2.hasNext()){
            String value = IteratorSymbols2.next();
            if (!_string1.contains(value))
                if (!rezultSymbols.contains(value))
                    rezultSymbols = rezultSymbols + value + " ";
        }
        if((rezultSymbols + rezultWords).isEmpty())return null;
        else return (("Слова: "+rezultWords).replaceAll("[\\s]{2,}", " ")+"\nБуквы: "
                +rezultSymbols.replaceAll("[\\s]{2,}", " "));
    }
}
