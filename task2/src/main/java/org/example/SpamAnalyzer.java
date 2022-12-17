package org.example;

/* Спам будем фильтровать по наличию указанных ключевых слов в тексте.
 * SpamAnalyzer должен конструироваться от массива строк с ключевыми словами.
 * Объект этого класса должен сохранять в своем состоянии этот массив строк в приватном поле keywords.
 * в случае спама мы получаем их из конструктора
 * в случае нахождения одного из ключевых слов возвращают Label (SPAM и NEGATIVE_TEXT соответственно),
 * а если ничего не нашлось возвращают OK.
 * */
public class SpamAnalyzer extends KeywordAnalyzer {
private final String[] keywords;

public SpamAnalyzer(String[] keywords) {
    this.keywords = keywords;
}

@Override
public String[] getKeywords() {
    return keywords;
}

@Override
public Label getLabel() {
    return Label.SPAM;
}
}
