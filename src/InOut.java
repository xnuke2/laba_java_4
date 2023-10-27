import java.util.Scanner;

public class InOut {
    static Scanner in = new Scanner(System.in);//объект класса Scanner

    static int GetIntFromUser(String WhatToNeed, int max, int min){//метод для получения значения int от пользователя
        if (max<min)return 0;
        System.out.println(WhatToNeed);
        int num=0;
        while(num<=0){
            if(in.hasNextInt()){
                num = in.nextInt();
                if(num<min || num>=max){
                    System.out.println("Число некорректно");
                    in.next();
                }
            }else{
                System.out.println("Вводиться не целое число");
                in.next();
            }
        }
        return num;
    }
    static int GetIntFromUser(String WhatToNeed, int min){//перегрузка метода для получения значения int от пользователя
        return GetIntFromUser(WhatToNeed,2147483647,min);
    }
    static int GetIntFromUser(String WhatToNeed){//перегрузка метода для получения значения int от пользователя
        return GetIntFromUser(WhatToNeed,2147483647,-2147483647);
    }
    static String getLineFromUser(String WhatToNeed){//метод для получения значения string от пользователя
        System.out.println(WhatToNeed);
        String name="";
        while(name.isEmpty()){
            if(in.hasNextLine()){
                name = in.nextLine();
            }else{
                System.out.println("Ввод некорректен");
                in.next();
            }
        }
        return name;
    }
    static void print(String _string){//метод для вывода строки
        if(_string!=null) System.out.println(_string);
    }
}
