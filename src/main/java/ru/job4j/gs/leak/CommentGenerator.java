package ru.job4j.gs.leak;
/*
 генератор комментариев
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommentGenerator implements Generate {

    public static final String PATH_PHRASES = "C:\\projects\\-job4j_design\\src\\main\\java\\ru\\job4j\\gs\\leak\\files\\phrases.txt";
    public static final String SEPARATOR = System.lineSeparator();
    public static final int COUNT = 50;
    private List<Comment> comments = new ArrayList<>();
    private  List<String> phrases;
    private UserGenerator userGenerator;
    private Random random;

    public CommentGenerator(UserGenerator userGenerator, Random random) {
        this.userGenerator = userGenerator;
        this.random = random;
        read();
    }

    private void read() {
        try {
            phrases = read(PATH_PHRASES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void generate() {
        comments.clear();
        for (int i = 0; i < COUNT; i++) {
            String comment  = String.format("%s%s%s%s%s",
                    phrases.get(random.nextInt(phrases.size())), SEPARATOR,
                    phrases.get(random.nextInt(phrases.size())), SEPARATOR,
                    phrases.get(random.nextInt(phrases.size())));
            comments.add(new Comment(comment, userGenerator.randomUser()));
        }
    }
}
