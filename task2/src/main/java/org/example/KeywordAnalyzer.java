package org.example;

/* Выделим два абстрактных метода getKeywords и getLabel,
 * один из которых будет возвращать набор ключевых слов,
 * а второй метку, которой необходимо пометить положительные срабатывания.
 * Нам незачем показывать эти методы потребителям классов, поэтому оставим доступ к ним только для наследников.
 * Реализуем processText таким образом, чтобы он зависел только от getKeywords и getLabel.
 * Сделаем SpamAnalyzer и NegativeTextAnalyzer наследниками KeywordAnalyzer и реализуем абстрактные методы.
 * */
public abstract class KeywordAnalyzer implements TextAnalyzer {
protected abstract String[] getKeywords();

protected abstract Label getLabel();

public Label processText(String text) {
    String[] keywords = getKeywords();
    for (String keyword : keywords) {
        if (text.contains(keyword)) {
            return getLabel();
        }
    }
    return Label.OK;
}
}
