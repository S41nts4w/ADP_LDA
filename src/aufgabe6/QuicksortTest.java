package aufgabe6;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuicksortTest {
	private int[] _elemente;

	public QuicksortTest() {
		_elemente = new int[50];
		for (int i = 0; i < _elemente.length; i++) {
			int key = (int) (Math.random() * 101);
			_elemente[i] = key;
		}
	}

	@Test
	public void test() {
		Quicksort qs = new Quicksort(1);

		qs.sortiere(_elemente);

		boolean sortiert = true;

		for (int i = 0; i < _elemente.length - 1; i++) {
			if (_elemente[i] > _elemente[i + 1]) {
				System.out.println(i);
				sortiert = false;
				break;
			}
		}

		assertTrue(sortiert);
	}

}