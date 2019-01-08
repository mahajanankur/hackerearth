package com.blackbox;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Rating {

	private Long ratingId;

	private long oneStarCount;

	private long twoStarCount;

	private long threeStarCount;

	private long fourStarCount;

	private long fiveStarCount;

	private Double avgRating;

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public Long getOneStarCount() {
		return oneStarCount;
	}

	public void setOneStarCount(Long oneStarCount) {
		this.oneStarCount = oneStarCount;
		updateAvgRating();
	}

	public Long getTwoStarCount() {
		return twoStarCount;
	}

	public void setTwoStarCount(Long twoStarCount) {
		this.twoStarCount = twoStarCount;
		updateAvgRating();
	}

	public Long getThreeStarCount() {
		return threeStarCount;
	}

	public void setThreeStarCount(Long threeStarCount) {
		this.threeStarCount = threeStarCount;
		updateAvgRating();
	}

	public Long getFourStarCount() {
		return fourStarCount;
	}

	public void setFourStarCount(Long fourStarCount) {
		this.fourStarCount = fourStarCount;
		updateAvgRating();
	}

	public Long getFiveStarCount() {
		return fiveStarCount;
	}

	public void setFiveStarCount(Long fiveStarCount) {
		this.fiveStarCount = fiveStarCount;
		updateAvgRating();
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public void updateAvgRating() {
		DecimalFormat df = new DecimalFormat("#.#");
		//df.setRoundingMode(RoundingMode.CEILING);
		double dividend = (double) (1 * oneStarCount + 2 * twoStarCount + 3 * threeStarCount + 4 * fourStarCount
				+ 5 * fiveStarCount);
		double sum = (double) (oneStarCount + twoStarCount + threeStarCount + fourStarCount + fiveStarCount);
		System.out.println(dividend / sum);
		this.avgRating = Double.valueOf(df.format(dividend / sum));
	}

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.#");
		System.out.println(df.format(2.762857142857143)); 
		Rating rating = new Rating();
		rating.setFiveStarCount(10L);
		System.out.println(rating.getAvgRating());
		rating.setOneStarCount(25L);
		System.out.println(rating.getAvgRating());
	}

}
