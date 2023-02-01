import java.util.*;

public class Main {
    public static String functionToCalculationOnRoman(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        TreeMap<Integer, Character> map2 = new TreeMap<>(Comparator.reverseOrder());
        map2.put(100, 'C');
        map2.put(50, 'L');
        map2.put(10, 'X');
        map2.put(5, 'V');
        map2.put(1, 'I');
        int sum, a, b, Res;
        float res;
        String result = "";
        char sign;
        String str = "";
        String[] Str = {"","",""};
        try {
            int ind = 0;
            while (s.charAt(ind) == ' ') {
                ind++;
            }
            while (map.containsKey(s.charAt(ind))) {
                str = str.concat(String.valueOf(s.charAt(ind)));
                ind++;
            }
            sum = map.get(str.charAt(str.length() - 1));
            if (str.length() > 1) {
                for (int i = str.length() - 1; i > 0; i--) {
                    if (map.get(str.charAt(i)) > map.get(str.charAt(i - 1))) {
                        sum -= map.get(str.charAt(i - 1));
                    } else {
                        sum += map.get(str.charAt(i - 1));
                    }
                }
            }
            a = sum;
            str = "";
            while (s.charAt(ind) == ' ') {
                ind++;
            }
            sign = s.charAt(ind);
            ind++;
            while (s.charAt(ind) == ' ') {
                ind++;
            }
            while (ind < s.length()) {
                if (map.containsKey(s.charAt(ind))) {
                    str = str.concat(String.valueOf(s.charAt(ind)));
                    ind++;
                } else {
                    return (" Неверный ввод примера! ");
                }

            }
            sum = map.get(str.charAt(str.length() - 1));
            if (str.length() > 1) {
                for (int i = str.length() - 1; i > 0; i--) {
                    if (map.get(str.charAt(i)) > map.get(str.charAt(i - 1))) {
                        sum -= map.get(str.charAt(i - 1));
                    } else {
                        sum += map.get(str.charAt(i - 1));
                    }
                }
            }
            b = sum;
            if (a > 0 && a <= 10 && b > 0 && b <= 10) {
                if (sign == '+') {
                    Res = a + b;
                } else if (sign == '-') {
                    Res = a - b;
                } else if (sign == '*') {
                    Res = a * b;
                } else if (sign == '/') {
                    Res = a / b;
                } else
                    return (" Неверный ввод примера! ");
            } else
                return (" Неверный ввод примера! ");

            res = Res;
            for (int i = 10, j = 0; res > 0; i *= 10, j++) {
                while ((res % i) != 0) {
                    for (Map.Entry<Integer, Character> entry : map2.entrySet()) {
                        if ((res % i) / entry.getKey() == 0.9f) {
                            res -= entry.getKey() * 0.9;
                            Str[j] = Str[j].concat(String.valueOf(map2.get(entry.getKey() / 10)));
                            Str[j] = Str[j].concat(String.valueOf(map2.get(entry.getKey())));
                            break;
                        } else if ((res % i) / entry.getKey() == 0.8f && res % i != 8*i/10f) {
                            res -= entry.getKey() * 0.8;
                            Str[j] = Str[j].concat(String.valueOf(map2.get(entry.getKey() / 5)));
                            Str[j] = Str[j].concat(String.valueOf(map2.get(entry.getKey())));
                            break;
                        } else if ((res % i) / entry.getKey() >= 1) {
                            res -= entry.getKey();
                            Str[j] = Str[j].concat(String.valueOf(entry.getValue()));
                            break;
                        }
                    }
                }
            }
            for (int i = 2; i >= 0; i--) {
                result = result.concat(Str[i]);
            }
        }catch(StringIndexOutOfBoundsException e){
            return (" Неверный ввод примера! ");
        }
        return ("Ответ: " + result);
    }
    public static int functionToCalculation(String s) {
            try {
                String str = "";
                int i = 0;
                while (s.charAt(i) == ' ') {
                    i++;
                }
                str = str.concat(String.valueOf(s.charAt(i)));
                i++;
                if (s.charAt(i) == '0') {
                    str = str.concat(String.valueOf(s.charAt(i)));
                    i++;
                }
                int a = Integer.parseInt(str);
                while (s.charAt(i) == ' ') {
                    i++;
                }
                char sign = s.charAt(i);
                i++;
                while (s.charAt(i) == ' ') {
                    i++;
                }
                str = "";
                str = str.concat(String.valueOf(s.charAt(i)));
                i++;
                if (i < s.length())
                    str = str.concat(String.valueOf(s.charAt(i)));
                int b = Integer.parseInt(str);
                if (a > 0 && a <= 10 && b > 0 && b <= 10) {
                    if (sign == '+') {
                        return ((a + b));
                    } else if (sign == '-') {
                        return ((a - b));
                    } else if (sign == '*') {
                        return ((a * b));
                    } else if (sign == '/') {
                        return (a / b);
                    } else
                        return (404);
                } else
                    return (404);
            } catch (NumberFormatException | InputMismatchException | StringIndexOutOfBoundsException e) {
                return (404);
        }
    }

    public static String calc(String s) {
        int Result = functionToCalculation(s);
        if (Result != 404)
            return ("Ответ: " + Result);
        else {
            return (functionToCalculationOnRoman(s));
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(" Введите пример формата 'a + b', где а и b - только арабские или только римские числа от 1 до 10, \n использумыне римские числа: I, V, X \n используемые знаки арифметических операций: +, -, *, /: ");
        String s = scan.nextLine();
        System.out.println(calc(s));
    }
}