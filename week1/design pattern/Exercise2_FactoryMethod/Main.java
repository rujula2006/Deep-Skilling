package Exercise2_FactoryMethod;
public class Main {

    public static void main(String[] args) {

        DocumentFactory factory;

        factory = new WordFactory();

        Document document = factory.createDocument();

        document.open();
    }
}