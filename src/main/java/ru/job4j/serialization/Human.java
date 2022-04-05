package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "human")
@XmlAccessorType(XmlAccessType.FIELD)
public class Human {

    @XmlAttribute
    private boolean flag;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private String name;
    Contact contact;

    @XmlElementWrapper
    @XmlElement(name = "number")
    int[] numbers;

    public Human() {
    }

    public Human(boolean flag, int age, String name, Contact contact, int[] number) {
        this.flag = flag;
        this.age = age;
        this.name = name;
        this.contact = contact;
        this.numbers = number;
    }

    @Override
    public String toString() {
        return "Human{"
                + "flag=" + flag
                + ", age=" + age
                + ", name='" + name
                + '\'' + ", contact=" + contact
                + ", numbers=" + Arrays.toString(numbers)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Human human = new Human(false, 30, "Ivan",
                new Contact(123456, "+7 (000) 000-00-00"), new int[] {1, 2, 3});
        JAXBContext context = JAXBContext.newInstance(Human.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(human, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
