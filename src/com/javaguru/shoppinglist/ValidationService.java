package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ValidationService {

    private BigDecimal minPrice = new BigDecimal(0.01).setScale(2, BigDecimal.ROUND_DOWN);      //минимальная цена товара

    private void spacesCountValidation(String name) {                                                       //метод проверяющий название на количество пробелов
        char[] charArray = name.toCharArray();                                                              //преобразование строки в массив символов
        int spacesCount = 0;                                                                                //количество пробелов

        for (char character : charArray) {                                                                  //цикл для прохода по всем ячейкам массива
            if (character == ' ') {                                                                         //если символ является пробелом
                spacesCount++;                                                                              //увеличить количество пробелов на 1
            }
            if (spacesCount > 3) {                                                                          //если количество пробелов больше заданого максимума
                throw new ValidationException("Error! Name contains too much spaces.");                     //выбросить исключение
            }
        }
    }

    private void correctUseOfSpacesValidation(String name) {                                                //метод проверяющий не идут ли пробелы подряд
        char[] charArray = name.toCharArray();                                                              //преобразование строки в массив символов
        boolean previousSpace = false;                                                                      //предыдущий символ пробел

        for (char character : charArray) {                                                                  //цикл для прохода по всем ячейкам массива
            if ((character == ' ') && (previousSpace)) {                                                    //если символ пробел и предыдущий символ был пробелом
                throw new ValidationException("Error! Spaces in the name go one by one");                   //выбросить исключение
            } else {                                                                                        //иначе
                previousSpace = character == ' ';                                                           //предыдущий символ получает значение от логического выражения
            }
        }
    }

    private void useOfInvalidCharactersValidation(String name) {                                            //метод проверяющий название на запрещённые символы
        char[] charArray = name.toCharArray();                                                              //преобразование строки в массив символов

        for (char character : charArray) {                                                                  //цикл для прохода по всем ячейкам массива
            if (character > 32 && character < 48) {                                                         //если номер символа соответствует запрещённому
                throw new ValidationException("Error! Name contains invalid characters");                   //выбросить исключение
            }
            if (character > 57 && character < 65) {                                                         //если номер символа соответствует запрещённому
                throw new ValidationException("Error! Name contains invalid characters");                   //выбросить исключение
            }
            if (character > 90 && character < 97) {                                                         //если номер символа соответствует запрещённому
                throw new ValidationException("Error! Name contains invalid characters");                   //выбросить исключение
            }
            if (character > 122) {                                                                          //если номер символа соответствует запрещённому
                throw new ValidationException("Error! Name contains invalid characters");                   //выбросить исключение
            }
        }
    }

    public void validateName(String name) {                                                                 //проверка названия
        if (name.isEmpty()) {                                                                               //если название пустое
            throw new ValidationException("Error! There is no name.");                                      //выбросить исключение
        }
        if (name.length() < 3) {                                                                            //если длинна названия меньше минимальной
            throw new ValidationException("Error! Name is too short.");                                     //выбросить исключение
        }
        if (name.length() > 30) {                                                                           //если длинна названия больше максимальной
            throw new ValidationException("Error! Name is too long.");                                      //выбросить исключение
        }
        if (name.startsWith(" ")) {                                                                         //если название начинается с пробела
            throw new ValidationException("Error! Name starts with a space.");                              //выбросить исключение
        }
        if (name.endsWith(" ")) {                                                                           //если название заканчивается пробелом
            throw new ValidationException("Error! Name ends with a space.");                                //выбросить исключение
        }
        spacesCountValidation(name);                                                                        //проверка на количество пробелов в название
        correctUseOfSpacesValidation(name);                                                                 //проверка на идущие подряд пробелы в название
        useOfInvalidCharactersValidation(name);                                                             //проверка на запрещённые символы в название
    }

    public void validatePrice(BigDecimal price) {                                                           //проверка цены
        if ((price.compareTo(minPrice) < 0)) {                                                              //если цена меньше минимальной
            throw new ValidationException("Error! The price can not be less than " + minPrice + '$');       //выбросить исключение
        }
    }

    public void validateDiscount(int discount) {                                                            //проверка скидки
        if (discount > 80 || discount <= 0) {                                                               //если скидка  больше минимально или меньше 0
            throw new ValidationException("Error! Incorrect amount of discount.");                          //выбросить исключение
        }
    }
}
