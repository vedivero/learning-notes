package class1.ex;

public class MovieReviewMain2 {

    public static void main(String[] args) {

        MovieReview[] movies = new MovieReview[2];

        MovieReview inception = new MovieReview();
        inception.title = "인셉션";
        inception.review = "인생은 무한 반복";
        movies[0] = inception;
        
        MovieReview aboutTime = new MovieReview();
        aboutTime.title = "어바웃타임";
        aboutTime.review = "인생 시간 영화";
        movies[1] = aboutTime;

        for (MovieReview movie : movies) {
            System.out.println( movie.title+ " = " + movie.review);
        }
        
    }
}

