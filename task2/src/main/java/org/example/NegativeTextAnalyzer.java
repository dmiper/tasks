package org.example;

/* Негативное содержание будем определять по наличию одного из трех смайликов -  :( =( :|.
 * NegativeTextAnalyzer должен конструироваться конструктором по-умолчанию.
 * в случае негативного текста мы заранее знаем набор грустных смайликов
 * в случае нахождения одного из ключевых слов возвращают Label (SPAM и NEGATIVE_TEXT соответственно),
 * а если ничего не нашлось возвращают OK.
 * */
public class NegativeTextAnalyzer extends KeywordAnalyzer {
private final String[] negativeText = {":(", "=(", ":|"};

@Override
public String[] getKeywords() {
    return negativeText;
}

@Override
public Label getLabel() {
    return Label.NEGATIVE_TEXT;
}
}
