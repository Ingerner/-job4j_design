package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class GeneratorLibraryTest {

    @Test
    public void whenValueInsteadOfKeys() {
        Generator generator = new GeneratorLibrary();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject ", "you");
        String rsl = generator.produce("I am a ${name}, Who are ${subject}? ", map);
        assertThat(rsl).isEqualTo("I am a Petr Arsentev, Who are you? ");
    }

    @Test
    public void whenTheTemplateHasKeysThatAreNotInTheMapWeThrowAnException() {
        Generator generator = new GeneratorLibrary();
        Map<String, String> map = new HashMap<>();
        map.put("name1", "Petr Arsentev");
        map.put("subject1 ", "you");
        assertThatThrownBy(() -> generator.produce("I am a ${name}, Who are ${subject}? ", map)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenTheMapHasExtraKeysWeThrowAnException() {
        Generator generator = new GeneratorLibrary();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject ", "you");
        map.put("key", "");
        assertThatThrownBy(() -> generator.produce("I am a ${name}, Who are ${subject}? ", map)).
                isInstanceOf(IllegalArgumentException.class);
    }


}