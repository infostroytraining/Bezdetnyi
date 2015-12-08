package introduction;

public class TriangleUtils {

	/**
	 * Задача о треугольнике
	 * 
	 * Вам даны длинны трех отрезков: a, b, c. Нужно вернуть true, если они
	 * могут быть сторонами треугольника и false, если не могут.
	 *
	 */

	public boolean isTriangle(int a, int b, int c) throws IllegalArgumentException {
		if (a < 0 || b < 0 || c < 0 || a + b + c == 0)
			throw new IllegalArgumentException();
		return !(a + b <= c || b + c <= a || a + c <= b);
	}

	/**
	 * Вам даны длинны трех сторон треугольника: a, b, c. Необходимо вычислить
	 * площадь треугольника.
	 */

	public double getTriangleArea(int a, int b, int c) throws IllegalArgumentException {
		double halfPerimeter = (a + b + c) / 2.0;
		return Math.sqrt(halfPerimeter *
				(halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
	}
}
