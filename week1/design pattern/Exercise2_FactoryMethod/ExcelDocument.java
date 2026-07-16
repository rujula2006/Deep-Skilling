package Exercise2_FactoryMethod;
public class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Excel Document Opened");
    }
}
