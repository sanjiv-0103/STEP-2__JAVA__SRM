class Post {
    String author, content, time;

    Post(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    void display() {
        System.out.println(author + " @ " + time + "\n" + content + "\n");
    }
}

class InstagramPost extends Post {
    int likes;
    String hashtags;

    InstagramPost(String a, String c, String t, int likes, String hashtags) {
        super(a, c, t);
        this.likes = likes;
        this.hashtags = hashtags;
    }

    @Override
    void display() {
        System.out.println(" Instagram");
        System.out.println(author + " • " + time);
        System.out.println(content);
        System.out.println(hashtags + "\n " + likes + " likes\n");
    }
}

// Twitter: character count + retweets
class TwitterPost extends Post {
    int retweets;

    TwitterPost(String a, String c, String t, int retweets) {
        super(a, c, t);
        this.retweets = retweets;
    }

    @Override
    void display() {
        System.out.println(" Twitter");
        System.out.println(author + " • " + time + " • " + content.length() + " chars");
        System.out.println(content + "\n " + retweets + " retweets\n");
    }
}

class LinkedInPost extends Post {
    int connections;

    LinkedInPost(String a, String c, String t, int connections) {
        super(a, c, t);
        this.connections = connections;
    }

    @Override
    void display() {
        System.out.println("💼 LinkedIn");
        System.out.println(author + " • " + connections + " connections • " + time);
        System.out.println("\"" + content + "\"\n— Professional update —\n");
    }
}

public class SocialFeed {
    public static void main(String[] args) {
        Post p1 = new InstagramPost("Janani", "Sunset vibes!", "10:15 AM", 342, "#travel #sunset");
        Post p2 = new TwitterPost("Janani", "Java overriding is neat.", "11:05 AM", 27);
        Post p3 = new LinkedInPost("Janani", "Excited to start my new role!", "2:30 PM", 500);

        p1.display();
        p2.display();
        p3.display();
    }
}
