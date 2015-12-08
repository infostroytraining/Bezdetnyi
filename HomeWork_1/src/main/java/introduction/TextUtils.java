package introduction;

/**
 * Проверка орфографии
 * 
 * Некоторые люди не обращают внимание на орфографию. Например, не пишут новое
 * предложение с заглавной буквы. Или не ставят пробел после знаков препинания.
 * 
 * Ваша задача: исправить их ошибки.
 * 
 * Что нужно сделать:
 * 
 * 1. Каждое новое предложение должно начинаться с заглавной буквы.
 * 2. После знаков препинания (точка и запятая) должны быть пробелы.
 */
public class TextUtils {

	// I suppose there is a way to do it with regular expressions what I don't know
	public String correctText(String text) {
		StringBuilder textBuilder = new StringBuilder(text);
		textBuilder.setCharAt(0, Character.toUpperCase(textBuilder.charAt(0)));
		for (int i = 0; i < text.length(); i++){
			if (textBuilder.charAt(i) == '.' || textBuilder.charAt(i) == ',') {
				if (i + 1 < text.length() && textBuilder.charAt(i + 1) != ' ')
					textBuilder.insert(i + 1, ' ');
			}
			if (textBuilder.charAt(i) == '.')
				if (i + 2 < text.length() && Character.isLowerCase(textBuilder.charAt(i + 2)))
					textBuilder.setCharAt(i + 2, Character.toUpperCase(textBuilder.charAt(i + 2)));
		}
		if (text.charAt(text.length() - 1) != '.')
			textBuilder.append('.');
		return textBuilder.toString();
	}
}
