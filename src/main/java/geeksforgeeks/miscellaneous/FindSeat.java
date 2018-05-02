package geeksforgeeks.miscellaneous;

public class FindSeat {

	public static void main(String[] args) {

		int seat = 108;
		int seatIn1Freat = seat % 12;
		int cubical = seat / 12;
		if (seatIn1Freat == 0) {
			seatIn1Freat = 12;
			cubical = cubical - 1;
		}

		int adjescentSeatIn1 = 13 - seatIn1Freat;
		int seatInActual = adjescentSeatIn1 + cubical * 12;
		System.out.println(seatInActual);

		int typeMod = seatInActual % 6;
		if (typeMod == 1 || typeMod == 0) {
			System.out.println("Window");
		}
		if (typeMod == 2 || typeMod == 5) {
			System.out.println("Centre");
		}
		if (typeMod == 3 || typeMod == 4) {
			System.out.println("Side");
		}
	}

}
