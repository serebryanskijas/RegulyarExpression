import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        // Знакомчтво со сравнением с шаблоном.
        Pattern p = Pattern.compile(".");
        Matcher m = p.matcher("a");
        boolean b = m.matches(); // в 3 строки
        System.out.println(b);
        boolean b2 = Pattern.compile(".").matcher( "as").matches(); // сравнение укороченнок
        System.out.println(b2);
        boolean b3 = Pattern.matches(".","a"); // сравнение оптимально короткое
        System.out.println(b3);
//Строка содержит один символ 'a'
        check("a","a","b");
//Строка содержит одну или более букву "a", а за ней одну букву "b"
        check("a+b","aaab","bbcc");
//Строка содержит несколько или ни одной буквы "a", а за ней одну букву "b"
        check("a*b","aaab","cb");
//Слово состоит из двух букв, первая из которых "a"
        check("a.","ab","cb");
//Строка начинается на букву "a"
        check("a.*","asdfsdfasdb","casfeb");
//Строка заканчивается на букву "a"
        check(".*a","asdfsdfasda","casfeb");
//Строка содержит "as"
        check(".*as.*","adfasdfadaas","cafeb");
//Строка не содержит "a"
        check("[^a]*","dfsdfds","cfaeb");
//Слово начинается на "a" или "A"
        check("[aA].*","afsdfds","cfAeb");
//Слово НЕ начинается на "a" или "A"
        check("[^aA].*","fsdfds","AcfAeb");
//В строке содержатся цифры
        check(".*\\d.*","fs1dfds","AcfAeb");
//Трехзначное целое число
        check("\\d{3}","123","AcfA546eb");
//Строка содержит только цифры
        check("[\\d]*","01235646","AcfA546eb"); //или [0-9]
//Строка является вещественным числом с фиксированной точкой
        check("[+-]?\\d+[.]?[,]?\\d*?","-2356465.3131","132,j");
//Содержит ни одного или более сочетаний "ab", а затем "c"
        check("(ab)*c","afsdfdc","cfAabc");
//Проверить написание номера телефона в формате +37533-111-11-11
        //check("[+]375[33,29,44]0-9{7}","+375292003472","132,j");
        check("[+]375 \\d{2} \\d{3}-\\d{2}-\\d{2}","+375 33 111-11-11","+375(33)111-11-11");


    }

    public static void check(String sPattern, String sTrue, String sFalse){

        boolean bTrue = Pattern.matches(sPattern,sTrue);
        boolean bFalse = Pattern.matches(sPattern,sFalse);
        System.out.println(bTrue + " " + bFalse);

    }
}
