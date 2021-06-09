package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    MovieManager movieManager = new MovieManager();
    private Movie movie = new Movie(1, "https://afisha.yandex.ru", "Бладшот", "боевик");
    private Movie movie1 = new Movie(2, "https://afisha.yandex.ru", "Вперёд", "мультфильм");
    private Movie movie2 = new Movie(3, "https://afisha.yandex.ru", "Отель <<Белград>>", "комедия");
    private Movie movie3 = new Movie(4, "https://afisha.yandex.ru", "Джентльмены", "боевик");
    private Movie movie4 = new Movie(5, "https://afisha.yandex.ru", "Человек-невидимка", "ужасы");
    private Movie movie5 = new Movie(6, "https://afisha.yandex.ru", "Тролли. Мировой тур", "мультфильм");
    private Movie movie6 = new Movie(7, "https://afisha.yandex.ru", "Форсаж 9", "комедиябоевик");
    private Movie movie7 = new Movie(8, "https://afisha.yandex.ru", "Прабабушка легкого поведения", "комедия");
    private Movie movie8 = new Movie(9, "https://afisha.yandex.ru", "Номер один", "комедия");
    private Movie movie9 = new Movie(10, "https://afisha.yandex.ru", "Девятаев", "биография");
    private Movie movie10 = new Movie(11, "https://afisha.yandex.ru", "Мортал комбат", "фэнтези");

    @BeforeEach
    public void setUp() {
        movieManager.add(movie);
        movieManager.add(movie1);
        movieManager.add(movie2);
        movieManager.add(movie3);
        movieManager.add(movie4);
        movieManager.add(movie5);
        movieManager.add(movie6);
        movieManager.add(movie7);
        movieManager.add(movie8);
        movieManager.add(movie9);
    }

    @Test
    public void shouldShowWhatsThere4() {
        Movie item = new Movie(10, "https://afisha.yandex.ru", "Девятаев", "биография");
        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1, movie};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowIf5() {
        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1, movie};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMinus1() {
        MovieManager manager = new MovieManager(-1);
        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1, movie};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow0() {
        MovieManager manager = new MovieManager(0);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFilmsWithLimit() {
        MovieManager manager = new MovieManager(5);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{movie9, movie8, movie7, movie6, movie5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDefaultValues() {
        MovieManager manager = new MovieManager();
        manager.add(movie10);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }
}