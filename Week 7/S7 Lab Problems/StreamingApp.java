class Content {
    String title;

    Content(String title) {
        this.title = title;
    }

    void play() {
        System.out.println("Playing: " + title);
    }
}

class Movie extends Content {
    Movie(String title) {
        super(title);
    }

    void showMovieInfo() {
        System.out.println("This is a Movie with ratings and subtitles.");
    }
}

class TVSeries extends Content {
    TVSeries(String title) {
        super(title);
    }

    void showSeriesInfo() {
        System.out.println("This is a TV Series with seasons and episodes.");
    }
}

class Documentary extends Content {
    Documentary(String title) {
        super(title);
    }

    void showDocInfo() {
        System.out.println("This is a Documentary with educational tags.");
    }
}

public class StreamingApp {
    public static void main(String[] args) {
        Content[] watchlist = {
                new Movie("Inception"),
                new TVSeries("Friends"),
                new Documentary("Our Planet")
        };

        for (Content c : watchlist) {
            c.play();

            if (c instanceof Movie) {
                ((Movie) c).showMovieInfo();
            } else if (c instanceof TVSeries) {
                ((TVSeries) c).showSeriesInfo();
            } else if (c instanceof Documentary) {
                ((Documentary) c).showDocInfo();
            }
            System.out.println();
        }
    }
}
