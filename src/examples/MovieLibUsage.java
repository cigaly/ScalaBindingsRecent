package examples;

import org.junit.Test;

import rx.Observable;
import rx.util.functions.Action1;
//import rx.lang.scala.examples;

/*
public class MovieLibUsage {

Action1<rx.lang.scala.examples.Movie> moviePrinter = new Action1<rx.lang.scala.examples.Movie>() {
   public void call(rx.lang.scala.examples.Movie m) {
        System.out.println("A movie of length " + m.lengthInSeconds() + "s");
    }
};

    @Test
    public void test() {
        rx.lang.scala.examples.MovieLib lib = new rx.lang.scala.examples.MovieLib(
                Observable.from(new rx.lang.scala.examples.Movie(3000),
                        new rx.lang.scala.examples.Movie(1000),
                        new rx.lang.scala.examples.Movie(2000)));

        lib.longMovies().subscribe(moviePrinter);
    }

}
*/