package ru.job4j.srp;

import ru.job4j.list.List;

import java.nio.file.Path;

/**Нарушение принципов SRP.
 * Необходимо выделить под каждый метод
 * свою абстраццию.
 */

/** @author OlegKorotkiy
 * @version 1.0
 * @since 18.01.2023
 */
public interface Library {
    List<Book> addBook();

    boolean findBook();

    List<Book> deleteBook();

    List<Book> readText(Path file);
}
